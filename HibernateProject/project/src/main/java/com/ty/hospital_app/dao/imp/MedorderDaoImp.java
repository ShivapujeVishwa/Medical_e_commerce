package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.dao.MedorderDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Medorder;

public class MedorderDaoImp implements MedorderDao {

	public Medorder saveMedorder(int eid, Medorder medorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, eid);
		if (encounter != null) {
			et.begin();
			em.persist(medorder);
			et.commit();
			return medorder;
		}

		return null;

	}

	public Medorder getMedorderById(int mid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		Medorder medorder = em.find(Medorder.class, mid);
		return medorder;

	}

	public boolean deleteMedorderByid(int mid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Medorder medorder = em.find(Medorder.class, mid);
		if (medorder != null) {
			et.begin();
			em.remove(medorder);
			et.commit();
			return true;

		}
		return false;
	}

	public Medorder updateMedorderById(int mid, Medorder medorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Medorder medorder1 = em.find(Medorder.class, mid);

		if (medorder1 != null) {
			medorder1.setDname(medorder.getDname());
			medorder1.setOrderDate(medorder1.getOrderDate());
			et.begin();
			em.persist(medorder1);
			et.commit();
			return medorder1;

		}
		return null;
	}

	public List<Medorder> getAllMedorder() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		javax.persistence.Query query = em.createQuery("select s from Medorder s");
		List<Medorder> medorder = query.getResultList();

		return medorder;
	}

	public List<Medorder> getMedorderByDocterName(String dname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		javax.persistence.Query query = em.createQuery("select m from Medorder m where m.dname");
		query.setParameter(1, dname);
		List<Medorder> medorders = query.getResultList();
		et.commit();
		return medorders;
	}

}
