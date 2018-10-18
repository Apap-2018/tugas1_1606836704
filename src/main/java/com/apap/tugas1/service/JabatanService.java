package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.apap.tugas1.model.JabatanModel;

/**
 * 
 * @author Winda
 *
 */
public interface JabatanService {
	void addJabatan(JabatanModel jabatan);
	List<JabatanModel> getJabatan(); 
	Optional<JabatanModel> getJabatanById(BigInteger id);
}
