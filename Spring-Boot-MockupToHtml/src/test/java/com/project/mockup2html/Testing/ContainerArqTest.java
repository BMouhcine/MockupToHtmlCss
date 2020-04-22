package com.project.mockup2html.Testing;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.project.mockup2html.Models.User;
import com.project.mockup2html.Models.UserRepository;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;


@RunWith(Arquillian.class)
public class ContainerArqTest {
	@Autowired
	UserRepository userRepository;
	
	
	/*
	 * @Deployment public static JavaArchive createDeployment() { return
	 * ShrinkWrap.create(JavaArchive.class) .addClass(User.class)
	 * .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml"); }
	 * 
	 * @Inject private User user;
	 */
	
	@Test
	public void testUserRepository() {
		// Initializing given data for testing
	    User test = new User("user_test","usr","usr@usr.dom");
	    
	 // Persisting data into Database.
	    userRepository.save(test);
	    
	 // when finding User object via findByUsername happens.
	    User foundByUsername = userRepository.findByUsername(test.getUsername());
	    
	 // checking the assertion.
	    assertEquals(foundByUsername, test.getUsername());
	}
	

}
