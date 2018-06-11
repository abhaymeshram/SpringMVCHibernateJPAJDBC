package com.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.PersonDAO;
import com.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

	@Override
	public List<Map<String,String>> getEmployeesByJDBC() throws Exception {
		return this.personDAO.getEmployeesByJDBC();
	}

	@Override
	public List<Person> getEmployeesByJPA() {
		return this.personDAO.getEmployeesByJPA();
	}

	@Override
	public List<Person> getEmployeesByHibernate() {
		return this.personDAO.getEmployeesByHibernate();
	}

}
