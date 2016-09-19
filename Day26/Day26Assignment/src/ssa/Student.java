package ssa;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Student extends dbaActions {
	
	public int id ;
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
	 * @param gpa the gpa to setQ
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


	public Student(){
		
	}
	
	
	//Method to formulate select statement to extract one student from the database
	public Student getById(int id) throws SQLException {
		
		ArrayList<Student> students = new ArrayList<Student>();
		
	     
		
			
			students = select("Select * from student where id = " + id);
			
			return students.get(0);
	}
    
	//Method to extract all students from the database
	public ArrayList<Student> getAll() throws SQLException{
		ArrayList<Student> student = new ArrayList<Student>();
		
		
			return student = select("Select * from student"); 
		
	}

//Custom select statement is used to create the ResultSet object to display query results
public ArrayList<Student> select(String sql) throws SQLException{
	   Student student = new Student();
	   
		ArrayList<Student> students = new ArrayList<Student>();
	try{
		ResultSet rs =student.executeQuery(sql);
		
		while(rs.next()){
		student = student.createStudent(rs);
		students.add(student);
		}
		
		
	
 
}catch(Exception ex){
}
	   return students;

}


public Student createStudent(ResultSet rs){
	
	Student student = new Student();
	try{
	        student.id = rs.getInt("id");
		    student.first = rs.getString("first_name");
			student.last = rs.getString("last_name");
			student.gpa = rs.getDouble("gpa");
		student.sat = rs.getInt("sat");	
		
	
	}catch(Exception ex)
	{ ex.printStackTrace();
	}
	return student;
}
@Override
public String toString(){
	
		
			String msg = String.format("\n%d %8s %8s %10.2f %5d",
			this.id,
		    this.first,
			this.last,
			this.gpa,
			this.sat);
			
		
		return msg;
}

}
