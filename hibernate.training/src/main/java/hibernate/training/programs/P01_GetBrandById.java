package hibernate.training.programs;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Brand;
import hibernate.training.entity.Product;
import hibernate.training.utils.HibernateUtil;

public class P01_GetBrandById {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		try {
			Session session = factory.openSession();
			Brand b1 = session.get(Brand.class, 1);
			b1 = session.get(Brand.class, 1);
			
			Set<Product> products = b1.getProducts();
			System.out.println("There are " + products.size() 
				+ " products in the brand " + b1.getName());
			
			
			b1 = session.get(Brand.class, 6);

			if (b1 != null) {
				session.beginTransaction();
				try {
					session.delete(b1);
					System.out.println(b1 + " got deleted!");
					session.getTransaction().commit();
				} catch (Exception e) {
					session.getTransaction().rollback();
				}
			}
			else {
				System.out.println("No brand for id 6");
			}

			// Category c1 = session.get(Category.class, 1);
			session.close();

			System.out.println(b1);
			// System.out.println(c1);

		} finally {
			factory.close();
		}
	}

}
