package com.netas.TaskReminder.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task implements Serializable {
  private static final long serialVersionUID = -3009157732242241606L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "task_id")
  private long id;
  @Column(name = "title")
  private String title;
  @Column(name = "description")
  private String description;
  @Column(name = "task_status")
  private boolean taskStatus;
  @Column(name = "create_date")
  private Date createDate;
  @Column(name = "task_duration")
  private Integer taskDuration;


  @ManyToMany
  @JoinTable(name = "users_tasks",
      joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
  private Set<User> users = new HashSet<User>();

  
  public Task(String title, String description, boolean taskStatus, Date createDate,
      Integer taskDuration, Set<User> users) {
    super();
    this.title = title;
    this.description = description;
    this.taskStatus = taskStatus;
    this.createDate = createDate;
    this.taskDuration = taskDuration;
    this.users = users;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
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


  public boolean isTaskStatus() {
    return taskStatus;
  }


  public void setTaskStatus(boolean taskStatus) {
    this.taskStatus = taskStatus;
  }


  public Date getCreateDate() {
    return createDate;
  }


  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }


  public Integer getTaskDuration() {
    return taskDuration;
  }


  public void setTaskDuration(Integer taskDuration) {
    this.taskDuration = taskDuration;
  }




  
}
