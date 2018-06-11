package com.spring.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jpa.dao.PersonRepository;
import com.spring.model.Person;
import com.spring.util.CommonsUtil;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	CommonsUtil commonsUtil;

	@Override
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details=" + p);
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for (Person p : personsList) {
			logger.info("Person List::" + p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details=" + p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details=" + p);
	}

	@Override
	public List<Map<String,String>> getEmployeesByJDBC() throws Exception {
		Connection conn = null;

		conn = commonsUtil.getConnection();

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		if (null != conn) {
			logger.info("Successfully Connected!!!");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from person");
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				Map<String, String> dataMap = new HashMap<String, String>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					dataMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
				}
				list.add(dataMap);
			}

		} else
			logger.info("Error in connection.");

		if (null != conn)
			try {
				conn.close();
				System.out.println("Successfully Closed!!!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}

	@Override
	public List<Person> getEmployeesByJPA() {
		return (List<Person>) personRepository.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getEmployeesByHibernate() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for (Person p : personsList) {
			logger.info("Person List::" + p);
		}
		return personsList;
	}

}
