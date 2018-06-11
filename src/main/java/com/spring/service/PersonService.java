package com.spring.service;

import java.util.List;
import java.util.Map;

import com.spring.model.Person;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	public List<Map<String,String>> getEmployeesByJDBC() throws Exception;
	public List<Person> getEmployeesByJPA();
	public List<Person> getEmployeesByHibernate();
	
}
