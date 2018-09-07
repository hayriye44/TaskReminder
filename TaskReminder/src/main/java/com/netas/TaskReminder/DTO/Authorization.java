package com.netas.TaskReminder.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "yetki")
public class Authorization implements Serializable {
  private static final long serialVersionUID = -3009157732242241606L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "authorization_id")
  private long id;
  @Column(name = "authorization_name")
  private String authorizationName;
  
  @ManyToMany
  @JoinTable(name = "roles_authorizations",
      joinColumns = @JoinColumn(name = "authorization_id", referencedColumnName = "authorization_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
  private Set<Role> roles = new HashSet<Role>();
  

  public Authorization(String authorizationName, Set<Role> roles) {
    super();
    this.authorizationName = authorizationName;
    this.roles = roles;
  }

  public String getAuthorizationName() {
    return authorizationName;
  }

  public void setAuthorizationName(String authorizationName) {
    this.authorizationName = authorizationName;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Authorization() {
    super();
  }
  
  
  
}
