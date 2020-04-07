package Hibernate;

import com.longge.domain.Account;
import com.longge.domain.Customer;
import com.longge.domain.Role;
import com.longge.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/*
* HQL多表查询
* */
public class HibernateDemo6 {
    //内连接
    @Test
    public void test1(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("from Customer c inner join c.linkManSet");
            List<Object[]> list = query.list();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }

    //迫切内连接，内连接返回的每一个是数组，迫切内连接返回的是对象
    @Test
    public void test2(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("from Customer c inner join fetch c.linkManSet");
            List<Customer> list = query.list();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }
}
