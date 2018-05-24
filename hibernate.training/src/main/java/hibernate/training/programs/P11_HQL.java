package hibernate.training.programs;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.training.entity.Category;
import hibernate.training.entity.Customer;
import hibernate.training.entity.Product;
import hibernate.training.utils.HibernateUtil;

@SuppressWarnings("deprecation")
public class P11_HQL {
	
	static Session session;
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			session = factory.openSession();
			
			// printAllCategories();
			// printProductsByPriceRange(10.0, 15.0);
			// printProductsByBrandName("Zespri");
			// printProductsByPage(5); // pageNo = 5
			// printProductNames();
			// printProductNamesAndPrices();
			// printCategorywiseProductCount();
			// increaseProductPriceBy(5.0); // Rs.5
			// printCustomerByPhone("9731424784");
			printOrderTotal(2); // orderId = 2
			
			
			session.close();
		} finally {
			factory.close();
		}
	}

	static void printOrderTotal(int orderId) {
		String sql = "select t1.id as id, t3.name as customer, sum(t2.quantity*t2.unit_price) as total "
				+ "from orders t1 join line_items t2 on t1.id = t2.order_id "
				+ "join customers t3 on t1.customer_id = t3.id "
				+ "where t1.id = " + orderId + " "
				+ "group by t1.id, t3.name";
		
		SQLQuery qry = session.createSQLQuery(sql);
		List<Object[]> list = qry.list();
		for(Object[] data: list){
			System.out.println(data[0] + " " + data[1] + " --> Rs." + data[2]);
		}
	}

	static void printCustomerByPhone(String phone) {
		String hql = "from Customer where phone = :PHONE";
		Query<Customer> qry = session.createQuery(hql, Customer.class);
		qry.setParameter("PHONE", phone);
		Customer c1 = qry.uniqueResult();
		System.out.println("Name = " + c1.getName());
		System.out.println("Phone = " + c1.getContactInfo().getPhone());
	}

	static void increaseProductPriceBy(double inc) {
		String hql = "update Product set unitPrice = unitPrice + :INC";
		Query qry = session.createQuery(hql);
		qry.setParameter("INC", inc);
		session.beginTransaction();
		int status = qry.executeUpdate(); // used for SQL INSERT/UPDATE/DELETE
		session.getTransaction().commit();
		System.out.printf("%d products updated with new price!", status);
	}

	static void printCategorywiseProductCount() {
		String hql = "select p.category.name, count(p), avg(p.unitPrice) from Product p "
				+ "group by p.category.name";
		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		List<Object[]> list = qry.list();

		for (Object[] data : list) {
			System.out.println(data[0] + " --> " + data[1] + ", " + data[2]);
		}
	}

	static void printProductNamesAndPrices() {
		String hql = "select name, unitPrice from Product";
		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		qry.setMaxResults(10);
		List<Object[]> list = qry.list();

		for (Object[] data : list) {
			System.out.println(data[0] + " --> Rs." + data[1]);
		}
	}


	static void printProductNames() {
		String hql = "select name from Product order by name";
		Query<String> qry = session.createQuery(hql, String.class);
		for(String name: qry.list()){
			System.out.println(name);
		}
	}


	static void printProductsByPage(int pageNum) {
		int pageSize = 10;
		int offset = (pageNum-1) * pageSize;
		Query<Product> qry = session.createQuery(
				"from Product order by id", Product.class);
		
		qry.setMaxResults(pageSize);
		qry.setFirstResult(offset);
		
		List<Product> list = qry.list();
		for(Product p: list){
			System.out.printf("%2d %s --> Rs.%.2f\n", 
					p.getId(), p.getName(), p.getUnitPrice());
		}
	}


	static void printProductsByBrandName(String brandName) {
		String hql = "from Product where brand.name = :BRAND_NAME";
		Query<Product> qry = session.createQuery(hql, Product.class);
		qry.setParameter("BRAND_NAME", brandName);
		List<Product> list = qry.list();
		for(Product p: list){
			System.out.printf("%s (%s) --> Rs.%.2f\n", 
					p.getName(), p.getBrand().getName(), p.getUnitPrice());
		}
	}


	static void printProductsByPriceRange(double min, double max) {
		// String hql = "from Product where unitPrice between ? and ? order by unitPrice";
		String hql = "from Product where unitPrice between :MIN_PRICE and :MAX_PRICE order by unitPrice";
		Query<Product> qry = session.createQuery(hql, Product.class);
		// qry.setParameter(0, min);
		// qry.setParameter(1, max);
		qry.setParameter("MIN_PRICE", min);
		qry.setParameter("MAX_PRICE", max);
		
		List<Product> list = qry.list();
		for(Product p: list){
			System.out.printf("%s --> Rs.%.2f\n", p.getName(), p.getUnitPrice());
		}
	}


	static void printAllCategories() {
		// sql -> SELECT * FROM CATEGORIES
		// HQL -> select c1 from Category c1
		//     -> from Category
		Query<Category> qry = session.createQuery("from Category", Category.class);
		List<Category> list = qry.list(); // SQL is fired here!
	
		for(Category c: list){
			System.out.println(c);
		}
	}

}
