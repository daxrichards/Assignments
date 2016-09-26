package org.ssa.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.tiy.createMajor.CreateMajor;



public class MainLine {

	public static void main(String[] args) {
		
	
		//Creating session factory to make connection to database
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
	            .addAnnotatedClass(CreateMajor.class)
	            .buildSessionFactory();

		Session session = factory.getCurrentSession();
	 
	    CreateMajor major = new CreateMajor();
	   
	   try{
	   
	     //major.insertMajor(session, "Baseball",1470);
	    //major.update(session,"Surfing",18);
	   //major.delete(session,18);
	  major.displayAllMajors(session);
	 
	    
	   }catch(Exception ex){
		}finally{
			factory.close();
		}
	    
	    
	}

}
