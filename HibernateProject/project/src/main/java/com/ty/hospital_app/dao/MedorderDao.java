package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Medorder;

public interface MedorderDao {
	public Medorder saveMedorder(int eid, Medorder medorder);

	public Medorder getMedorderById(int mid);

	public boolean deleteMedorderByid(int mid);

	public Medorder updateMedorderById(int mid, Medorder medorder);

	public List<Medorder> getAllMedorder();

	public List<Medorder> getMedorderByDocterName(String dname);

}
