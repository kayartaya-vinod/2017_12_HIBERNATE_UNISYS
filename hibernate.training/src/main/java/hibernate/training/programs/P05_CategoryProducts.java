package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Category;
import hibernate.training.entity.Product;
import hibernate.training.utils.HibernateUtil;

public class P05_CategoryProducts {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Session session = factory.openSession();
			
			// get one category
			Category c1 = session.get(Category.class, 1);
			
			
			System.out.println("Category is : " + c1.getName());
			System.out.println("Products in this category: ");
			for(Product p: c1.getProducts()){
				System.out.println(p.getName() + " - " + p.getDescription());
			}
			
			
			System.out.println("Products is an instanceof " + c1.getProducts().getClass());
			session.close();
			
		} finally {
			factory.close();
		}
		
	}
}
