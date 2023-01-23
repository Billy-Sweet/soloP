package com.billy.solo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="games")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-DD")
	private Date updatedAt;
	
	@NotEmpty(message = "Need a name")
	@Size(min=2, max=255, message= "Submit a Valid Name")
	private String name;
	
	@NotEmpty(message = "Need the genre")
	@Size(min=2, max=255, message= "Submit a Valid Genre")
	private String genre;
	
	@NotEmpty(message= "Game needs a description")
	@Size(min=2, message="Submit a Valid Description")
	private String description;
	
	@NotNull(message = "What do you rate this?")
	@Min(value=1, message="rating must be at least 1")
	@Max (value=5, message="Rating must be at most 5")
	private Integer rating;
	
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	@PrePersist
	protected void onCreate() {
			this.createdAt = new Date();
			this.updatedAt = new Date ();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User gameCreator;
	
	public Game () {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getGameCreator() {
		return gameCreator;
	}
	public void setGameCreator(User gameCreator) {
		this.gameCreator = gameCreator;
	}
}
