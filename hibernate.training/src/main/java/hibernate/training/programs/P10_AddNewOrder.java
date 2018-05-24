package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.training.entity.Customer;
import hibernate.training.entity.LineItem;
import hibernate.training.entity.Order;
import hibernate.training.entity.Product;
import hibernate.training.utils.HibernateUtil;

public class P10_AddNewOrder {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			// get the customer
			Customer c1 = session.get(Customer.class, 1);
			
			// get 3 products
			Product p1 = session.get(Product.class, 22);
			Product p2 = session.get(Product.class, 33);
			Product p3 = session.get(Product.class, 44);
			
			// create 3 lineItems
			LineItem li1 = new LineItem();
			li1.setProduct(p1);
			li1.setQuantity(3);
			li1.setUnitPrice(p1.getUnitPrice());
			
			LineItem li2 = new LineItem();
			li2.setProduct(p2);
			li2.setQuantity(1);
			li2.setUnitPrice(p2.getUnitPrice());

			LineItem li3 = new LineItem();
			li3.setProduct(p3);
			li3.setQuantity(2);
			li3.setUnitPrice(p3.getUnitPrice());
			
			// create a new Order instance and associate customer, line items with the order
			Order order1 = new Order();

			order1.setCustomer(c1);
			order1.addLineItem(li1);
			order1.addLineItem(li2);
			order1.addLineItem(li3);
			
			// save the order instance
			session.persist(order1);
			
			System.out.println("Done!");
			tx.commit();
			session.close();
		} finally {
			factory.close();
		}
		
	}
}
