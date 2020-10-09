package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;

public class ListPlayerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
	
	public void insertPlayer(Player li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> showAllPlayers(){
		EntityManager em = emfactory.createEntityManager();
		List<Player> allPlayers = em.createQuery("SELECT li FROM Player li").getResultList();
		return allPlayers;
	}
	
	public void deletePlayer(Player toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select li from Player li where li.team = :selectedTeam and li.name = :selectedName", Player.class);
		
		typedQuery.setParameter("selectedTeam", toDelete.getTeam());
		typedQuery.setParameter("selectedName", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		Player result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Player searchForPlayerById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player found = em.find(Player.class, idToEdit);
		em.close();
		return	found;
	}

	public void updatePlayer(Player toEdit) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Player> searchForPlayerByTeam(String teamName) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player>	typedQuery	=	em.createQuery("select li from ListItem	li where li.team =	:selectedTeam", Player.class);
		typedQuery.setParameter("selectedTeam",	teamName);
		List<Player>	foundItems	=	typedQuery.getResultList();
		em.close();
		return	foundItems;
	}

	public List<Player> searchForPlayerByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select li from ListItem li where li.name = :selectedName",	Player.class);
		typedQuery.setParameter("selectedName",	name);
		List<Player> foundItems = typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
