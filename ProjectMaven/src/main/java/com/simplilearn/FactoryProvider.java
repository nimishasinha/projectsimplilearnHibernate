package com.simplilearn;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	
			// System.out.println("projrct started");
			  
			
			  
			 public static SessionFactory factory ; 
			 
			 public static SessionFactory getFactory() {
				  if(factory==null) {
					  factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				  }
				 
				 return factory;
			 }
			
		//	  System.out.println(factory);
			  
			  public void closeFactory() {
				  
				  if(!factory.isClosed()) {
					  factory.close();
				  }
				  
			  }

		}





