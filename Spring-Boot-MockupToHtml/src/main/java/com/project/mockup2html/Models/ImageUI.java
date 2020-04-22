package com.project.mockup2html.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class ImageUI {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private byte[] img;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_user", nullable = false)
	private User user;
	
	
	public ImageUI(byte[] img, User user) {
		super();
		this.img = img;
		this.user = user;
	}
	public Long getId_img() {
		return id;
	}
	public void setId_img(Long id_img) {
		this.id = id_img;
	}
	
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
