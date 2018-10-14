package com.apap.tugas1.service;

import java.util.Date;
import java.util.List;

import com.apap.tugas1.model.PegawaiModel;
/**
 * 
 * @author Winda
 *
 */
public interface PegawaiService {
	void addPegawai(PegawaiModel pegawai);
	PegawaiModel getPegawaiByNIP(String nip);
	List<PegawaiModel> getPegawaiByTanggalLahirAndTahunMasuk(Date tanggalLahir, String tahunMasuk);
}
