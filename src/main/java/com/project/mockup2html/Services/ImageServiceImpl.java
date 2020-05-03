package com.project.mockup2html.Services;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.ImageUIRepository;


@Repository
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageUIRepository imageUIRepository;
	
	
	
	@Override
	public ImageUI findById(Long id_img) {
		return imageUIRepository.findById(id_img);
	}

	@Override
	public List<ImageUI> findByUser(User user) {
		return imageUIRepository.findByUser(user);
	}

	@Override
	public List<ImageUI> findAll() {
		return imageUIRepository.findAll();
	}

	@Override
	public ImageUI save(@Valid ImageUI imageUI) {
		return imageUIRepository.save(imageUI);
	}



}