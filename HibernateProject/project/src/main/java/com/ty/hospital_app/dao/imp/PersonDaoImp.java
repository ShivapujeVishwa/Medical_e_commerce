package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Person;

public class PersonDaoImp implements PersonDao {

	public Person savePerson(int eid, Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, eid);
		if (encounter != null) {
			et.begin();
			em.persist(person);
			et.commit();
			return person;
		}

		return null;

	}

	public Person getPersonById(int pid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		Person person = em.find(Person.class, pid);
		return person;

	}

	public boolean deletePersonByid(int pid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Person person = em.find(Person.class, pid);
		if (person != null) {
			et.begin();
			em.remove(person);
			et.commit();
			return true;

		}
		return false;
	}

	public Person updatePersonById(int pid, Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Person person1 = em.find(Person.class, pid);

		if (person1 != null) {
			person1.setAddress(person.getAddress());
			person1.setGender(person.getGender());
			et.begin();
			em.persist(person1);
			et.commit();
			return person1;

		}
		return null;
	}

	public List<Person> getAllPerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");

		EntityManager em = emf.createEntityManager();
		javax.persistence.Query query = em.createQuery("select s from Person s");
		List<Person> person = query.getResultList();

		return person;
	}

	public List<Person> getPersonByGender(String gender) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select p from Person p where p.gender=?1");
		query.setParameter(1, gender);
		List<Person> persons = query.getResultList();
		et.commit();
		return persons;
	}

	public List<Person> getPersonByAge(int age) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select p from Person p where p.age=?1");
		query.setParameter(1, age);
		List<Person> persons = query.getResultList();
		et.commit();
		return persons;
	}

	public List<Person> getPersonByPhone(long phone) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select p from Person p where p.phone=?1");
		query.setParameter(1, phone);
		List<Person> persons = query.getResultList();
		et.commit();
		return persons;
	}

}
