package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.training.entity.Employee;
import hibernate.training.entity.Laptop;
import hibernate.training.utils.HibernateUtil;

public class P12_OneToOneDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			Laptop lt1 = new Laptop("AB123", "Lenovo", "Z560");
			Laptop lt2 = new Laptop("AC123", "Acer", "TT334");
			Laptop lt3 = new Laptop("XY2233", "Toshiba", "TB8876");
			
			Employee e1 = new Employee();
			e1.setName("John Scott");
			e1.setSalary(23000.0);
			
			Employee e2 = session.get(Employee.class, 2);
			e1.setLaptop(lt2); lt2.setOwner(e1);
			e2.setLaptop(lt3); lt3.setOwner(e2);
			
			session.persist(lt1);
			session.persist(lt2);
			session.persist(lt3);
			
			tx.commit();
			session.close();
			System.out.println("Saved!");
		} finally {
			factory.close();
		}
		
	}
}
