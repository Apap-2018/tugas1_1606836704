package com.apap.tugas1.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1.model.ProvinsiModel;

/**
 * 
 * @author Winda
 *
 */
public interface ProvinsiDB extends JpaRepository<ProvinsiModel, Integer>{
	ProvinsiModel findById(int id);
}
