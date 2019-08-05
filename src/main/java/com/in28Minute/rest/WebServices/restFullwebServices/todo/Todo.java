package com.in28Minute.rest.WebServices.restFullwebServices.todo;

import java.util.Date;

public class Todo {
	private Long id;
	private String username;
	private String discription;
	private Date targateDate;
	private boolean isDone;
	
	protected Todo(){
		
	}

	public Todo(Long id, String username, String discription, Date targateDate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.discription = discription;
		this.targateDate = targateDate;
		this.isDone = isDone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Date getTargateDate() {
		return targateDate;
	}

	public void setTargateDate(Date targateDate) {
		this.targateDate = targateDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
