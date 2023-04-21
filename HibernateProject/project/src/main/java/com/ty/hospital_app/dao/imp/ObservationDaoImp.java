package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.dao.ObservationDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Observation;

public class ObservationDaoImp implements ObservationDao {

	public Observation saveObservation(int eid, Observation observation) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, eid);
		if (encounter != null) {
			et.begin();
			em.persist(observation);
			et.commit();
			return observation;
		}

		return null;
	}

	public Observation getObservationById(int oid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		Observation observation = em.find(Observation.class, oid);
		return observation;
	}

	public boolean deleteObservationByid(int oid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Observation observation = em.find(Observation.class, oid);
		if (observation != null) {
			et.begin();
			em.remove(observation);
			et.commit();
			return true;

		}
		return false;
	}

	public Observation updateObservationById(int oid, Observation observation) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Observation observation1 = em.find(Observation.class, oid);

		if (observation1 != null) {
			observation1.setRobservation(observation.getRobservation());
			observation1.setDname(observation.getDname());
			et.begin();
			em.persist(observation1);
			et.commit();
			return observation1;

		}
		return null;
	}

	public List<Observation> getAllObservation() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		javax.persistence.Query query = em.createQuery("select s from Observation s");
		List<Observation> observation = query.getResultList();

		return observation;
	}

	public List<Observation> getObservationByDocterName(String dname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		javax.persistence.Query query = em.createQuery("select o from Observation o where o.dname=?1");
		query.setParameter(1, dname);
		List<Observation> observations = query.getResultList();
		et.commit();
		return observations;
		
	}

}
