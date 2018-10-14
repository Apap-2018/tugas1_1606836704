package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.ProvinsiModel;
/**
 * 
 * @author Winda
 *
 */
public interface InstansiService {
	List<InstansiModel> getInstansi();
	List<InstansiModel> getInstansiByProvinsi(ProvinsiModel provinsi);
}
