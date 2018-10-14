package com.apap.tugas1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.ProvinsiDB;
/**
 * 
 * @author Winda
 *
 */
@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService{
	@Autowired
	private ProvinsiDB provinsiDB;
	
	@Override
	public List<ProvinsiModel> getProvinsi() {
		return provinsiDB.findAll();
	}

	@Override
	public ProvinsiModel getProvinsiById(int id) {
		return provinsiDB.findById(id);
	}

}
