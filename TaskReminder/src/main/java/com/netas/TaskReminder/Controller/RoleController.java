package com.netas.TaskReminder.Controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.netas.TaskReminder.DAO.IRoleRepository;
import com.netas.TaskReminder.DAO.ITaskRepository;
import com.netas.TaskReminder.DAO.IUserRepository;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.exception.InternalServerException;
import com.netas.TaskReminder.exception.UserNotFoundException;
import com.netas.TaskReminder.Service.jpaService.RoleService;
@RequestMapping("/role")
@RestController
public class RoleController {
  @Autowired
  IUserRepository userRepository;
  IRoleRepository rolerepository;
  @Autowired
  ITaskRepository taskrepository;
  @Autowired
  private RoleService roleService;
//create metodu yazıcam
//create metodu yazıcam
//updateyazacam
  @RequestMapping(method = RequestMethod.GET, value = "/roles")
  public ResponseEntity<List<Role>> getRoles() {
      List<Role> roles = roleService.findRoles();
      return ResponseEntity.ok(roles);
  }
//tasks metodu ile findall metodu aynı işi yapıyor.tasks  hazır jpa repositoriyle findall kendi yazdığım service metodu
  @RequestMapping("/findall")
  public String findAll(){
      String result = "";

      for(Role cust : rolerepository.findAll()){
          result += cust.toString() + "<br>";
      }
      
      return result;
  }
  @RequestMapping(method = RequestMethod.GET, value = "/role/{id}")
  public ResponseEntity<?> getRole(@PathVariable("id") Long id) {
      try {
          Role role = roleService.findRole(id);
          return ResponseEntity.ok(role);
      } catch (UserNotFoundException ex) {
          return ResponseEntity.notFound().build();
      }
  }
  //çalışmıyo saveRole la kaydediyom
  @RequestMapping(method = RequestMethod.POST, value = "/role")
  public ResponseEntity<URI> createRole(@RequestBody Role role) {
      try {
          roleService.createRole(role);
          Long id = role.getId();
          URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
          return ResponseEntity.created(location).build();
      } catch (Exception ex) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }
  @RequestMapping(method = RequestMethod.DELETE, value = "/role/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteRole(@PathVariable("id") Long id) {
      try {
          roleService.deleteRole(id);
      } catch (UserNotFoundException ex) {
          throw ex;
      } catch (Exception ex) {
          throw new InternalServerException(ex);
      }
  }
  //çalışmıyor
  @RequestMapping(method = RequestMethod.PUT, value = "/role/{id}")
  public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @RequestBody Role roleRequest) {
      try {
          Role role = roleService.findRole(id);
          role.setRoleName(roleRequest.getRoleName());
          role.setUsers(roleRequest.getUsers());
          role.setAuthorizations(roleRequest.getAuthorizations());
          return ResponseEntity.ok().build();
      } catch (UserNotFoundException ex) {
          return ResponseEntity.notFound().build();
      } catch (Exception ex) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }
  
  
  
}
