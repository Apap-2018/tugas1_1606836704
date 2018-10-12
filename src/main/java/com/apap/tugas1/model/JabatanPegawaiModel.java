package com.apap.tugas1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * 
 * @author Winda
 *
 */
@Entity
@Table(name="jabatan_pegawai")
public class JabatanPegawaiModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pegawai_id",referencedColumnName = "id", nullable = false)
//    @OnDelete(action = OnDeleteAction.NO_ACTION)
//    private PegawaiModel pegawai;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "jabatan_id",referencedColumnName = "id", nullable = false)
//    @OnDelete(action = OnDeleteAction.NO_ACTION)
//    private JabatanModel jabatan;
}
