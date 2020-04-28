package com.project.mockup2html.Services;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;


@Service
public interface ImageService {
	ImageUI findById(Long img_id);
	List<ImageUI> findByUser(User user);
	List<ImageUI> findAll();
	ImageUI save(@Valid ImageUI imageUI);

}