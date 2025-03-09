package tutorial.HibernateTutorial;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {

	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cfg.setProperty("hibernate.connection.url","jdbc:sqlserver://DESKTOP-G774017:1433;databaseName=hibernateTutorial;encrypt=false");
		cfg.setProperty("hibernate.connection.username", "Narsing");
		cfg.setProperty("hibernate.connection.password", "root");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		cfg.setProperty("hibernate.show_sql", "true");
		cfg.addAnnotatedClass(Department.class);
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Department dept = new Department("ME");
			Employee e1 = new Employee("Rushi", 433.45);
			e1.setDepartment(dept);
			Employee e2 = new Employee("gur", 4435.45);
			e2.setDepartment(dept);
			Employee e3 = new Employee("yol", 45132.45);
			e3.setDepartment(dept);
			dept.setEmployees(Arrays.asList(e1, e2, e3));
			session.save(dept);
			tx.commit();
			System.out.println("saved");
			session.close();
			sf.close();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}

	}

}
