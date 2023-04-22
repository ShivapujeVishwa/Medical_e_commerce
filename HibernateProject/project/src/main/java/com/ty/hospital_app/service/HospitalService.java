package com.ty.hospital_app.service;

import org.hibernate.boot.model.relational.Database;

import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dto.Hospital;

public class HospitalService {
	public void saveHospital(Hospital hospital) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital1 = daoImp.saveHospital(hospital);
		if (hospital1 != null) {
			System.out.println("data saved");
		} else {
			System.out.println("data not saved");
		}
	}

	public Hospital getHospitalById(int hid) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital = daoImp.getHospitalById(hid);
		if (hospital != null) {
			return hospital;
		}
		return null;
	}
	public void deleteHospitalById(int hid) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		boolean flag=daoImp.deleteHospitalByid(hid);
		if(flag) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not deleted");
		}
	}
	public Hospital updateHospitalById(int hid,Hospital hospital) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital1 = daoImp.updateHospitalById(hid, hospital);
		if(hospital1!=null) {
			return hospital1;
		}
		return null;
	}

}
