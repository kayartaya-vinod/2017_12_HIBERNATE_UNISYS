package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Brand;
import hibernate.training.utils.HibernateUtil;

public class P04_UpdateOptions {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			// session 1 
			Session session1 = factory.openSession();
			Brand b1 = session1.get(Brand.class, 4); // PERSISTENT OBJECT
			session1.close();
			
			// b1 is a DETACHED OBJECT
			// changes to b1 does not sync with db data
			
			b1.setName(b1.getName().toLowerCase());
			
			// session 2
			Session session2 = factory.openSession();
			session2.beginTransaction();
			session2.merge(b1); // b1 is now a PERSISTENT OBJECT
			session2.getTransaction().commit();
			session2.close();
			
			// b1 is now a DETACHED OBJECT
			
		} finally {
			factory.close();
		}
		
	}

}
