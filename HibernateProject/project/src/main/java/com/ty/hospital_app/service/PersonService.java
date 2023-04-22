package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.PersonDaoImp;
import com.ty.hospital_app.dto.Person;

public class PersonService {
	public void savePerson(Person person, int eid) {
		PersonDaoImp pdi = new PersonDaoImp();
		Person person1 = pdi.savePerson(eid, person);
		if (person1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Person getPersonById(int pid) {
		PersonDaoImp pdi = new PersonDaoImp();
		Person person = pdi.getPersonById(pid);
		if (person != null) {
			return person;
		} else {
			return null;
		}
	}
	
	public void deletePersonById( int pid) {
		PersonDaoImp pdi = new PersonDaoImp();
		boolean flage = pdi.deletePersonByid(pid);
		if (flage) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Unfortunatly data not found..!");
		}
	}

	public Person updatePersonById(int pid,Person person) {
		PersonDaoImp pdi = new PersonDaoImp();
		Person person1 = pdi.updatePersonById(pid, person);
		if (person1 != null) {
			return person1;
		} else {
			return null;
		}
	}
	
	public List<Person> getAllPerson() {
		PersonDaoImp pdi = new PersonDaoImp();
		List<Person> persons = pdi.getAllPerson();
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}
	
	public List<Person> getPersonByGender(String gender) {
		PersonDaoImp pdi = new PersonDaoImp();
		List<Person> persons = pdi.getPersonByGender(gender);
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}
	
	public List<Person> getPersonByAge(int age) {
		PersonDaoImp pdi = new PersonDaoImp();
		List<Person> persons = pdi.getPersonByAge(age);
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}
	
	public List<Person>  getPersonByPhone(long phone) {
		PersonDaoImp pdi = new PersonDaoImp();
		List<Person> persons = pdi.getPersonByPhone(phone);
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}

}
