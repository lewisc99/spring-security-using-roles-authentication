package com.springsecurityroles.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Table(name="user")
@Entity
public class Users {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private boolean active;
	
	
	@JoinTable(
	        name = "user_role",
	        joinColumns = @JoinColumn(
	                name = "user_id"
	               
	        ),
	        inverseJoinColumns = @JoinColumn(
	                name = "role_id"
	                
	        )
	)
	@ManyToMany(fetch=FetchType.EAGER,
    cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})

	private List<Role> roles;
	
	
	public Users()
	{}


	public Users(int id, String username, String password, boolean active) {
	
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
