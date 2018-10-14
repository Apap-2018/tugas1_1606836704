package com.apap.tugas1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<PegawaiModel> getPegawaiByTanggalLahirAndTahunMasuk(Date tanggalLahir, String tahunMasuk) {
		return pegawaiDB.findByTanggalLahirAndTahunMasuk(tanggalLahir, tahunMasuk);
	}

	@Override
	public void addPegawai(PegawaiModel pegawai) {
		pegawaiDB.save(pegawai);
	}

}
