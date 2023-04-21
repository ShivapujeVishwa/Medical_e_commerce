package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.userDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.dto.User;

public class userDaoImp implements userDao {

	public User saveUser(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();

		return user;
	}

	public User getUserById(int uid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, uid);

		return user;
	}

	public boolean deleteUserByid(int uid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		User user = em.find(User.class, uid);
		if (user != null) {
			et.begin();
			em.remove(user);
			et.commit();
			return true;

		}

		return false;
	}

	public User updateUserById(int uid, User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		User user1 = em.find(User.class, uid);

		if (user1 != null) {
			user1.setName(user.getName());
			user1.setPhone(user.getPhone());
			et.begin();
			em.persist(user1);
			et.commit();
			return user1;

		}
		return null;
	}

	public List<User> getAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
//		et.begin();
		Query query = em.createQuery("select u from User u");
		List<User> users = query.getResultList();
//		et.commit();
		return users;
	}

	public List<User> getUserByRole(String role) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select u from User u where u.role=?1");
		query.setParameter(1, role);
		List<User> users = query.getResultList();
		et.commit();
		return users;
	}

}
