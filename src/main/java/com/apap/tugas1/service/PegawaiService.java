package com.apap.tugas1.service;

import java.util.Date;
import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
/**
 * 
 * @author Winda
 *
 */
public interface PegawaiService {
	void addPegawai(PegawaiModel pegawai);
	void updatePegawai(String nip, PegawaiModel pegawai);
	PegawaiModel getPegawaiByNIP(String nip);
	List<PegawaiModel> getPegawaiByInstansiAndTanggalLahirAndTahunMasuk(InstansiModel instansi, Date tanggalLahir, String tahunMasuk);
}
