package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.training.entity.Employee;
import hibernate.training.entity.Skill;
import hibernate.training.utils.HibernateUtil;

public class P13_ManyToManyDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			Employee e1 = session.get(Employee.class, 2);
			Employee e2 = session.get(Employee.class, 4);
			
			Skill s1 = new Skill(101, "Java");
			Skill s2 = new Skill(201, "C#");
			Skill s3 = new Skill(404, "Oracle");
			
			s1.getEmployees().add(e1);
			s1.getEmployees().add(e2);
			s2.getEmployees().add(e1);
			
			session.persist(s1);
			session.persist(s2);
			session.persist(s3);
			
			tx.commit();
			session.close();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
		
	}
}
