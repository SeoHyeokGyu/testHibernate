package testHibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

		Category category1 = new Category();
		category1.setName("computer");
		Category category2 = new Category();
		category2.setName("car");

		Product product1 = new Product();
		product1.setName("notebook");
		product1.setPrice(2000);
		product1.setDescription("Awsome notebook !! ");
		product1.setCategory(category1);
		
		category1.getProducts().add(product1);

		Product product2 = new Product();
		product2.setName("notebook2");
		product2.setPrice(20000);
		product2.setDescription("Awsome notebook !! ");
		product2.setCategory(category1);

		category1.getProducts().add(product2);

		Product product3 = new Product();
		product3.setName("Sonata ");
		product3.setPrice(200000);
		product3.setDescription("Popular Car !! ");
		product3.setCategory(category2);

		category2.getProducts().add(product3);

		Session session = sessionFactory.openSession();
		Serializable catId1 = null;
		try {

			Transaction tx = session.beginTransaction();
			
			catId1 = session.save(category1);
			// sql 을 대신해서 객체를 바로 저장,반영
//			session.save(category1);
			session.save(category2); 


//		Product savedProduct = session.get(Product.class, id);
//		System.out.println(savedProduct);

//			Query<Product> theQuery = session.createQuery("from Product order by name", Product.class);
//			List<Product> products = theQuery.getResultList();
//			System.out.println(products);

			tx.commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
		}
		
		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();
		
		Category aCategory = session1.get(Category.class, catId1);
		
		Set<Product> products = aCategory.getProducts();
		
		for(Product p: products)
			System.out.println(p.getName());
		
		
		tx1.commit();
		session1.close();

		sessionFactory.close();
	}

}
