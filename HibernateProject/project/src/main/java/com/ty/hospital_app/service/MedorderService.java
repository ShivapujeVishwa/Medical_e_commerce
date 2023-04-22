package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.MedorderDaoImp;
import com.ty.hospital_app.dto.Medorder;

public class MedorderService {
	public void saveMedorder(Medorder medorder, int eid) {
		MedorderDaoImp mdi = new MedorderDaoImp();
		Medorder medorder1 = mdi.saveMedorder(eid, medorder);
		if (medorder1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Medorder getMedorderById(int mid) {
		MedorderDaoImp mdi = new MedorderDaoImp();
		Medorder medorder = mdi.getMedorderById(mid);
		if (medorder != null) {
			return medorder;
		} else {
			return null;
		}
	}

	public void deleteMedorderById(int mid) {
		MedorderDaoImp mdi = new MedorderDaoImp();
		boolean flag = mdi.deleteMedorderByid(mid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Medorder updateMedorderById(int mid, Medorder medorder) {
		MedorderDaoImp mdi = new MedorderDaoImp();
		Medorder medorder1 = mdi.updateMedorderById(mid, medorder);
		if (medorder1 != null) {
			return medorder1;
		} else {
			return null;
		}
	}

	public List<Medorder> getAllBranch() {
		MedorderDaoImp bdi = new MedorderDaoImp();
		List<Medorder> medorder = bdi.getAllMedorder();
		if (medorder != null) {
			return medorder;
		} else {
			return null;
		}
	}

	public List<Medorder> getMeorderByDoctorName(String dname) {
		MedorderDaoImp bdi = new MedorderDaoImp();
		List<Medorder> medorder = bdi.getMedorderByDocterName(dname);
		if (medorder != null) {
			return medorder;
		} else {
			return null;
		}
	}

}
