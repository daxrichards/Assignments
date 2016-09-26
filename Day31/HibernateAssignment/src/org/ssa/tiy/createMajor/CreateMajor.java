package org.ssa.tiy.createMajor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="major")

public class CreateMajor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="req_sat")
	private int req_sat;
	
	private static Session session = null;
	
	private static SessionFactory factory = null;
	 
	
	
	/**
	 * @return the session
	 */
	public static Session getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public static void setSession(Session session) {
		CreateMajor.session = session;
	}

	/**
	 * @return the factory
	 */
	public static SessionFactory getFactory() {
		return factory;
	}

	/**
	 * @param factory the factory to set
	 */
	public static void setFactory(SessionFactory factory) {
		CreateMajor.factory = factory;
	}
	
	public CreateMajor(){}

	public CreateMajor(String description, int req_sat){
		
		this.description = description;
		this.req_sat = req_sat;
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param req_sat the req_sat to set
	 */
	public void setReq_sat(int req_sat) {
		this.req_sat = req_sat;
	}

	/**
	 * @return the req_sat
	 */
	public int getReq_sat() {
		return req_sat;
	}
    

	public static void insertMajor(Session session, String description, int req_sat ){
	
		
			CreateMajor  major = new CreateMajor(description, req_sat);
            
			
		    session.beginTransaction();
			  
			session.save(major);
			
			session.getTransaction().commit();
			
		
	   
	}

	public static void update(Session session, String descrip, int id){
		
		CreateMajor  major = new CreateMajor();
		
		session.beginTransaction();
		major= session.get(CreateMajor.class, id);
		major.setDescription(descrip);
		session.getTransaction().commit();
		
		

}
	
public static void delete(Session session, int id){
	CreateMajor  major = new CreateMajor();
	
	session.beginTransaction();
	session.createQuery("delete CreateMajor where id=" + id).executeUpdate();
	session.getTransaction().commit();
	   
	  
}
public static void displayAllMajors(Session session){
	
	session.beginTransaction();
	List<CreateMajor> majors= session.createQuery("from CreateMajor").list();
	
	//display all students
	for(CreateMajor sub: majors)
		System.out.println(sub.getDescription());
	
	
	session.getTransaction().commit();
	
	
}
public static void connect(){
	
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(CreateMajor.class)
            .buildSessionFactory();

	Session session = factory.getCurrentSession();
	
	setSession(session);
	setFactory(factory);
}

}
	

