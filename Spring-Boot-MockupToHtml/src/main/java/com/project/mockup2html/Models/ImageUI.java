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
	private Long id_img;
	@Column
	private Long id_user;
	@Column
	private byte[] img;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_user", nullable = false)
	private User user;
	public Long getId_img() {
		return id_img;
	}
	public void setId_img(Long id_img) {
		this.id_img = id_img;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
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
