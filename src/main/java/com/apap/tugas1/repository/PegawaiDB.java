package com.apap.tugas1.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;

/**
 * 
 * @author Winda
 *
 */
public interface PegawaiDB extends JpaRepository<PegawaiModel, BigInteger>{
	PegawaiModel findBynip(String nip);
	List<PegawaiModel> findByInstansiAndTanggalLahirAndTahunMasuk(InstansiModel instansi, Date tanggalLahir, String tahunMasuk);
	List<PegawaiModel> findByInstansiAndJabatan(@Nullable InstansiModel instansi, @Nullable JabatanModel jabatan);
	List<PegawaiModel> findByInstansi(InstansiModel instansi);
}
