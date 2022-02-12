package com.simplilearn;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 System.out.println("projrct started");
		  
		  Configuration configuration = new Configuration();
		  configuration.configure("hibernate.cfg.xml");
		  SessionFactory factory = configuration.buildSessionFactory();
		  
		  System.out.println(factory);

	}

}
