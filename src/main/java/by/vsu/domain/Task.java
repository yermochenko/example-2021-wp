package by.vsu.domain;

import java.util.Date;

public class Task {
	private Integer id;
	private String title;
	private String description;
	private boolean active;
	private Date date;
	private Double importance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getImportance() {
		return importance;
	}

	public void setImportance(Double importance) {
		this.importance = importance;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=\"" + title + "\", description=\"" + description + "\", active=" + active + ", date=" + date + ", importance=" + importance + "]";
	}
}
