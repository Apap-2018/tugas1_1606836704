package com.apap.tugas1.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1.model.PegawaiModel;

/**
 * 
 * @author Winda
 *
 */
public interface ProvinsiDB extends JpaRepository<PegawaiModel, BigInteger>{

}
