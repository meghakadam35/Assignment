package com.example.projects.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Task title Must be Required")
	    private String taskTitle;

	    private String taskDesc;

	    
	    @Enumerated(EnumType.STRING)
	    @NotNull(message = "Status Must be Required")
	    private TaskStatus status;

	    @Enumerated(EnumType.STRING)
	    @NotNull(message = "Priority Must be Required")
	    private TaskPriority priority;

	    @NotNull(message = "Due Date Must be Required")
	    private LocalDate taskdueDate;

	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;

	    @ManyToOne
	    @JoinColumn(name = "project_id")
	    private ProjectManagement project;

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

		public String getTaskTitle() {
			return taskTitle;
		}

		public void setTaskTitle(String taskTitle) {
			this.taskTitle = taskTitle;
		}

		public String getTaskDesc() {
			return taskDesc;
		}

		public void setTaskDesc(String taskDesc) {
			this.taskDesc = taskDesc;
		}

		public TaskStatus getStatus() {
			return status;
		}

		public void setStatus(TaskStatus status) {
			this.status = status;
		}

		public TaskPriority getPriority() {
			return priority;
		}

		public void setPriority(TaskPriority priority) {
			this.priority = priority;
		}

		public LocalDate getTaskdueDate() {
			return taskdueDate;
		}

		public void setTaskdueDate(LocalDate taskdueDate) {
			this.taskdueDate = taskdueDate;
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

		public ProjectManagement getProject() {
			return project;
		}

		public void setProject(ProjectManagement project) {
			this.project = project;
		}

		public Task(Long id, String taskTitle, String taskDesc, TaskStatus status, TaskPriority priority,
				LocalDate taskdueDate, LocalDateTime createdAt, LocalDateTime updatedAt, ProjectManagement project) {
			super();
			this.id = id;
			this.taskTitle = taskTitle;
			this.taskDesc = taskDesc;
			this.status = status;
			this.priority = priority;
			this.taskdueDate = taskdueDate;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.project = project;
		}

		public Task() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "task [id=" + id + ", taskTitle=" + taskTitle + ", taskDesc=" + taskDesc + ", project="
					+ project + "]";
		}
     
	    
		
}
