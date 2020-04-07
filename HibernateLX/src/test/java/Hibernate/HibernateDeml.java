package Hibernate;

import com.longge.domain.User;
import com.longge.utils.HibernateUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class HibernateDeml {
    @Test
    public void Add(){
        //加载hibernate核心配置文件
        Configuration cfg = new Configuration();
        cfg.configure();
        //创建SessionFactory对象,一般一个项目只创建一个，因为创建一个这个对象很耗费资源，可以使用工具类包装
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //使用SessionFactory创建session对象
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //crud操作
        User user = new User();
        user.setCode("aaa");
        user.setPassword("123");
        user.setName("小龙");
        session.save(user);
        //提交事务
        transaction.commit();
        //关闭
        session.close();
        sessionFactory.close();
    }
}
