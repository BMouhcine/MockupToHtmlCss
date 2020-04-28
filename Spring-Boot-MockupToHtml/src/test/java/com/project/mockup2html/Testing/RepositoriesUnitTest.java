package com.project.mockup2html.Testing;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.ImageUIRepository;
import com.project.mockup2html.Repositories.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoriesUnitTest {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ImageUIRepository imageUIRepository;
	

	@Test
	public void whenFindByCriteria() {
	 
		// Initializing given data for testing
	    User test = new User("user_test","usr","usr@usr.dom");
	    ImageUI testImage = new ImageUI("This is a text for testing".getBytes(), test);
	    
	    // Persisting data into Database.
	    

	    userRepository.save(test);
	    imageUIRepository.save(testImage);

	    
	    
	    // when finding User object via findByUsername happens.
	    User foundByUsername = userRepository.findByUsername(test.getUsername());
	    
	    
	    // when finding User object via findByEmail happens.
	    User foundByEmail = userRepository.findByEmail(test.getEmail());
	 
	    
	    // when finding ImageUI object using findById happens.
	    ImageUI imageFoundById = imageUIRepository.findById(Long.valueOf(1));
	    
	    
	    // when finding all ImageUI objects using findByUser happens.
	    Collection<ImageUI> imagesFoundByUser = imageUIRepository.findByUser(test);
	    
	    
	    
	    // then check that the foundByUsername User object is valid.
	    assertThat(foundByUsername.getUsername(), equalTo(test.getUsername()));
	    
	    
		// then check that the foundByEmail User object is valid.
		assertThat(foundByEmail.getEmail(), equalTo(test.getEmail()));
		

		// then check that the imageFoundById ImageUI object is valid.
		assertThat(imageFoundById.getId_img(), equalTo(Long.valueOf(1)));
		
		
		// then check that all ImageUI objects are valid.
		if(imagesFoundByUser.contains(imageFoundById))
			assertThat(1, equalTo(1));
		else
			assertThat(1, equalTo(2));
	
	}
	
}