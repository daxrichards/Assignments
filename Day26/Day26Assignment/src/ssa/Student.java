package ssa;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class Student extends dbaActions {
	
	public int id;
	public String first;
	public String last;
	public double gpa;
	public int sat;
	
	
	
	
	public void setId(int id) {
		this.id=id;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}


	
	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}


	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	/**
	 * @param sat the sat to set
	 */
	public void setSat(int sat) {
		this.sat = sat;
	}


	public Student(){}
	
	
	//Method to formulate select statement to extract one student from the database
	public void getById(int id) throws SQLException{
		Student student1 = new Student();
		
		try{
			
			student1.select("Select * from student where id =" + id + " limit 1" );
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
    
	//Method to extract all students from the database
	public void getAll() throws SQLException{
		Student student1 = new Student();
		
		try{
			
			student1.select("Select * from student"); 
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

//Custom select statement is used to create the ResultSet object to display query results
public void select(String sql) throws SQLException{
	Student student = new Student();
	
		
	try{
		ResultSet rs =student.executeQuery(sql);
		
	while (rs.next())
	{ display(rs);
		
	}

}catch(Exception ex){
}


}
}