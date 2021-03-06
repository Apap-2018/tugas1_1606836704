package com.apap.tugas1.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugas1.model.JabatanModel;


/**
 * 
 * @author Winda
 *
 */
@Repository
public interface JabatanDB extends JpaRepository<JabatanModel, BigInteger> {
	void deleteById(BigInteger id);
}
