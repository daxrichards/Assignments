package ssa;

import java.sql.*;
import java.lang.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class enrollStudent {

	
        static Statement stmt =null;
		static Connection myConn=null;
		static PreparedStatement myStmt= null;
		static ResultSet myRs= null;
		static ResultSet rs= null;
		public static String database = "tiy2";
		
		
		

		public static void main(String[] args) throws SQLException{
			
		 enrollStudent student1 = new enrollStudent();
		 enrollStudent student2 = new enrollStudent();
		 enrollStudent student3 =new enrollStudent();
		 enrollStudent student4 =new enrollStudent();
		 enrollStudent student5 =new enrollStudent();
	
				 
		System.out.println("***********************************************************************************");
		System.out.println("*************************            FIRST STUDENT         ************************");
		System.out.println("***********************************************************************************\n");
		    	 
		student1.addStudent("Adam", "Zapel", 1200, 3.0,"Finance");
		System.out.println("\n***********************************************************************************");
		System.out.println("*************************             NEXT STUDENT         ************************");
	    System.out.println("***********************************************************************************\n");
	    student2.addStudent("Graham", "Krakir", 500, 2.5,"General Studies");
	    System.out.println("\n***********************************************************************************");
		System.out.println("*************************             NEXT STUDENT         ************************");
	    System.out.println("***********************************************************************************\n");
	    
	    student3.addStudent("Ella", "Vader", 800, 3.0,"Accounting");
	    System.out.println("\n***********************************************************************************");
		System.out.println("*************************             NEXT STUDENT         ************************");
	    System.out.println("***********************************************************************************\n");
	    
	    student4.addStudent("Stanley","Kupp", 1350, 3.3,"Engineering");
	    System.out.println("\n***********************************************************************************");
		System.out.println("*************************             NEXT STUDENT         ************************");
	    System.out.println("***********************************************************************************\n");
	    
	    student5.addStudent("Win", "Nar", 900, 3.0,"Education");

	    
	    
        
		
		}

		/**
		 * @return the database
		 */
		public static String getDatabase() {
			return database;
		}


		/**
		 * @param database the database to set
		 */
		public void setDatabase(String database) {
			this.database = database;
		}
		
		private static void loadMe() throws SQLException{
			try{
				
				
		            		    
					Properties props = new Properties();
					props.load(new FileInputStream("props.properties"));
					
					
					String url = props.getProperty("url");
					String user = props.getProperty("user");
					 String pwd = props.getProperty("pwrd");
					//props.load(new fileInputStream("c:/file/location")
					 
					 
						myConn= (Connection)DriverManager.getConnection(url,user,pwd);
						
			}catch(Exception exc){
				  exc.printStackTrace();
			}
					
				}
	
	//Find Major ID that corresponds with the description
	public static int findMajorid(String description) throws SQLException{
		
		   int id=0;
		try{
			
			loadMe();
		
			myStmt = myConn.prepareStatement("select id from major where description = ?");
		
			myStmt.setString(1,description);
			
			 myRs=myStmt.executeQuery();
	
			 while(myRs.next())
				id = myRs.getInt("id");
			
		/*	
			//3. Find classes associated with major
			
			myRs = stmt.executeQuery("select class_id from major_class_relationship where major_id =" + major_id);
			
			
			ArrayList<Integer> classes = new ArrayList<Integer>();
              
					
			while (myRs.next()){
				
				classes.add(myRs.getInt("class_id"));
			}
		*/
		}catch(Exception ex){
			ex.printStackTrace();
					
		}finally{

			if(myConn!=null)
				myConn.close();
			if(stmt !=null)
				stmt.close();
			if(myRs != null)
				myRs.close();
		}
		
	
		return id;
	}
	
	//Evaluate eligibility for major as per students' sat scores
	private static boolean testAdmission(int sat,  String major){
		
		boolean isEligible =false;
		
		if (major == "General Business" && sat < 800){
				System.out.println("***NOTE:*** This student did not meet the SAT requirements for his/her intended major, and was therefore assigned to General Studies.\n");
		}	
		else if (major == "Accounting" && sat < 1000){
			System.out.println("***NOTE:*** This student did not meet the SAT requirements for his/her intended major, and was therefore assigned to General Studies.\n");
		}
		else if (major == "Finance" && sat < 1100){
			System.out.println("***NOTE:*** This student did not meet the SAT requirements for his/her intended major, and was therefore assigned to General Studies.\n");
	    }	
		else if (major == "Math" && sat < 1300){
			System.out.println("***NOTE:*** This student did not meet the SAT requirements for his/her intended major, and was therefore assigned to General Studies.\n");
	    }	
		else if (major == "Engineering" && sat < 1350){
			System.out.println("***NOTE:*** This student did not meet the SAT requirements for his/her intended major, and was therefore assigned to General Studies.\n");
	    }				
		else if (major == "Education" && sat < 900){
			System.out.println("***NOTE:*** This student did not meet the SAT requirements for his/her intended major, and was therefore assigned to General Studies.\n");
	    }				
		else if (major == "General Studies" && sat < 500){
			System.out.println("***NOTE:*** This student did not meet the SAT requirements for his/her intended major, and was therefore assigned to General Studies.\n");
	    }				
		else{
			isEligible = true;
		}
		//System.out.println("isEligible? " + isEligible);
		return isEligible;
	}
	
	//Enroll students
	public void addStudent(String first, String last, int sat, double gpa, String major) throws SQLException{
		
		

		if(testAdmission(sat, major)== false){
			major = "General Studies";
		}
		
	
		int id = findMajorid(major);
		
		
		try{
			loadMe();
			
			//Create the preparedStatement for the insert to add students to the database
			myStmt =myConn.prepareStatement
					("insert student(first_name, last_name, sat, gpa, major_id) values(?, ?, ?, ?, ?)");
			
			
					//first
					myStmt.setString(1,first);
					//last
					myStmt.setString(2,last);
					//sat
					myStmt.setInt(3,sat);
					//gpa
					myStmt.setDouble(4,gpa);
					//major_id
					myStmt.setInt(5,id);
				
					

					
			
		}catch(Exception ex){
			
		}finally
		{
		 closeMe();
	}
		findClasses(findMajorid(major));
		findStudentId(first,last);
		insertClass(findStudentId(first,last), findClasses(findMajorid(major)));
		display(first, last, sat, gpa, major, grabSubject(findClasses(findMajorid(major))), findClasses(findMajorid(major)));
		}
	
	//Find classes associated with a particular major
public static ArrayList<Integer> findClasses(int major_id) throws SQLException{
		
	              
		ArrayList<Integer> classes = new ArrayList<Integer>();
	
		
		try{
			
			loadMe();
		if (major_id < 5) {
			
			myStmt =myConn.prepareStatement("select class_id from major_class_relationship where major_id = ? order by rand() limit 4");
						
		//*************************************************
		myStmt.setInt(1,major_id);
		
		 myRs=myStmt.executeQuery();

		 while(myRs.next()){
			classes.add(myRs.getInt("class_id"));

		 }	
		}
		 else{
			 
		
			 stmt =myConn.createStatement();
			 ResultSet rs = stmt.executeQuery("select * from major_class_relationship limit 4");
		
		
		
		while(rs.next()){
			classes.add(rs.getInt("class_id"));
		
		
		}
		 }
		
		
		}catch(Exception ex){
			
		}finally{

			if(myConn!=null)
				myConn.close();
			if(stmt !=null)
				stmt.close();
			if(myRs != null)
				myRs.close();
			if(rs != null)
				rs.close();
		}
		
		
		return classes;
		
	}
     //Insert the classes the student has been enrolled in into the appropriate table
    public static void insertClass(int id, ArrayList<Integer> classes) throws SQLException{
    	
    	try{
			loadMe();
		
			myStmt =myConn.prepareStatement("insert student_class_relationship (student_id,class_id) values(?,?)");
					
					//Class 1
			        myStmt.setInt(1,110);
					myStmt.setInt(2,10101);
				    myStmt.executeUpdate();
				    
				  //Class 2
			        myStmt.setInt(1,120);
					myStmt.setInt(2,10102);
				    myStmt.executeUpdate();
				    
				  //Class 3
			        myStmt.setInt(1,130);
					myStmt.setInt(2,10103);
				    myStmt.executeUpdate();
				    
				  //Class 4
			        myStmt.setInt(1,140);
					myStmt.setInt(2,10201);
				    myStmt.executeUpdate();
				    
					
								
				
			
		}catch(Exception ex){
			
		}finally
		{
		 if(myConn != null);
		 myConn.close();
		 if(myStmt != null)
	     myStmt.close();
	}
	
    	
    }
    //Find the subject title that corresponds to the class id
 public static ArrayList<String> grabSubject(ArrayList<Integer> subject_id) throws SQLException{
    	
	 
	 ArrayList<String> subjects = new ArrayList<String>();
	 
    	try{
			loadMe();
		
			myStmt =myConn.prepareStatement("select subject from class where id = ?");
					
					//Subject 1
			        myStmt.setInt(1,subject_id.get(0));
					myRs = myStmt.executeQuery();
					
					while (myRs.next()){
					subjects.add(myRs.getString("subject"));
					}
				
					//Subject 2
			        myStmt.setInt(1,subject_id.get(1));
					myRs = myStmt.executeQuery();
					
					while (myRs.next()){
					subjects.add(myRs.getString("subject"));
					}
					
					
					//Subject 3
			        myStmt.setInt(1,subject_id.get(2));
					myRs = myStmt.executeQuery();
					
					while (myRs.next()){
					subjects.add(myRs.getString("subject"));
					}
					
					
					//Subject 4
			        myStmt.setInt(1,subject_id.get(3));
					myRs = myStmt.executeQuery();
					
					while (myRs.next()){
					subjects.add(myRs.getString("subject"));
					}
					
					
				
						
		}catch(Exception ex){
			
		}finally
		{
		 if(myConn != null);
		 myConn.close();
		 if(myStmt != null)
	     myStmt.close();
		 if(myRs != null)
		     myRs.close();
	}
	    
    	return subjects;	
    }
 
	//close database connections
	public static void closeMe() throws SQLException{
		if(myConn!= null)
			myConn.close();
		if(myStmt!=null)
			myStmt.close();
		if(myRs!=null)
			myRs.close();
	}
	
	//Find the studentId associated with first and last name of student
	public static int findStudentId(String first_name, String last_name) throws SQLException{
		
		int studentId = 0;
		try{
			
			loadMe();
		
			 
			 myStmt =myConn.prepareStatement("select id from student where first_name=? and last_name=?");
			 
			 myStmt.setString(1,first_name);
			 myStmt.setString(2,last_name);
				
			 myRs=myStmt.executeQuery();
			 
			 while (myRs.next())
			{
				studentId=myRs.getInt("id");
				 
			 }
		
		
	}catch(Exception ex){
		
	}finally{
		if(myConn!=null)
			myConn.close();
		if (stmt!=null)
			stmt.close();
		if (rs!=null)
			stmt.close();
		
		
		
	}
		
		return studentId;
	}
	    
//Find the SAT score required for a particular major
public static int findReqSat(String description) throws SQLException{
	
           int req_sat = 0;
	
		try{
			
			loadMe();
		
			 
			 myStmt =myConn.prepareStatement("select req_sat from major where description = ?");
			 
			 myStmt.setString(1,description);
						
			 myRs=myStmt.executeQuery();
			 
			 while (myRs.next())
			{
				req_sat =myRs.getInt("req_sat");
				 
			 }
		
		
	}catch(Exception ex){
		
	}finally{
		if(myConn!=null)
			myConn.close();
		if (stmt!=null)
			stmt.close();
		if (rs!=null)
			stmt.close();
		
		
		
	}
		
		return req_sat;
	}


   //Display the specific query results in requested format
	public static void display(String first, String last, int sat, double gpa, String major_description, ArrayList<String> subjects, ArrayList<Integer> classId) throws SQLException{
		
		System.out.println("Education System - Enrollment Process");
		System.out.println("=====================================");

		System.out.println("Enrolled " + first +" " +last + " as a new student.");
		System.out.println(first + " " + last + " has an SAT score of " + sat);
		//if (testAdmission(sat, major_description) == true){
		System.out.println("Assigned " +first + " " + last + " to the " + major_description + " major which requires a required SAT score of " + findReqSat(major_description));
		System.out.println("Enrolled " + first + " " +last + " in the following four classes:");
		System.out.println("1. " + subjects.get(0) + " " + classId.get(0) +" required for major" );
		System.out.println("2. " + subjects.get(1) + " " + classId.get(1) +" required for major" );
		System.out.println("3. " + subjects.get(2) + " " + classId.get(2) +" required for major/electives" );
		System.out.println("4. " + subjects.get(3) + " " + classId.get(3) +" required for major/electives" );
	

	
}
}
