package com.project.mockup2html.Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.UserRepository;


@RunWith(Arquillian.class)
public class TestArqContainer {
	
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClasses(User.class, UserTest.class)
				.addAsResource("META-INF/persistence.xml")
				//.addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml")
				;
	}
	
	@Inject
	UserTest ut;
	


	@Test
	public void testUser() {
	
		assertTrue(ut.findAll().isEmpty());
		User test1 =  new User("username_test1", "passwd1", "email1@test.dom");
		User test2 =  new User("username_test2", "passwd2", "email2@test.dom");
		ut.createUser(test1);
		ut.createUser(test2);
		assertEquals(2, ut.findAll().size());
		ut.deleteUser(test1);
		assertEquals(1, ut.findAll().size());
		 
		
	}

}
