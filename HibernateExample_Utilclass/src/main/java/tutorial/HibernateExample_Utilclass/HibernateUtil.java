package tutorial.HibernateExample_Utilclass;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static  SessionFactory sessionFactory;
	
	static {	
		try {
			Configuration cfg = new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cfg.setProperty("hibernate.connection.url","jdbc:sqlserver://DESKTOP-G774017:1433;databaseName=hibernateTutorial;encrypt=false");
			cfg.setProperty("hibernate.connection.username", "Narsing");
			cfg.setProperty("hibernate.connection.password", "root");
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
			cfg.setProperty("hibernate.hbm2ddl.auto", "update");
			cfg.setProperty("hibernate.show_sql", "true");
			cfg.addAnnotatedClass(Question.class);
			cfg.addAnnotatedClass(Answers.class);
			sessionFactory=cfg.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("Error in session factory");
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void  shutdown() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
	

}
