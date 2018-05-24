package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.training.entity.Category;
import hibernate.training.entity.Product;
import hibernate.training.utils.HibernateUtil;

public class P07_AddProductToExistingCategory {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			// c1 is a persistent object; changes to it's members makes it
			// dirty.
			// will be flushed to the db during commit
			Category c1 = session.get(Category.class, 2);
			// System.out.println("c1.products is an instanceof "
			// + c1.getProducts().getClass());

			Product p1 = new Product();
			p1.setName("Water melon");
			p1.setUnitPrice(19.0);
			p1.setQuantityPerUnit("pack of 1 kg pieces");

			c1.addProduct(p1);

			tx.commit();
			session.close();
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}
}
