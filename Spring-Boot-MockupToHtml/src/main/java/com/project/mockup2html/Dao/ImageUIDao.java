package com.project.mockup2html.Dao;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;


@Service
public interface ImageUIDao {
	ImageUI findById(Long img_id);
	Collection<ImageUI> findByUser(User user);
	Collection<ImageUI> findAll();
	ImageUI save(@Valid ImageUI imageUI);

}