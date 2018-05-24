package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.training.entity.Brand;
import hibernate.training.entity.Product;
import hibernate.training.utils.HibernateUtil;

public class P06_AddBrandWithProducts {
	
	public static void main(String[] args) {
		
		Brand b1 = new Brand("LG");
		Product p1 = new Product();
		p1.setName("55 inch LED Television");
		p1.setUnitPrice(850000.0);
		
		b1.addProduct(p1);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(b1);
			tx.commit();
			session.close();
		} finally {
			factory.close();
		}
		
	}
}
