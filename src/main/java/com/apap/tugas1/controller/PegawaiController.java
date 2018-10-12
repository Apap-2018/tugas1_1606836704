package com.apap.tugas1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.PegawaiService;
/**
 * 
 * @author Winda
 *
 */
@Controller
public class PegawaiController {
	@Autowired
	private PegawaiService pegawaiService;
	
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
}
