package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.dao.BranchDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;

public class BranchDaoImp implements BranchDao {

	public Branch saveBranch(int hid, Branch branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Hospital hospital = em.find(Hospital.class, hid);
		if (hospital != null) {
			et.begin();
			em.persist(branch);
			et.commit();
			return branch;
		}

		return null;
	}

	public Branch getBranchById(int bid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		Branch branch = em.find(Branch.class, bid);

		return branch;
	}

	public boolean deleteBranchByid(int bid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Branch branch = em.find(Branch.class, bid);
		if (branch != null) {
			et.begin();
			em.remove(branch);
			et.commit();
			return true;

		}

		return false;
	}

	public Branch updateBranchById(int bid, Branch branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Branch branch1 = em.find(Branch.class, bid);

		if (branch1 != null) {
			branch1.setBranch_name(branch.getBranch_name());
			branch1.setEmail(branch.getEmail());
			et.begin();
			em.persist(branch1);
			et.commit();
			return branch1;

		}

		return null;

	}

	public List<Branch> getAllBranch() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		javax.persistence.Query query = em.createQuery("select s from Branch s");
		List<Branch> branch = query.getResultList();

		return branch;
	}

}
