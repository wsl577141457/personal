package com.longge.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*
* SessionFactory工具类
* */
public class HibernateUtils {
    static Configuration configuration = null;
    static SessionFactory sessionFactory = null;
    //静态代码块实现
    static {
        //加载核心配置文件
        configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    //返回与本地线程绑定的session，也就是单线程
    public static Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public static void main(String[] args) {

    }
}
