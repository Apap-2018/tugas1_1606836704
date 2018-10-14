package com.apap.tugas1.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
import com.apap.tugas1.service.ProvinsiService;
/**
 * 
 * @author Winda
 *
 */
@Controller
public class PegawaiController {
	@Autowired
	private PegawaiService pegawaiService;
	
	@Autowired
	private ProvinsiService provinsiService;
	
	@Autowired
	private InstansiService instansiService;
	
	@Autowired
	private JabatanService jabatanService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pegawai", method = RequestMethod.GET)
	private String viewPilot(@RequestParam("nip") String nip, Model model) {
		PegawaiModel pegawai = pegawaiService.getPegawaiByNIP(nip);
		double tunjangan = (pegawai.getInstansi().getProvinsi().getPresentaseTunjangan())/100;
		double gajiTerbesar = 0;
		for(JabatanModel jabatan : pegawai.getJabatan()) {
			double gajiPokok = jabatan.getGajiPokok();
			double gaji = gajiPokok + (tunjangan*gajiPokok);
		
			if(gaji > gajiTerbesar) gajiTerbesar = gaji;
		}
		model.addAttribute("gaji", (int)gajiTerbesar);
		model.addAttribute("pegawai", pegawai);
		return "view-pegawai";
	}
	
	@RequestMapping(value = "/pegawai/tambah", method = RequestMethod.GET)
	private String add(Model model) {
		List<ProvinsiModel> listProv = provinsiService.getProvinsi();
		List<JabatanModel> listJabatan = jabatanService.getJabatan();
		
		//default
		List<InstansiModel> listInstansi = instansiService.getInstansiByProvinsi(listProv.get(0));
		
		PegawaiModel pegawai = new PegawaiModel();
		pegawai.setJabatan(new ArrayList<JabatanModel>());
		pegawai.getJabatan().add(new JabatanModel());
		
		model.addAttribute("pegawai", pegawai);
		model.addAttribute("listInstansi", listInstansi);
		model.addAttribute("listJabatan", listJabatan);
		model.addAttribute("listProvinsi", listProv);
		return "add-pegawai";
	}
	
	@RequestMapping(value="/pegawai/tambah", params={"addRow"}, method = RequestMethod.POST)
	public String addRow(@ModelAttribute PegawaiModel pegawai, BindingResult bindingResult, Model model) {
		
		List<ProvinsiModel> listProv = provinsiService.getProvinsi();
		List<JabatanModel> listJabatan = jabatanService.getJabatan();
		
		model.addAttribute("listJabatan", listJabatan);
		model.addAttribute("listProvinsi", listProv);
		
		
		pegawai.getJabatan().add(new JabatanModel());
	    model.addAttribute("pegawai", pegawai);
	    return "add-pegawai";
	}
	
	@RequestMapping(value="/pegawai/tambah", params={"deleteRow"}, method = RequestMethod.POST)
	public String deleteRow(@ModelAttribute PegawaiModel pegawai, BindingResult bindingResult, HttpServletRequest req,Model model) {
		
		List<ProvinsiModel> listProv = provinsiService.getProvinsi();
		List<InstansiModel> listInstansi = instansiService.getInstansi();
		List<JabatanModel> listJabatan = jabatanService.getJabatan();
		
		model.addAttribute("listInstansi", listInstansi);
		model.addAttribute("listJabatan", listJabatan);
		model.addAttribute("listProvinsi", listProv);
		
		Integer rowId = Integer.valueOf(req.getParameter("deleteRow"));
		System.out.println(rowId);
		pegawai.getJabatan().remove(rowId.intValue());
	    model.addAttribute("pegawai", pegawai);
	    return "add-pegawai";
	}
	
	@RequestMapping(value = "/pegawai/tambah", method = RequestMethod.POST)
	private String addPegawaiSubmit(@ModelAttribute PegawaiModel pegawai, Model model) {
		/**
		 * NIP terdiri dari 16 digit.
		● 4 digit awal merupakan kode instansi, terdiri dari 2 digit pertama merupakan kode
		provinsi, 2 digit berikutnya adalah nomor urut instansi di provinsi tersebut.
		● 6 digit setelahnya merupakan tanggal lahir pegawai (dd-MM-yy).
		● 4 digit setelahnya merupakan tahun pegawai mulai bekerja di instansi tersebut.
		● 2 digit terakhir adalah nomor berdasarkan urutan pegawai yang memiliki tanggal lahir
		dan tahun mulai bekerja yang sama.
		 */
		String kode = pegawai.getInstansi().getId().toString();
		
		SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yy");
		String tanggalLahir = newFormat.format(pegawai.getTanggalLahir()).replaceAll("-", "");
		
		String tahunKerja = pegawai.getTahunMasuk();
		
		String urutan = ""+pegawaiService.getPegawaiByTanggalLahirAndTahunMasuk(pegawai.getTanggalLahir(), pegawai.getTahunMasuk()).size()+1;
		
		String nip = kode + tanggalLahir + tahunKerja + urutan;
		
		pegawai.setNip(nip);
		
		pegawaiService.addPegawai(pegawai);
		model.addAttribute("nip", nip);
		return "add";
	}
}
