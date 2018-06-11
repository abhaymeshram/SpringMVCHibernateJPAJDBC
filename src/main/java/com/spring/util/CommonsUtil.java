package com.spring.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommonsUtil {
	
	@Autowired
	BasicDataSource dataSource;
	
	public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(dataSource.getDriverClassName());
			conn = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
