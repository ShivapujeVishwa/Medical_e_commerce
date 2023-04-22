package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.EncounterDaoImp;
import com.ty.hospital_app.dto.Encounter;

public class EncounterService {
	public void saveEncounter(Encounter encounter, int bid) {
		EncounterDaoImp daoImp = new EncounterDaoImp();
		Encounter encounter1 = daoImp.saveEncounter(bid, encounter);
		if (encounter1 != null) {
			System.out.println("Encounter saved");
		} else {
			System.out.println("Encounter not saved");
		}
	}

	public Encounter getEncounterById(int eid) {
		EncounterDaoImp daoImp = new EncounterDaoImp();
		Encounter encounter1 = daoImp.getEncounterById(eid);
		if (encounter1 != null) {
			return encounter1;
		}
		return null;
	}

	public void deleteEncounterById(int eid) {
		EncounterDaoImp daoImp = new EncounterDaoImp();
		boolean flag = daoImp.deleteEncounterByid(eid);
		if (flag) {
			System.out.println("Encounter deleted");
		} else {
			System.out.println("Encounter  not deleted");
		}
	}

	public Encounter updateEncounterById(int eid, Encounter encounter) {
		EncounterDaoImp daoImp = new EncounterDaoImp();
		Encounter encounter1 = daoImp.updateEncounterById(eid, encounter);
		if (encounter1 != null) {
			return encounter1;
		}
		return null;
	}
	public List<Encounter> getAllEncounter() {
		EncounterDaoImp edi = new EncounterDaoImp();
		List<Encounter> encounters = edi.getAllEncounter();
		if (encounters != null) {
			return encounters;
		} else {
			return null;
		}
	}

}
