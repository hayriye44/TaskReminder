package com.netas.TaskReminder.DTO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "summary")
  private String summary;
  @Column(name = "description")
  private String description;
  @Column(name = "is_completed")
  private boolean isCompleted;
  @Column(name = "createTime")
  private Date createTime;
  @Column(name = "duration")
  private int duration;

  public Task(int id, String summary, String description, boolean isCompleted, Date createTime,
      int duration) {
    this.id = id;
    this.summary = summary;
    this.description = description;
    this.isCompleted = isCompleted;
    this.createTime = createTime;
    this.duration = duration;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public void setCompleted(boolean completed) {
    isCompleted = completed;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }


  public void setId(Integer id) {
    this.id = id;
  }
}
