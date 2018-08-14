package com.netas.TaskReminder.Task;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {

  @Id
  private Integer id;

  private String summary;

  private String description;

  private boolean isCompleted;

  private Date date;

  public Task(int id, String summary, String description, boolean isCompleted, Date date) {
    this.id = id;
    this.summary = summary;
    this.description = description;
    this.isCompleted = isCompleted;
    this.date = date;
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
