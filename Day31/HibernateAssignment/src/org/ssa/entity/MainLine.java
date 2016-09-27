package org.ssa.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.tiy.createMajor.CreateMajor;



public class MainLine {

	public static void main(String[] args) {
		
	CreateMajor major = new CreateMajor();
	
	
	   
	 major.insertMajor("Puppeteering",1500);
	 major.update("Break Dancing",19);
	 major.delete(22);
	 major.displayAllMajors();
	 
	    
	  
	    
	    
	}

}
