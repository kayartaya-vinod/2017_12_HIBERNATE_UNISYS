package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.ContactInfo;
import hibernate.training.entity.Employee;
import hibernate.training.utils.HibernateUtil;

public class P09_AddNewEmployee {
	
	public static void main(String[] args) {
		
		// <property name="hibernate.hbm2ddl.auto">update</property>
		Employee e1 = new Employee();
		e1.setName("Krishna");
		e1.setSalary(25000.0);
		ContactInfo ci = e1.getContactInfo();
		ci.setAddress("1st cross, 2nd main, ISRO lyt");
		ci.setCity("Bangalore");
		ci.setState("Karnataka");
		ci.setCountry("India");
		ci.setEmail("krishna@mailinator.com");
		ci.setPhone("9877733456");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			session.persist(e1);
			session.getTransaction().commit();
			session.close();
		} finally {
			factory.close();
		}
		
	}
}
