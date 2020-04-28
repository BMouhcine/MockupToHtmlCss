package com.project.mockup2html.Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.ejb.EJB;
import javax.inject.Inject;
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
	@EJB
	UserRepository userRepository;
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClasses(User.class,UserTest.class)
				.addAsResource("persistence.xml").addAsManifestResource(EmptyAsset.INSTANCE,
		                "beans.xml");
	}
	
	@Inject
	private UserTest userTest;
	@Test
	public void testUser() {
		
		
		  assertTrue(userTest.findAll().isEmpty());
		  
		  User test1 = new User(1,"user_test1","usr1","usr1@usr1.dom",true); 
		  User test2 = new User(2,"user_test2","usr2","usr2@usr2.dom",true); 
		  userTest.createUser(test1);
		  userTest.createUser(test2);
		  
		  assertEquals(2, userTest.findAll().size());
		  
		  
		  userTest.deleteUser(test1);
		  
		  assertEquals(1, userTest.findAll().size());
		 
		
	}

}
