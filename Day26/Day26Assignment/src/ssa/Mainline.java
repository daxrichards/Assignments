package ssa;

import java.sql.*;
import java.util.*;
import java.sql.SQLException;




public class Mainline {

	public static void main(String[] args) {
   try{

		Student student = new Student();
		
		
	   student.getById(100);
	   System.out.println("\n\n**********************************************************************");
	   System.out.println("**********************************************************************");
	   System.out.println("**********************************************************************\n");
	    student .getAll();
	 
	    
	}catch(Exception ex)
   {
		ex.printStackTrace();
   }

}
}
