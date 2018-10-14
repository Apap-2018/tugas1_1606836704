package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.ProvinsiModel;
/**
 * 
 * @author Winda
 *
 */
public interface ProvinsiService {
	List<ProvinsiModel> getProvinsi();
	ProvinsiModel getProvinsiById(int id);
}
