package com.project.mockup2html.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;

@Repository
public interface ImageUIRepository extends JpaRepository<ImageUI, byte[]>
{
	ImageUI findById(Long id);
	List<ImageUI> findByUser(User user);
	List<ImageUI> findAll();

}