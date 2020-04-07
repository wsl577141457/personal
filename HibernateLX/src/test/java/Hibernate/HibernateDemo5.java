package Hibernate;

import com.longge.domain.Account;
import com.longge.domain.Customer;
import com.longge.domain.LinkMan;
import com.longge.domain.Role;
import com.longge.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/*
* HQL语句
* */
public class HibernateDemo5 {
    //对象导航查询
    @Test
    public void testSelect1(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //查询id为1的客户以及该客户下面的全部联系人
            Customer customer = (Customer) session.get(Customer.class,4);
            Set<LinkMan> linkManSet = customer.getLinkManSet();
            System.out.println(linkManSet.size());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }

    //HQL查询
    @Test
    public void testSelect2(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //查询所有客户
            Query query = session.createQuery("from Customer");
            List<Customer> list = query.list();
            System.out.println(list.size());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }
    }

    //HQL条件查询
    @Test
    public void testSelect3(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //查询所有客户
            Query query = session.createQuery("from Customer where id = ? and name = ?");
            //设置条件的值
            query.setParameter(0,2);
            query.setParameter(1,"客户1");

            List<Customer> list = query.list();
            System.out.println(list.get(0));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }
    }

    //HQL排序查询
    @Test
    public void testSelect4(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //查询所有客户
            Query query = session.createQuery("from Customer order by id asc ");

            List<Customer> list = query.list();
            System.out.println(list.get(0));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }
    }

    //HQL分页查询
    @Test
    public void testSelect5(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //查询所有客户
            Query query = session.createQuery("from Customer");
            //设置开始位置
            query.setFirstResult(0);
            //设置每一页记录数
            query.setMaxResults(2);

            List<Customer> list = query.list();
            System.out.println(list.get(0));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }
    }

    //HQL投影查询（投影查询就是只查询个别的列）
    @Test
    public void testSelect6(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //查询所有客户
            Query query = session.createQuery("select id,name from Customer");


            List<Object> list = query.list();
            System.out.println(list.get(0));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }
    }

    //HQL聚集函数
    @Test
    public void testSelect7(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //查询所有客户
            Query query = session.createQuery("select count(id) from Customer ");
            System.out.println(query.uniqueResult());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }
    }
}
