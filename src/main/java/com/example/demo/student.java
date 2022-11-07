package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Table
public class student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="student_name")
	private String name;
	private String email_id;
	private String Course;
	
	public student(String name,String emailId,String Course) {
		super();
		this.name = name;
		this.email_id  = emailId;
        this.Course = Course;
	}
	
	public student() {
		super();
	}

	public String getEmail_id() {
		return email_id;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + "]";
	}

}
