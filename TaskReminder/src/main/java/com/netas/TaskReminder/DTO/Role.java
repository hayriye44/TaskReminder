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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "role")
public class Role implements Serializable {
  private static final long serialVersionUID = -3009157732242241606L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "role_id")
  private long id;
  @Column(name = "role_name")
  private String roleName;

 

  @OneToMany(mappedBy = "role")
  private Set<User> users = new HashSet<User>();
  //bir rolün birden fazla kullanıcı olabilir ama her kullanıcının bir rolü vardır.ya yöneticidir yada normal kullanıcıdır
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JsonBackReference
  @JoinTable(name = "roles_authorizations",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "authorization_id", referencedColumnName = "authorization_id"))
  private Set<Authorization> authorizations = new HashSet<Authorization>();
  //Bir Adminin birden fazla yetkisi olabilir hem ekleme hem silme yapabilir aynı şekilde bi yetki yi örneğin silme işlemini hem yönetici hem kullanıcı yapabilir
  
  
  
  
  public Set<User> getUsers() {
    return users;
  }

  public Role() {
    super();
  }

  public Role(String roleName, Set<User> users, Set<Authorization> authorizations) {
    super();
    this.roleName = roleName;
    this.users = users;
    this.authorizations = authorizations;
  }
  

  public Role(String roleName) {
    super();
    this.roleName = roleName;
  }

  public Set<Authorization> getAuthorizations() {
    return authorizations;
  }

  public void setAuthorizations(Set<Authorization> authorizations) {
    this.authorizations = authorizations;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


}
