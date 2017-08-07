package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display the students  // right click and go to refactor and method and write name display name.. it make method( for loop is replaced by method)
			displayStudents(theStudents);
			//query students: lastName= 'Bhattarai'
			theStudents = session.createQuery("from Student s where s.lastName='Bhattarai'").list();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Bhattarai");
			displayStudents(theStudents);
			
			// query students: lastNAme = 'Bhattarai' OR firstName=' Punam'
			theStudents = 
					session.createQuery("from Student s where"
							+ " s.lastName='Bhattarai' OR s.firstName='Punam'").list();
			
			
			System.out.println("\n\nStudents who has last name  Bhattarai OR first name  Punam");
			displayStudents(theStudents);
			
			// query students where email LIKE '%yahoo.com'
			theStudents = 
					session.createQuery("from Student s where"
					+ " s.email LIKE '%yahoo.com'").list();
			System.out.println("\n\nStudents who has teh email address end whth '%yahoo.com'");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
			
		}
	}

}
