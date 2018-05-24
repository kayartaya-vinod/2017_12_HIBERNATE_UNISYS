package hibernate.training.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate.training.entity.Brand;
import hibernate.training.entity.Customer;
import hibernate.training.entity.Employee;
import hibernate.training.entity.Laptop;
import hibernate.training.entity.LineItem;
import hibernate.training.entity.Order;
import hibernate.training.entity.Product;
import hibernate.training.entity.Skill;

public class HibernateUtil {
	static StandardServiceRegistry serviceRegistry;

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		Properties props = configuration.getProperties();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(props).build();

		// register all entity classes with hibernate
		configuration.addAnnotatedClass(Brand.class);
		configuration.addAnnotatedClass(Product.class);
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Order.class);
		configuration.addAnnotatedClass(LineItem.class);
		configuration.addAnnotatedClass(Laptop.class);
		configuration.addAnnotatedClass(Skill.class);
		configuration.addFile("src/main/resources/category.hbm.xml");

		return configuration.buildSessionFactory(serviceRegistry);
	}

}
