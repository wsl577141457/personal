package Hibernate;

import com.longge.domain.Customer;
import com.longge.domain.LinkMan;
import com.longge.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

/*
* 一对多级联练习
* */
public class HibernateDemo3 {
    //级联保存
    @Test
    public void addOneToMany(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //创建一个客户
            Customer customer = new Customer();
            customer.setName("客户2");

            //创建一个联系人
            LinkMan linkMan = new LinkMan();
            linkMan.setName("联系人2");


            //保存,一般先保存客户在保存联系人，因为有客户才有联系人
            session.save(customer);
            session.save(linkMan);

            //把联系人放到客户里面
            customer.getLinkManSet().add(linkMan);

            //保存
            session.save(customer);
            session.save(linkMan);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }

    //级联删除
    @Test
    public void deleteOneToMany(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //根据id查询客户
            Customer customer = (Customer) session.get(Customer.class,3);
            //删除
            session.delete(customer);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }

    //级联更新
    @Test
    public void updateOneToMany(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //根据id查询联系人和客户
            Customer customer = (Customer) session.get(Customer.class,4);
            LinkMan linkMan = (LinkMan) session.get(LinkMan.class,2);

            customer.getLinkManSet().add(linkMan);
            linkMan.setCustomer(customer);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }
}
