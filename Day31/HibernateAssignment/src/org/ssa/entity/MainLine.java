package org.ssa.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.tiy.createMajor.CreateMajor;



public class MainLine {

	public static void main(String[] args) {
		
	CreateMajor major = new CreateMajor();
	
	
	   
	   //major.insertMajor("Baseball",1490);
	   //major.update("ballroom",17);
	   //major.delete(17);
	  major.displayAllMajors();
	 
	    
	  
	    
	    
	}

}
