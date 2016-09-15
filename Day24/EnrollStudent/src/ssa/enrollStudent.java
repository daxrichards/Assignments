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
		public static String database = "tiy2";
		
		
		

		enrollStudent newStudent = new enrollStudent();


		


		public static void main(String[] args) throws SQLException{
			
			//insert();
			//fetch();
			//deleteData();
			//updateSAT();
			
		
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
					props.load(new FileInputStream("demonstation.properties"));
					
					
					String url = props.getProperty("urlPart1" + getDatabase() + "urlPart2");
					 String user = props.getProperty("user");
					 String pwd = props.getProperty("pwrd");
					//props.load(new fileInputStream("c:/file/location")
					 
					 
						myConn= (Connection)DriverManager.getConnection(url,user,pwd);
						
			}catch(Exception exc){
				  exc.printStackTrace();
			}
					
				}
	private static void fetch() throws SQLException{
		try{
				loadMe();
					
					//Question mark acts as a placeholder
					myStmt =myConn.prepareStatement("Select * from student where gpa > ? and sat > ?");
					
					//Set parameter values  for prepared statements
					
					myStmt.setDouble(1,3.0);
					 myStmt.setInt(2,100);
					 
					 
					 //execute query
					 
					 myRs=myStmt.executeQuery();
					 
					 //process result set
					 
					 display();
					 
					//Set parameter values  for prepared statements
						
					myStmt.setDouble(1,3.0);
					myStmt.setInt(2,1090);	 
						 
				 //execute query
						 
						 myRs=myStmt.executeQuery();
						 
						 //process result set
						 
						 display();
						 
					 
					
				
		}catch(Exception exc){
			  exc.printStackTrace();
		}finally{
			if(myConn!= null)
				myConn.close();
			if(myStmt!=null)
				myStmt.close();
			if(myRs!=null)
				myRs.close();
		}

		
	}
	
	
	public static int findMajorid(String major_description) throws SQLException{
		
		   int major_id = 0;
		try{
			
			loadMe();
			stmt = myConn.createStatement();
			
			//1. Execute SQL query
			
			myRs= stmt.executeQuery("select major_id from student join major on student.major_id = major.id where major_description = " + major_description);
			
			//2. Process the result set
			
			major_id =  myRs.getInt("major_id");
			
			//3. Find classes associated with major
			
			myRs = stmt.executeQuery("select class_id from major_class_relationship where major_id =" + major_id);
			
			
			ArrayList<Integer> classes = new ArrayList<Integer>();
              
					
			while (myRs.next()){
				
				classes.add(myRs.getInt("class_id"));
			}
		
		}catch(Exception ex){
			
		}finally{

			if(myConn!=null)
				myConn.close();
			if(stmt !=null)
				stmt.close();
			if(myRs != null)
				myRs.close();
		}
		
		
		return major_id;
	}
	
	private static boolean testAdmission(int sat,  String major){
		
		boolean isEligible =false;
		
		if (major == "General Business" && sat < 800){
				System.out.println("Not eligble for this major - please select another major");
		}	
		if (major == "Finance" && sat < 1100){
			System.out.println("Not eligble for this major - please select another major");
		}
		if (major == "Finance" && sat < 1100){
			System.out.println("Not eligble for this major - please select another major");
	    }	
		if (major == "Math" && sat < 1300){
			System.out.println("Not eligble for this major - please select another major");
	    }	
		if (major == "Engineering" && sat < 1300){
			System.out.println("Not eligble for this major - please select another major");
	    }				
		if (major == "Education" && sat < 1300){
			System.out.println("Not eligble for this major - please select another major");
	    }				
		if (major == "General Studies" && sat < 1300){
			System.out.println("Not eligble for this major - please select another major");
	    }				
		else{
			isEligible = true;
		}
		return isEligible;
	}
	
	private static void enrollStudent(int id, String first, String last, int sat, double gpa, String major) throws SQLException{
		
		
		if(testAdmission(sat, major)== false){
			major = "General Studies";
		}
		
		
		try{
			loadMe();
			
			//Create the preparedStatement for the insert to add students to the database
			myStmt =myConn.prepareStatement
					("insert student values(id, first, last, sat, gpa, major_id)");
			
			
					
					//id
					myStmt.setInt(1,id);
					//first
					myStmt.setString(2,first);
					//last
					myStmt.setString(3,last);
					//sat
					myStmt.setInt(4, sat);
					//gpa
					myStmt.setDouble(5,gpa);
					//major_id
					myStmt.setInt(6,findMajorid(major));


					int rows = myStmt.executeUpdate();
					
					System.out.println(rows + " Row(s) affected");
					
				
			
		}catch(Exception ex){
			
		}finally
		{
		 closeMe();
	}
		//assignClass(id, major);
		}
	
public static ArrayList<Integer> findClasses(String major_description) throws SQLException{
		

		ArrayList<Integer> classes = new ArrayList<Integer>();
		
		try{
			
			loadMe();
						
			myRs = stmt.executeQuery("select class_id from major_class_relationship where major_id =" + findMajorid(major_description));
			
			
			
           
					
			while (myRs.next()){
				
				classes.add(myRs.getInt("class_id"));
			}
		
		}catch(Exception ex){
			
		}finally{

			if(myConn!=null)
				myConn.close();
			if(stmt !=null)
				stmt.close();
			if(myRs != null)
				myRs.close();
		}
		
		
		return classes;
	}
    public static void assignClass(int id, String major) throws SQLException{
    	
    	try{
			loadMe();
			
			
			if(major== "General Business")
			myStmt =myConn.prepareStatement("insert student_class_relationship (student_id,class_id) values(?,?)");
					
					//Class 1
			        myStmt.setInt(1,id);
					myStmt.setInt(2,10101);
				    myStmt.executeUpdate();
				    
				  //Class 2
			        myStmt.setInt(1,id);
					myStmt.setInt(2,10101);
				    myStmt.executeUpdate();
				    
				  //Class 3
			        myStmt.setInt(1,id);
					myStmt.setInt(2,10101);
				    myStmt.executeUpdate();
				    
				  //Class 4
			        myStmt.setInt(1,id);
					myStmt.setInt(2,10101);
				    myStmt.executeUpdate();
				    
					
					//System.out.println(rows + " Row(s) affected");
					
				
			
		}catch(Exception ex){
			
		}finally
		{
		 closeMe();
	}
	
    	
    }

	
	public static void closeMe() throws SQLException{
		if(myConn!= null)
			myConn.close();
		if(myStmt!=null)
			myStmt.close();
		if(myRs!=null)
			myRs.close();
	}
	public static void display() throws SQLException{
		
		System.out.println("Education System - Enrollment Process");
		System.out.println("=====================================");

		System.out.println("**********************************************************");
	while(myRs.next()){
		 String fname = myRs.getString("first_name");
		 String lname = myRs.getString("last_name");
		 double gpa = myRs.getDouble("gpa");
		int sat = myRs.getInt("sat");
		
		System.out.println(fname + "    " + lname + " " + gpa +   " "  + sat);
			}
	}


	}
