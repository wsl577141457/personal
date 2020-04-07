package Hibernate;

import com.longge.domain.Customer;
import com.longge.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/*
* 延迟查询和立即查询
* */
public class Hibernate7 {

    @Test
    public void test2(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            //立即查询
            Customer customer = (Customer) session.get(Customer.class,2);
            //延迟查询
            Customer customer2 = (Customer) session.load(Customer.class,2);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }

    //批量抓取，可以提高性能
    @Test
    public void test3(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            //立即查询
            Customer customer = (Customer) session.get(Customer.class,2);
            //延迟查询
            Customer customer2 = (Customer) session.load(Customer.class,2);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }
}
