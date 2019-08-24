package hibernate.test;

import hibernate.test.dto.EmployeeEntity;

import org.hibernate.Session;

public class TestHibernate {
	private static int id = 6;

	public static void main(String[] args) {

//		testInsert();


		//load --> exception;  get --> null
//		testLoad();
//		testLoad2();
		testLoad3();


	}





	private static void testLoad3() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		EmployeeEntity emp = new EmployeeEntity();
		session.load(emp, id - 1);

		emp.setEmail("anyemial@hotmail.com");

		HibernateUtil.shutdown();

		System.out.println(emp);
	}



	private static void testLoad2() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		EmployeeEntity emp = (EmployeeEntity)session.load("hibernate.test.dto.EmployeeEntity", id - 1);

		HibernateUtil.shutdown();

		System.out.println(emp);
	}


	private static void testLoad() {
		Session session = HibernateUtil.getSessionFactory().openSession();


		//
		EmployeeEntity emp = (EmployeeEntity)session.load(EmployeeEntity.class, id - 1);

		System.out.println(emp);



		HibernateUtil.shutdown();

		System.out.println("testLoad :: done.....");
	}


	private static void testInsert() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo-user" + id + "@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");

		session.save(emp);

		session.getTransaction().commit();
		HibernateUtil.shutdown();


		System.out.println("testInsert :: done.....");
	}



}
