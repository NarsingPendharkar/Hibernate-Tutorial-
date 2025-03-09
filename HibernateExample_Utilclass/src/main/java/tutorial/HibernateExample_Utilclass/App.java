package tutorial.HibernateExample_Utilclass;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
	

    public static void main( String[] args )
    {
      SessionFactory sf= HibernateUtil.getSessionFactory() ;
      Session session=sf.openSession();
      Transaction txn=null;
      try {
    	 txn=session.beginTransaction();
    	 Answers a1=new Answers("23","nikita");
    	 Answers a2=new Answers("34","nikita");
    	 Answers a3=new Answers("54","nikita");
    	 Answers a4=new Answers("22","nikita");
    	List<Answers> all= Arrays.asList(a1,a2,a3,a4);
    	 Question q=new Question("what is your age ?", all);
    	 session.saveOrUpdate(q);
    	 txn.commit();
    	 System.out.println("question saved");
    	 session.close();
    	 HibernateUtil.shutdown();
    	  
	} catch (Exception e) {
		if(txn!=null) {
			txn.rollback();
		}
		e.printStackTrace();
		
	}
    }
}
