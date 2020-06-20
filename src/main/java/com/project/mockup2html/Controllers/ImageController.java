package com.project.mockup2html.Controllers;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.project.mockup2html.Models.Code;
import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.CodeRepository;
import com.project.mockup2html.Repositories.ImageUIRepository;
import com.project.mockup2html.Repositories.UserRepository;

import net.minidev.json.JSONObject;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ImageController {
	@Autowired
	ImageUIRepository imageUIRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CodeRepository codeRepository;

	@Autowired
	RestTemplate restTemplate;


	@PostMapping(value = "/doUploadImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImageHandler(@RequestParam MultipartFile givenImage, @RequestParam long user_id) throws IOException {

        if(UserController.currentUserId!=-1) {
        	System.out.println("File name"+givenImage.getOriginalFilename()+" uploaded successfully by "+user_id+".");
        	User userBuffer = userRepository.findById(UserController.currentUserId).get();
        	ImageUI imageUI = new ImageUI(givenImage.getBytes(),userBuffer);
            imageUIRepository.save(imageUI);

            HttpHeaders headers = new HttpHeaders();
        	headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        	MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        	java.io.File file = new java.io.File("file");
            OutputStream os = new FileOutputStream(file);
            os.write(givenImage.getBytes());
            os.close();
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            body.add("file", fileSystemResource);
            // build the request
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            // send POST request
            ResponseEntity<JSONObject> response = restTemplate.postForEntity("http://localhost:5000/post", requestEntity, JSONObject.class);
            JSONObject buff = response.getBody();
            if(response.getStatusCode()==HttpStatus.OK) {

            	Code code = new Code(buff.get("Message").toString(), imageUI);
            	
            	codeRepository.save(code);
				/*
				 * File codeFile = new File("code.html"); FileWriter codeWriter = new
				 * FileWriter(codeFile); codeWriter.write(code.getHtmlcode());
				 * codeWriter.close();
				 */

            	return ResponseEntity.ok().body(buff.get("Message").toString());

            }else {
            	return ResponseEntity.ok().body("error");
            }


        }

        return ResponseEntity.ok().body(null);
    }
	@PostMapping(value = "/getAllCodes")
	public ResponseEntity<List<Code>> getAllCodes(@RequestParam long user_id){
		if(UserController.currentUserId!=-1) {
			User userBuffer = userRepository.findById(UserController.currentUserId).get();
			
			return ResponseEntity.ok().body(codeRepository.findAllByUser(userBuffer));
		}
		return ResponseEntity.ok().body(null);
	}



}