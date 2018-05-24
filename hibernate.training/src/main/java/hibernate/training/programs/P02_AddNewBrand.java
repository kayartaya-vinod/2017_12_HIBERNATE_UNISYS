package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.training.entity.Brand;
import hibernate.training.utils.HibernateUtil;

public class P02_AddNewBrand {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Brand b1 = new Brand("Bata");
			b1.setId(20);
			
			
			System.out.println(b1);
			
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.persist(b1);
			tx.commit();
			System.out.println(b1);
			
		} finally {
			factory.close();
		}
		
	}
}
