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
@Table(name = "kullanici")
public class User implements Serializable {
  private static final long serialVersionUID = -3009157732242241606L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(name = "username")
  private String userFullName;
  @Column(name = "password")
  private String sifre;
  @Column(name = "mail")
  private String mail;

  @ManyToMany(cascade = CascadeType.ALL)
  @JsonBackReference
  @JoinTable(name = "users_tasks",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"))
  private Set<Task> tasks= new HashSet<Task>();
  // tasks lar set metoduyla direk gelicek constructer metoda yazmaya gerek yok.
  // ManyToMany ilişki olacak.Bunun için UserWorkingTaskla Manytoone yaparım
  // UserWorkingTaskla task sınıfı arasında onetomany sonuc manytomany olur
  @ManyToOne
  @JoinColumn (name="role_id")
  @JsonBackReference
  private Role role;
  // Her kullanıcının bir rolü var.
  public User(long id, String userFullName, String sifre, String mail, Set<Task> tasks) {
    super();
    this.id = id;
    this.userFullName = userFullName;
    this.sifre = sifre;
    this.mail = mail;
    this.tasks = tasks;
  }
  
  public User(long id, String userFullName, String sifre, String mail) {
    super();
    this.id = id;
    this.userFullName = userFullName;
    this.sifre = sifre;
    this.mail = mail;
  }

  public User(String userFullName, String sifre, String mail) {
    super();
    this.userFullName = userFullName;
    this.sifre = sifre;
    this.mail = mail;
  }
  

  public User(String userFullName, String sifre, String mail, Set<Task> tasks, Role role) {
    super();
    this.userFullName = userFullName;
    this.sifre = sifre;
    this.mail = mail;
    this.tasks = tasks;
    this.role = role;
  }

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getUserFullName() {
    return userFullName;
  }
  public void setUserFullName(String userFullName) {
    this.userFullName = userFullName;
  }
  public String getSifre() {
    return sifre;
  }
  public void setSifre(String sifre) {
    this.sifre = sifre;
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
    return "User [id=" + id + ", userFullName=" + userFullName + ", sifre=" + sifre + ", mail="
        + mail + ", tasks=" + tasks + ", role=" + role + "]";
  }
  public User() {
    super();
  }
 



}
