package com.bridegelabz.fundoo.notes.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bridegelabz.fundoo.user.model.User;
@Entity
@Table(name = "notes")
public class Notes 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private boolean isPind;
	private boolean isArchive;
	private boolean isTrash;
	private LocalDateTime createdDateAndTime;
	private LocalDateTime modefiedDateTime;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public LocalDateTime getModefiedDateTime() {
		return modefiedDateTime;
	}
	public void setModefiedDateTime(LocalDateTime modefiedDateTime) {
		this.modefiedDateTime = modefiedDateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPind() {
		return isPind;
	}
	public void setPind(boolean isPind) {
		this.isPind = isPind;
	}
	public boolean isArchive() {
		return isArchive;
	}
	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}
	public boolean isTrash() {
		return isTrash;
	}
	public void setTrash(boolean isTrash) {
		this.isTrash = isTrash;
	}
	public LocalDateTime getCreatedDateAndTime() {
		return createdDateAndTime;
	}
	public void setCreatedDateAndTime(LocalDateTime createdDateAndTime) {
		this.createdDateAndTime = createdDateAndTime;
	}

	
}

