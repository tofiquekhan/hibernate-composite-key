package myproject.compositekey.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myproject.compositekey.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			Configuration config = new Configuration();
			config.configure("/myproject/compositekey/resources/hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Employee emp = new Employee();
			emp.setEno(201);
			emp.setEname("Tarun");
			emp.setEsal(40020);
			emp.setEaddr("Nagpur");
			session.save(emp);
				tx.commit();
				System.out.println("Employee Inserted Successfully");
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		
	}
}
