package com.ray.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ray.config.HibernateSessionFactoryConfig;

public abstract class JpaDAO<T> {
	private SessionFactory sessionFactory;
	private Class<T> _genericClass; /// _genericClass = User.Class || Product.Class

	public JpaDAO(Class<T> genericClass) {
		this.sessionFactory = HibernateSessionFactoryConfig.getSessionFactory();
		this._genericClass = genericClass;
	}
	
	public T create(T object) {
		Transaction transaction = null;
		
		try (Session session = sessionFactory.openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			session.save(object);
			
			// force to write data on database
			session.flush();
			
			session.refresh(object);
			
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		
		return object;
	}
	
	public T update(T object) {
		Transaction transaction = null;
		
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			
			session.update(object);
			
			transaction.commit();
			
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return object;
	}
	
	public T getById(Object objectId) {
		Transaction transaction = null;
		Object queryObject = null;
		T result = null;
		
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			
			queryObject = session.get(_genericClass, (Serializable) objectId);
			
			/// Class<T> --> User.class 
			result = _genericClass.cast(queryObject);
					
			transaction.commit();
			
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return result;
	}
	
	public List<T> getListAll() {
		return null;
	}
	
	public void deleteById(T objectId) {
		Transaction transaction = null;
		Object queryObject = null;
		
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			
			// get object to delete
			queryObject = session.get(_genericClass, (Serializable) objectId);
			
			if (queryObject != null) {
				session.delete(queryObject);
				System.out.println("Delete successful");
			}
			
			transaction.commit();
			
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
	}
}
