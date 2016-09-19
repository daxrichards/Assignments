package ssa;

import java.sql.*;
import java.util.*;
import java.sql.SQLException;




public class Mainline {

	public static void main(String[] args) {
   try{

		Student aStudent = new Student();
		
		
	   aStudent = aStudent.getById(100);
	   System.out.println(aStudent);
	   
	   
	   System.out.println("\n\n**********************************************************************");
	   System.out.println("**********************************************************************");
	   System.out.println("**********************************************************************\n");
	   
	   ArrayList<Student> allStudents = aStudent.getAll();
	   
	   for(Student student: allStudents){
		   System.out.println(student);
	   }
	 

	}catch(Exception ex)
   {
		ex.printStackTrace();
   }

}
}
