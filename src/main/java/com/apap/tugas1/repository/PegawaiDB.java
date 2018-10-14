package com.apap.tugas1.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1.model.PegawaiModel;

/**
 * 
 * @author Winda
 *
 */
public interface PegawaiDB extends JpaRepository<PegawaiModel, BigInteger>{
	PegawaiModel findBynip(String nip);
	List<PegawaiModel> findByTanggalLahirAndTahunMasuk(Date tanggalLahir, String tahunMasuk);
}
