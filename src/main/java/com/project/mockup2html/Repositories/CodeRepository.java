package com.project.mockup2html.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mockup2html.Models.Code;
import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;

@Repository
public interface CodeRepository extends JpaRepository<Code, byte[]>
{
	Code findById(Long id);
	List<Code> findByUser(User user);
	Code findByImageUI(ImageUI imageUI);
	List<Code> findAll();

}