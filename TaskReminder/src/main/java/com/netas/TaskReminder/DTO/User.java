package com.netas.TaskReminder.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "\"user\"")
public class User implements Serializable {
  private static final long serialVersionUID = -3009157732242241606L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private long id;
  @Column(name = "username")
  private String username;
  @Column(name = "user_full_name")
  private String userFullName;
  @Column(name = "mail")
  private String mail;



  @ManyToMany(cascade = CascadeType.ALL)
  @JsonBackReference
  @JoinTable(name = "users_tasks",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"))
  private Set<Task> tasks = new HashSet<Task>();
  // tasks lar set metoduyla direk gelicek constructer metoda yazmaya gerek yok.
  // ManyToMany ilişki olacak.Bunun için UserWorkingTaskla Manytoone yaparım
  // UserWorkingTaskla task sınıfı arasında onetomany sonuc manytomany olur



  
  
  @ManyToOne
  @JoinColumn (name="role_id")
  @JsonBackReference
  private Role role;
  // Her kullanıcının bir rolü var.
  public User(String username, String userFullName, String mail, Set<Task> tasks, Role role) {
    super();
    this.username = username;
    this.userFullName = userFullName;
    this.mail = mail;
    this.tasks = tasks;
    this.role = role;
  }
  
  
  public User(String username, String userFullName, String mail, Role role) {
    super();
    this.username = username;
    this.userFullName = userFullName;
    this.mail = mail;
    this.role = role;
  }


  public User(String username, String userFullName, String mail) {
    super();
    this.username = username;
    this.userFullName = userFullName;
    this.mail = mail;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getUserFullName() {
    return userFullName;
  }
  public void setUserFullName(String userFullName) {
    this.userFullName = userFullName;
  }
  public String getMail() {
    return mail;
  }
  public void setMail(String mail) {
    this.mail = mail;
  }
  public Set<Task> getTasks() {
    return tasks;
  }
  public void setTasks(Set<Task> tasks) {
    this.tasks = tasks;
  }
  public Role getRole() {
    return role;
  }
  public void setRole(Role role) {
    this.role = role;
  }
  @Override
  public String toString() {
    return "User [username=" + username + ", userFullName=" + userFullName + ", mail=" + mail + "]";
  }




}
