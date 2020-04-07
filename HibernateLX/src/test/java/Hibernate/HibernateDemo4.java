package Hibernate;

import com.longge.domain.Account;
import com.longge.domain.Customer;
import com.longge.domain.LinkMan;
import com.longge.domain.Role;
import com.longge.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/*
* 多对多练习
* */
public class HibernateDemo4 {
    //级联保存
    @Test
    public void saveManyToMany(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            //创建对象
            Account account = new Account();
            account.setUsername("long");
            account.setPassword("123");

            Account account2 = new Account();
            account2.setUsername("long2");
            account2.setPassword("123");

            Role role = new Role();
            role.setRole("角色1");

            Role role2 = new Role();
            role2.setRole("角色2");

            Role role3 = new Role();
            role3.setRole("角色3");

            //建立关系
            account.getRoles().add(role);
            account.getRoles().add(role2);

            account2.getRoles().add(role2);
            account2.getRoles().add(role3);

            //保存
            session.save(account);
            session.save(account2);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }

    //让某个账号拥有某个角色,维护第三张表
    @Test
    public void aaa(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            Account account = (Account) session.get(Account.class,6);
            Role role = (Role) session.get(Role.class,2);

            account.getRoles().add(role);



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }

    //让某个账号去除某个角色,维护第三张表
    @Test
    public void aaa2(){
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            Account account = (Account) session.get(Account.class,5);
            Role role = (Role) session.get(Role.class,7);

            account.getRoles().remove(role);



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            factory.close();
        }

    }
}
