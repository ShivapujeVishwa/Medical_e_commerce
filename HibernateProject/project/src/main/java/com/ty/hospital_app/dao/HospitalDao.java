package com.ty.hospital_app.dao;

import com.ty.hospital_app.dto.Hospital;

public interface HospitalDao {
	public Hospital saveHospital(Hospital hospital);

	public Hospital getHospitalById(int hid);

	public boolean deleteHospitalByid(int hid);

	public Hospital updateHospitalById(int hid, Hospital hospital);

}
