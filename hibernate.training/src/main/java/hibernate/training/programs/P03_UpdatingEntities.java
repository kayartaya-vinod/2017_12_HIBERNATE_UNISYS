package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Brand;
import hibernate.training.entity.Product;
import hibernate.training.utils.HibernateUtil;
import hibernate.training.utils.LoggingInterceptor;

public class P03_UpdatingEntities {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {

			Session session = factory.withOptions().interceptor(new LoggingInterceptor()).openSession();

			session.beginTransaction();

			// get an entity
			// Brand b1 = session.get(Brand.class, 4);
			// System.out.println(b1);

			// b1.setName(b1.getName() + "*");

			// System.out.println(b1);

			Product p1 = session.get(Product.class, 1);

			p1.setUnitPrice(p1.getUnitPrice() + 2);
			Brand b1 = new Brand("Test");
			session.save(b1);
			
			System.out.println("---1");
			session.getTransaction().commit();
			System.out.println("---2");
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}
}
