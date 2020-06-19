package com.project.mockup2html.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Code {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String htmlcode;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_user", nullable = false)
	private User user;
	
	
	@OneToOne
	@JoinColumn(name="id_img", nullable = false, referencedColumnName = "id")
	private ImageUI imageUI;
	
	
	public Code() {
		// TODO Auto-generated constructor stub
	}
	public Code(String htmlcode, User user, ImageUI imageUI) {
		super();
		this.imageUI = imageUI;
		this.user = user;
		this.htmlcode = htmlcode;
	}
	public Long getId_img() {
		return id;
	}
	public void setId_img(Long id_img) {
		this.id = id_img;
	}
	
	public String getHtmlCode() {
		return htmlcode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHtmlcode() {
		return htmlcode;
	}
	public void setHtmlcode(String htmlcode) {
		this.htmlcode = htmlcode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ImageUI getImageUI() {
		return imageUI;
	}
	public void setImageUI(ImageUI imageUI) {
		this.imageUI = imageUI;
	}

	
}
