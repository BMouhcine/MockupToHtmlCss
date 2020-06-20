package com.project.mockup2html.Services;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mockup2html.Models.Code;
import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.CodeRepository;



@Repository
public class CodeServiceImpl implements CodeService {
	@Autowired
	CodeRepository codeRepository;


	@Override
	public Code findById(Long id) {
		// TODO Auto-generated method stub
		return codeRepository.findById(id);
	}

	@Override
	public Code findByImageUI(ImageUI imageUI) {
		// TODO Auto-generated method stub
		return codeRepository.findByImageUI(imageUI);
	}


	@Override
	public List<Code> findAll() {
		// TODO Auto-generated method stub
		return codeRepository.findAll();
	}

	@Override
	public Code save(@Valid Code code) {
		// TODO Auto-generated method stub
		return codeRepository.save(code);
	}

	@Override
	public List<Code> findAllByUserCode(User userCode) {
		// TODO Auto-generated method stub
		return codeRepository.findAllByUserCode(userCode);
	}
	
	
	




}