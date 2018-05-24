package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Product;
import hibernate.training.utils.HibernateUtil;

public class P05_GetProductById {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Session session = factory.openSession();
			Product p1 = session.get(Product.class, 45);
			session.close();
			
			System.out.println("Name of the product = " + p1.getName());
			System.out.println("Brand = " + p1.getBrand().getName());
			System.out.println("Category = " + p1.getCategory().getName());
			
		} finally {
			factory.close();
		}
		
	}
}
