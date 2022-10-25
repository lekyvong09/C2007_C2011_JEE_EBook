package com.ray.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactoryConfig {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/C2007_C2011_ebook?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "ab123456..");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				
				settings.put(Environment.SHOW_SQL, "true");
				
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				Configuration configuration = new Configuration();
				configuration.setProperties(settings);
				
//				configuration.addAnnotatedClass();
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		return sessionFactory;
	}
}
