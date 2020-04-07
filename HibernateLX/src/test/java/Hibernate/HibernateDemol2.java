package Hibernate;

import com.longge.domain.User;
import com.longge.utils.HibernateUtils;
import org.hibernate.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/*
* 本类是展示Query Criteria SQLQuery三种hql语句查询的例子
* */
public class HibernateDemol2 {
    @Test
    public void testQuery(){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtils.getSession();
            //开启事务
            tx = session.beginTransaction();
            //方法里面写hql语句
            Query query = session.createQuery("from User");
            //调用query对象里面的方法获取结果
            List<User> list = query.list();
            for (User user : list){
                System.out.println(user);
            }
            //提交事务
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        }finally {
            session.close();
        }
    }

    @Test
    public void testCriteria(){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtils.getSession();
            //开启事务
            tx = session.beginTransaction();
            //创建Criteria对象
            Criteria criteria = session.createCriteria(User.class);
            //调用方法得到结果
            List<User> list = criteria.list();
            for (User user : list){
                System.out.println(user);
            }
            //提交事务
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        }finally {
            session.close();
        }
    }

    @Test
    public void testSQLQuery(){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtils.getSession();
            //开启事务
            tx = session.beginTransaction();
            //创建sqlQuery对象
            SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
            /*//调用方法得到结果,但是SQLQuery的是一个数组的集合，每一个数组里面存放的是一个User的各个属性的值
            List<Object[]> list = sqlQuery.list();
            for (Object[] objects : list){
                System.out.println(Arrays.toString(objects));
            }*/
            //直接讲结果放在User的集合的方式
            sqlQuery.addEntity(User.class);
            List<User> list = sqlQuery.list();
            for (User user : list){
                System.out.println(user);
            }
            //提交事务
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        }finally {
            session.close();
        }
    }

}
