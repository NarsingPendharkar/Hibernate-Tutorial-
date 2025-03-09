package tutorial.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OnetoOne {
	public static void data(String[] args) {
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySetting("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver")
				.applySetting("hibernate.connection.url","jdbc:sqlserver://DESKTOP-G774017:1433;databaseName=hibernateTutorial;encrypt=false")
				.applySetting("hibernate.connection.username", "Narsing")
				.applySetting("hibernate.connection.password", "root")
				.applySetting("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect")
				.applySetting("hibernate.hbm2ddl.auto", "update").applySetting("hibernate.show_sql", "true").build();

		// Scan the package and register all entity classes automatically
		Metadata meta=new MetadataSources(registry)
				.addAnnotatedClass(Passport.class)
				.addAnnotatedClass(Person.class).buildMetadata();
		
		SessionFactory sf = meta.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = null;
		try {
			txn = session.beginTransaction();
			Person person=new Person();
			person.setName("Narsing");
			Passport passport =new Passport();
			passport.setPerson(person);
			passport.setPassportNumber("NAP1232");
			person.setPassport(passport);
			// operation performed here
			session.saveOrUpdate(person);
			System.out.println("saved person");
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
				e.printStackTrace();
			}
		}

	}
	
}
