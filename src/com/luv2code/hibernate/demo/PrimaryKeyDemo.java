package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
	
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();

				try {
					
					// create 3 student objects
					System.out.println("Create 3 student objcets.....");
					Student tempStudent1 = new Student("Rajan", "Bhattarai", "rajan.bhattarai@gmail.com");
					Student tempStudent2 = new Student("Sagar", "Bhattarai", "sagar.bhattarai@gmail.com");
					Student tempStudent3 = new Student("Punam", "Aryal", "punam.aryal@yahoo.com");
					// start a transaction
					session.beginTransaction();
					
					// save the student objects
					System.out.println("Save the students ...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
					System.out.println("Done!!!");
					
				}
				finally {
					factory.close();
				}
			}

	}


