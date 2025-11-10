package com.example.projects.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "users")
public class User {   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "UserName must be Required")
    private String userName;

    @NotBlank(message = "Password must be Required")
    private String userPassword;

  
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ProjectManagement> projects;

    
    public User(Long id, String userName, String userPassword, List<ProjectManagement> projects) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.projects = projects;
    }
    
    

    public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() { 
    	return id; 
    	}
    public void setId(Long id) {
    	this.id = id; 
    	}

    public String getUserName() { 
    	return userName;
    	}
    public void setUserName(String userName) {
    	this.userName = userName; 
    	}

    public String getUserPassword() { 
    	return userPassword; 
    	}
    public void setUserPassword(String userPassword) {
    	this.userPassword = userPassword;
    	}
    public List<ProjectManagement> getProjects() { 
    	return projects; 
    	}
    public void setProjects(List<ProjectManagement> projects) {
    	this.projects = projects; 
    	}

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + "]";
    }
}
