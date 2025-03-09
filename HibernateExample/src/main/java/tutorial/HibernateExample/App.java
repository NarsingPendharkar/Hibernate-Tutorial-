
package tutorial.HibernateExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		
			try {
				
				// load hibernate configurations
				Configuration cfg= new Configuration();
				cfg.configure("hibernate.cfg.xml");
				cfg.addAnnotatedClass(Employee.class);
				// create session factory object
				SessionFactory sf=cfg.buildSessionFactory();
				// create session form session factory
				Session session=sf.openSession();
				// create transaction from session
				Transaction tx=session.getTransaction();
				// open trx
				session.beginTransaction();
				Employee emp=new Employee(3,"sachin",45,"nanded");
				// db opration
				session.save(emp);
				// close
				System.out.println("saved");
				tx.commit();
				session.close();
				sf.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
}}
