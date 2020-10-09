package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public void deleteJersey(Jersey toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Jersey> typedQuery = em.createQuery("select j from Jersey j where j.id = :selectedId", Jersey.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		Jersey result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Jersey searchForJerseyById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Jersey found = em.find(Jersey.class, tempId);
		em.close();
		return found;
	}
}
