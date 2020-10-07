package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Jersey;

public class JerseyHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
	
	public void insertJersey(Jersey j) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Jersey> showAllJerseys(){
		EntityManager em = emfactory.createEntityManager();
		List<Jersey> allJerseys = em.createQuery("select j from Jersey j").getResultList();
		return allJerseys;
	}
}
