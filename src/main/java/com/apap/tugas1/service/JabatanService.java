package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;

/**
 * 
 * @author Winda
 *
 */
public interface JabatanService {
	void addJabatan(JabatanModel jabatan);
	List<JabatanModel> getJabatan(); 
}
