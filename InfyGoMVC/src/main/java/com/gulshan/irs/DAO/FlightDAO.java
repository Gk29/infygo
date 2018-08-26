package com.gulshan.irs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.aspectj.org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.gulshan.irs.entity.FlightEntity;
import com.gulshan.irs.entity.UserEntity;

@Repository
public class FlightDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public List<String> getSource() {
		System.out.println("inside flightDAo");
		Transaction tx = null;
		Session session = null;
		List<String> flightSource = null;
		try {
			System.out.println("1");
			session = sessionFactory.openSession();
			System.out.println("2");
			tx=session.beginTransaction();
			System.out.println("inside flightDAo1");
			CriteriaBuilder cBuilder=session.getCriteriaBuilder();
			CriteriaQuery<String> crQuery=cBuilder.createQuery(String.class);
			System.out.println("inside flightDAo2");
			Root<FlightEntity> flightroot = crQuery.from(FlightEntity.class);
			crQuery.multiselect(flightroot.get("source")).distinct(true);
			System.out.println("inside flightDAo3");		  
			
			Query<String> query = session.createQuery(crQuery);
			 flightSource = query.getResultList();
		System.out.println("Inside flightDao4");
			 for (String source : flightSource) {
				 System.out.println(source);
			}
			 System.out.println(5);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("inside flightDAo catch");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return flightSource;
	}
	public List<String> getDestination() {
		Transaction tx = null;
		Session session = null;
		List<String> flightSource = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			CriteriaBuilder cBuilder=session.getCriteriaBuilder();
			CriteriaQuery<String> crQuery=cBuilder.createQuery(String.class);
			
			Root<FlightEntity> flightroot = crQuery.from(FlightEntity.class);
			crQuery.multiselect(flightroot.get("destination")).distinct(true);
					  
			
			Query<String> query = session.createQuery(crQuery);
			 flightSource = query.getResultList();
		
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return flightSource;
	}
}
