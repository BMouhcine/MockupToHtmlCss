package com.project.mockup2html.Models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name ="UTILISATEUR")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private boolean enabled;
	@JsonManagedReference
	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
	private Set<ImageUI> imgs;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
	private Set<Code> codes;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password,String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public User(String email,boolean enabled, String password,String username) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled=enabled;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	
	public Set<ImageUI> getImgs() {
		return imgs;
	}
	public void setImgs(Set<ImageUI> imgs) {
		this.imgs = imgs;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

}