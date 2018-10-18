package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.ProvinsiModel;
/**
 * 
 * @author Winda
 *
 */
public interface InstansiService {
	List<InstansiModel> getInstansi();
	Optional<InstansiModel> getInstansiById(BigInteger idInstansi);
	List<InstansiModel> getInstansiByProvinsi(ProvinsiModel provinsi);
}
