package com.project.mockup2html.Dao;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.ImageUIRepository;
import com.project.mockup2html.Models.User;


@Repository
public class ImageUIDaoImpl implements ImageUIDao {
	@Autowired
	ImageUIRepository imageUIRepository;
	@Override
	public ImageUI findById(Long id_img) {
		return imageUIRepository.findById(id_img);
	}

	@Override
	public Collection<ImageUI> findByUser(User user) {
		return imageUIRepository.findByUser(user);
	}

	@Override
	public Collection<ImageUI> findAll() {
		return imageUIRepository.findAll();
	}

	@Override
	public ImageUI save(@Valid ImageUI imageUI) {
		return imageUIRepository.save(imageUI);
	}



}