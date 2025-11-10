package com.example.projects.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "projects")
public class ProjectManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project Name Must be Required")
    private String projectName;

    private String projectDesc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

   
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getProjectDesc() {
			return projectDesc;
		}

		public void setProjectDesc(String projectDesc) {
			this.projectDesc = projectDesc;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<Task> getTasks() {
			return tasks;
		}

		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}

		public ProjectManagement(Long id, @NotBlank(message = "Project Name Must be Required") String projectName,
				String projectDesc, LocalDateTime createdAt, LocalDateTime updatedAt, User user, List<Task> tasks) {
			super();
			this.id = id;
			this.projectName = projectName;
			this.projectDesc = projectDesc;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.user = user;
			this.tasks = tasks;
		}

		public ProjectManagement() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "ProjectManagement [id=" + id + ", projectName=" + projectName + ", projectDesc=" + projectDesc
					+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", user=" + user + ", tasks=" + tasks
					+ "]";
		}
	    
	    

		
	    

}
