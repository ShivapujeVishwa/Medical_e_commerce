package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.ObservationDaoImp;
import com.ty.hospital_app.dto.Observation;

public class ObservationService {
	public void saveObservation(Observation observation, int eid) {
		ObservationDaoImp odi = new ObservationDaoImp();
		Observation observation1 = odi.saveObservation(eid, observation);
		if (observation1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Observation getObservationById(int oid) {
		ObservationDaoImp odi = new ObservationDaoImp();
		Observation observation = odi.getObservationById(oid);
		if (observation != null) {
			return observation;
		} else {
			return null;
		}
	}

	public void deleteObservationById(int oid) {
		ObservationDaoImp odi = new ObservationDaoImp();
		boolean flag = odi.deleteObservationByid(oid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Observation updateObservationById(int o_id, Observation observation) {
		ObservationDaoImp odi = new ObservationDaoImp();
		Observation observation1 = odi.updateObservationById(o_id, observation);
		if (observation1 != null) {
			return observation1;
		} else {
			return null;
		}
	}

	public List<Observation> getAllObservation() {
		ObservationDaoImp odi = new ObservationDaoImp();
		List<Observation> observations = odi.getAllObservation();
		if (observations != null) {
			return observations;
		} else {
			return null;
		}
	}

	public List<Observation> getObservationsByDoctorname(String name) {
		ObservationDaoImp odi = new ObservationDaoImp();
		List<Observation> observations = odi.getObservationByDocterName(name);
		if (observations != null) {
			return observations;
		} else {
			return null;
		}
	}

}
