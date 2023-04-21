package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.dao.ItemsDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Items;
import com.ty.hospital_app.dto.Medorder;

public class ItemsDaoImp implements ItemsDao {

	public Items saveItem(int mid, Items items) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Medorder medorder = em.find(Medorder.class, mid);
		if (medorder != null) {
			et.begin();
			em.persist(items);
			et.commit();
			return items;
		}

		return null;
	}

	public Items getItemsById(int iid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		Items items = em.find(Items.class, iid);
		return items;
	}

	public boolean deleteItemsByid(int iid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Items items = em.find(Items.class, iid);
		if (items != null) {
			et.begin();
			em.remove(items);
			et.commit();
			return true;

		}
		return false;
	}

	public Items updateItemsById(int iid, Items items) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Items items1 = em.find(Items.class, iid);

		if (items1 != null) {
			items1.setCost(items.getCost());
			items1.setName(items.getName());
			et.begin();
			em.persist(items1);
			et.commit();
			return items1;

		}
		return null;
	}

	public List<Items> getAllItems() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		javax.persistence.Query query = em.createQuery("select s from Items s");
		List<Items> items = query.getResultList();

		return items;
	}

}
