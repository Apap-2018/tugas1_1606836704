package com.apap.tugas1.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1.model.JabatanPegawaiModel;

/**
 * 
 * @author Winda
 *
 */
public interface JabatanPegawaiDB extends JpaRepository<JabatanPegawaiModel, BigInteger>{
	
}
