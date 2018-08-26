package com.gulshan.irs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.gulshan.irs.entity.UserEntity;
import com.gulshan.irs.model.User;

@Repository
public class UserRegisterationDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
	public UserEntity findOne(String userName) {
		Transaction tx = null;
		Session session = null;
		UserEntity user=null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			CriteriaBuilder cBuilder=session.getCriteriaBuilder();
			CriteriaQuery<UserEntity> crQuery=cBuilder.createQuery(UserEntity.class);
			Root<UserEntity> userroot = crQuery.from(UserEntity.class);
			crQuery.select(userroot);
			crQuery.where(cBuilder.equal(userroot.get("name"), userName));
			Query<UserEntity> query = session.createQuery(crQuery);
			user = query.getSingleResult();
			System.out.println(user.getName() +" "+user.getPassword());
			System.out.println("exiting USERDAO");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
		
	}
	
	

	public List<UserEntity> getUserList() {
		Transaction tx = null;
		Session session = null;
		List<UserEntity> userList = null;
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();

			CriteriaBuilder cbuilder = session.getCriteriaBuilder();
			CriteriaQuery<UserEntity> crQuery = cbuilder.createQuery(UserEntity.class);
			Root<UserEntity> root = crQuery.from(UserEntity.class);
			crQuery.select(root);
			Query<UserEntity> query = session.createQuery(crQuery);

			userList = query.getResultList();
			

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}
		
		return userList;
	}

	public void addUser(UserEntity userEntity) {
		// TODO Auto-generated method stub

		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.persist(userEntity);
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}

	}

	public UserEntity getDetails(String userId) {
		// TODO Auto-generated method stub
		UserEntity userEntity = null;
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("in DAo class and starting fetching");
			userEntity = session.get(UserEntity.class, userId);
			System.out.println("in   DAo class with " + userEntity.getName());
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userEntity;
	}

	// write query to fetch complete list of users

}
