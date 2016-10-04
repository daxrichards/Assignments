package com.ssa.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="student")
public class Student implements Serializable {
	
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="id")
	 private int id;
     
     @Column(name="first_name")   
	 private String first_name;
     
     @Column(name="last_name")
	 private String last_name;
    
	@Column(name="sat")
	 private int sat;
	 
	  @Column(name="gpa")
	 private double gpa;
	  
	  @Column(name="major_id") 
	 private Integer majorid;
	




public Student(){}

public Student (String first_name, String last_name, int sat, double gpa, int majorid){
	 
	
	 this.first_name = first_name;
	 this.last_name = last_name;
	 this.sat = sat;
	 this.gpa = gpa;
	 this.majorid= majorid;
	 
}

/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @return the first_name
 */
public String getfirst_name() {
	return first_name;
}

/**
 * @return the last_name
 */
public String getlast_name() {
	return last_name;
}

/**
 * @return the sat
 */
public int getSat() {
	return sat;
}

/**
 * @return the gpa
 */
public double getGpa() {
	return gpa;
}

/**
 * @return the majorid
 */
public int getMajorid() {
	return majorid;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @param first_name the first_name to set
 */
public void setfirst_name(String first_name) {
	this.first_name = first_name;
}

/**
 * @param last_name the last_name to set
 */
public void setlast_name(String last_name) {
	this.last_name = last_name;
}

/**
 * @param sat the sat to set
 */
public void setSat(int sat) {
	this.sat = sat;
}

/**
 * @param gpa the gpa to set
 */
public void setGpa(double gpa) {
	this.gpa = gpa;
}

/**
 * @param majorid the majorid to set
 */
public void setMajorid(Integer majorid) {
	this.majorid = majorid;
}


}

