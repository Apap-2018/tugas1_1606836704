package com.apap.tugas1.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.PegawaiDB;
/**
 * 
 * @author Winda
 *
 */
@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService{
	@Autowired
	private PegawaiDB pegawaiDB;
	
	@Override
	public PegawaiModel getPegawaiByNIP(String nip) {
		return pegawaiDB.findBynip(nip);
	}

	@Override
	public List<PegawaiModel> getPegawaiByInstansiAndTanggalLahirAndTahunMasuk(InstansiModel instansi, Date tanggalLahir, String tahunMasuk) {
		return pegawaiDB.findByInstansiAndTanggalLahirAndTahunMasuk(instansi, tanggalLahir, tahunMasuk);
	}

	@Override
	public void addPegawai(PegawaiModel pegawai) {
		pegawaiDB.save(pegawai);
	}

	@Override
	public void updatePegawai(String nip, PegawaiModel pegawai) {
		PegawaiModel updatePegawai = pegawaiDB.findBynip(nip);
		updatePegawai.setNama(pegawai.getNama());
		updatePegawai.setNip(pegawai.getNip());
		updatePegawai.setTanggalLahir(pegawai.getTanggalLahir());
		updatePegawai.setTempatLahir(pegawai.getTempatLahir());
		updatePegawai.setTahunMasuk(pegawai.getTahunMasuk());
		updatePegawai.setInstansi(pegawai.getInstansi());
		updatePegawai.setJabatan(pegawai.getJabatan());
		pegawaiDB.save(updatePegawai);
	}

	@Override
	public List<PegawaiModel> getPegawaiByInstansiAndJabatan(InstansiModel instansi, JabatanModel jabatan) {
		return pegawaiDB.findByInstansiAndJabatan(instansi, jabatan);
	}

	@Override
	public List<PegawaiModel> getPegawaiByInstansi(InstansiModel instansi) {
		return pegawaiDB.findByInstansi(instansi);
	}

}
