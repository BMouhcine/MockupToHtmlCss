package com.project.mockup2html.Controllers;


import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.ImageUIRepository;
import com.project.mockup2html.Repositories.UserRepository;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ImageController {
	@Autowired
	ImageUIRepository imageUIRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@PostMapping(value = "/doUploadImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImageHandler(@RequestParam MultipartFile givenImage) throws IOException {
        System.out.println("File name"+givenImage.getOriginalFilename()+" uploaded successfully.");
        if(UserController.currentUserId!=-1) {
        	User userBuffer = userRepository.findById(UserController.currentUserId).get();
            imageUIRepository.save(new ImageUI(givenImage.getBytes(),userBuffer));
            
        }
        return ResponseEntity.ok().body(null);
    }
	
}