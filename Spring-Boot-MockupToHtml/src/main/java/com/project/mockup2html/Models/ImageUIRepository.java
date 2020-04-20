package com.project.mockup2html.Models;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;

public interface ImageUIRepository extends CrudRepository<ImageUI, byte[]>
{
	ImageUI findById(Long id_img);
	ImageUI findByUser(User user);
	Collection<ImageUI> findAll();

}