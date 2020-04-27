package testHibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Configuration conf = new Configuration();
//		conf.configure("hiberate.cfg.xml");
//		sessionFactory = conf.buildSessionFactory();
		Serializable id;

		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Product product = new Product();
		product.setName("notebook");
		product.setPrice(2000);
		product.setDescription("Awsome notebook !! ");
		
		Product product2 = new Product();
		product2.setName("notebook2");
		product2.setPrice(20000);
		product2.setDescription("Awsome notebook !! ");
		Session session = sessionFactory.openSession();
		try {
		Transaction tx = session.beginTransaction();
		// sql 을 대신해서 객체를 바로 저장,반영 
		session.save(product);
		session.save(product2);

//		Product savedProduct = session.get(Product.class, id);
//		System.out.println(savedProduct);
		
		Query<Product> theQuery = session.createQuery("from Product order by name",Product.class);
		List<Product> products = theQuery.getResultList();
		System.out.println(products);
		
		
		tx.commit();
		} catch(Exception exc){
			exc.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
