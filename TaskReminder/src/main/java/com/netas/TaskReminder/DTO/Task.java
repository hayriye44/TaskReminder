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
    @Column(name = "description")
    private String description;
    @Column(name = "task_status")
    private String taskStatus;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "process_time")
    private Integer procressTime;
    
    
    @ManyToMany
    @JoinTable(name = "users_tasks", 
        joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private Set<User> people = new HashSet<User>();
    
    public Task(String description, String taskStatus, Date createDate, Integer procressTime) {
      super();
      this.description = description;
      this.taskStatus = taskStatus;
      this.createDate = createDate;
      this.procressTime = procressTime;
    }
    public String getDescription() {
      return description;
    }
    public void setDescription(String description) {
      this.description = description;
    }
    public String getTaskStatus() {
      return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
      this.taskStatus = taskStatus;
    }
    public Date getCreateDate() {
      return createDate;
    }
    public void setCreateDate(Date createDate) {
      this.createDate = createDate;
    }
    public Integer getProcressTime() {
      return procressTime;
    }
    public void setProcressTime(Integer procressTime) {
      this.procressTime = procressTime;
    }
    
}
