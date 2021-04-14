package com.todo.entity;

public class Todo {

	private int id;
	private String title;
	private boolean status;
	private String username;
	private String description;
	private int userId;

	public Todo() {
		super();
	}

	public Todo(int id, String title, boolean status, String username, String description, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.username = username;
		this.description = description;
		this.userId = userId;
	}

	public Todo(String title, boolean status, String username, String description, int userId) {
		super();
		this.title = title;
		this.status = status;
		this.username = username;
		this.description = description;
		this.userId = userId;
	}

	public Todo(String title, boolean status, String username, String description) {
		super();
		this.title = title;
		this.status = status;
		this.username = username;
		this.description = description;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", status=" + status + ", username=" + username
				+ ", description=" + description + ", userId=" + userId + "]";
	}

}
