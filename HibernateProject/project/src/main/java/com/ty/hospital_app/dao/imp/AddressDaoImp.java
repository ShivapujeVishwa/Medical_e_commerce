package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.dao.AddressDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;

public class AddressDaoImp implements AddressDao {

	public Address saveAddress(int bid, Address address) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Branch branch = em.find(Branch.class, bid);
		if (branch != null) {
			et.begin();
			em.persist(address);
			et.commit();
			return address;
		}

		return null;
	}

	public Address getAddressById(int aid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		Address address = em.find(Address.class, aid);
		return address;
	}

	public boolean deleteAddressByid(int aid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Address address = em.find(Address.class, aid);
		if (address != null) {
			et.begin();
			em.remove(address);
			et.commit();
			return true;

		}
		return false;
	}

	public Address updateAddressById(int aid, Address address) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Address address1 = em.find(Address.class, aid);

		if (address1 != null) {
			address1.setBranch(address.getBranch());
			address1.setState(address.getState());
			et.begin();
			em.persist(address1);
			et.commit();
			return address1;

		}
		return null;
	}

	public List<Address> getAddressAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		javax.persistence.Query query = em.createQuery("select s from Address s");
		List<Address> address = query.getResultList();

		return address;
	}

}
