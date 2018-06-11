package com.spring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Person;
import com.spring.service.PersonService;

@RestController
public class PersonRestController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/getEmployeeByJDBC", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String, String>> getEmployeeByJDBC() throws Exception {
		return this.personService.getEmployeesByJDBC();
	}

	@RequestMapping(value = "/getEmployeeByJPA", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getEmployeeByJPA() throws Exception {
		return this.personService.getEmployeesByJPA();
	}

	@RequestMapping(value = "/getEmployeeByHibernate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getEmployeeByHibernate() throws Exception {
		return this.personService.listPersons();
	}

}
