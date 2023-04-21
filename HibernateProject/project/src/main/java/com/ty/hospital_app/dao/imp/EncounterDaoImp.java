package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.dao.EncounterDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Encounter;

public class EncounterDaoImp implements EncounterDao {

	public Encounter saveEncounter(int bid, Encounter encounter) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Branch branch = em.find(Branch.class, bid);
		if (branch != null) {
			et.begin();
			em.persist(encounter);
			et.commit();
			return encounter;
		}

		return null;
	}

	public Encounter getEncounterById(int eid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		Encounter encounter = em.find(Encounter.class, eid);
		return encounter;
	}

	public boolean deleteEncounterByid(int eid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, eid);
		if (encounter != null) {
			et.begin();
			em.remove(encounter);
			et.commit();
			return true;

		}
		return false;
	}

	public Encounter updateEncounterById(int eid, Encounter encounter) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Encounter encounter1 = em.find(Encounter.class, eid);

		if (encounter1 != null) {
			encounter1.setDOJ(encounter.getDOJ());
			encounter1.setReason(encounter.getReason());
			et.begin();
			em.persist(encounter1);
			et.commit();
			return encounter1;

		}
		return null;
	}

	public List<Encounter> getAllEncounter() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		javax.persistence.Query query = em.createQuery("select s from Encounter s");
		List<Encounter> encounter = query.getResultList();

		return encounter;
	}

}
