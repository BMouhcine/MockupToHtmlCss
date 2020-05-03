package com.project.mockup2html.Testing;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.project.mockup2html.Models.User;
@Stateless
public class UserTest {
	
	  @PersistenceContext(unitName = "defaultPersistenceUnit")
	  EntityManager em;
	  
	  public List<User> findAll(){
		  return em.createNativeQuery("select * from UTILISATEUR", User.class).getResultList();
	  }
	  
	  public void createUser(User user) { em.persist(user); } 
	  public void deleteUser(User user) { user= em.merge(user);em.remove(user); }

	  
	 
}
