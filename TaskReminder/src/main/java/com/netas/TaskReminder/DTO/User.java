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
  @Column(name = "user_name")
  private String userName;
  @Column(name = "user_lastname")
  private String userLastname;
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


  public User(String userName, String userLastname, String mail) {
    super();
    this.userName = userName;
    this.userLastname = userLastname;
    this.mail = mail;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserLastname() {
    return userLastname;
  }

  public void setUserLastname(String userLastname) {
    this.userLastname = userLastname;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }


}
