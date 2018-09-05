package com.netas.TaskReminder.Controller;

import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.netas.TaskReminder.DAO.IRoleRepository;
import com.netas.TaskReminder.DAO.ITaskRepository;
import com.netas.TaskReminder.DAO.IUserRepository;
import com.netas.TaskReminder.DTO.Authorization;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.DTO.Task;
import com.netas.TaskReminder.DTO.User;
import com.netas.TaskReminder.Service.RoleService;
import com.netas.TaskReminder.Service.jpaService.UserService;
import com.netas.TaskReminder.exception.InternalServerException;
import com.netas.TaskReminder.exception.UserNotFoundException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
public class UserController {

  @Autowired
  IUserRepository userRepository;
  IRoleRepository rolerepository;
  @Autowired
  ITaskRepository taskrepository;

  @Autowired
  private UserService userService;
  
  @RequestMapping(method = RequestMethod.GET, value = "/users")
  public ResponseEntity<List<User>> getUsers() {
      List<User> users = userService.findUsers();
      return ResponseEntity.ok(users);
  }
  //users metodu ile findall metodu aynı işi yapıyor.findall hazır jpa repositoriyle users kendi yazdığım service metodu
  @RequestMapping("/findall")
  public String findAll(){
      String result = "";
      System.out.println("başarılı");

      for(User cust : userRepository.findAll()){
          result += cust.toString() + "<br>";
      }
      
      return result;
  }
  @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
  public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
      try {
          User user = userService.findUser(id);
          return ResponseEntity.ok(user);
      } catch (UserNotFoundException ex) {
          return ResponseEntity.notFound().build();
      }
  }
  //çalışmıyo saveUser la kaydediyom
  @RequestMapping(method = RequestMethod.POST, value = "/user")
  public ResponseEntity<URI> createUser(@RequestBody User user) {
      try {
          userService.createUser(user);
          Long id = user.getId();
          URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
          return ResponseEntity.created(location).build();
      } catch (Exception ex) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }
  @RequestMapping( value ="/savesave")
  public String UserKaydet(@RequestBody User user)
  {
      userRepository.save(user);
      return "Kayıt başarılı";
  }
  
  @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteUser(@PathVariable("id") Long id) {
      try {
          userService.deleteUser(id);
      } catch (UserNotFoundException ex) {
          throw ex;
      } catch (Exception ex) {
          throw new InternalServerException(ex);
      }
  }
  
  @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
  public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User userRequest) {
      try {
          User user = userService.findUser(id);
          user.setUserFullName(userRequest.getUserFullName());
          user.setMail(userRequest.getMail());
          user.setRole(userRequest.getRole());
          user.setTasks(userRequest.getTasks());
          user.setSifre(userRequest.getSifre());
          return ResponseEntity.ok().build();
      } catch (UserNotFoundException ex) {
          return ResponseEntity.notFound().build();
      } catch (Exception ex) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }
  @PutMapping("article")
  public ResponseEntity<User> updateArticle(@RequestBody User article) {
      userService.updateUser(article);
      return new ResponseEntity<User>(article, HttpStatus.OK);
  }
  @RequestMapping( value ="/saveUser")
 
  public String createUser()
  { Date simdikiZaman = new Date();
    User hayriye=new User("Hatice","asd","h@gmail.com");
    User fatma=new User("Hasan","asd","h@gmail.com");
    
    Task task=new Task("İşsiz","controller deneme",false,simdikiZaman,5);
    Task task2=new Task("Angular çalışma","sayfalar arası geçiş",false,simdikiZaman,1);
   
    Set<Task> tasks = new HashSet<Task>();
    tasks.add(task);
    tasks.add(task2);
    
    hayriye.setTasks(tasks);
    fatma.setTasks(tasks);

    userRepository.save(hayriye);
    userRepository.save(fatma);
    
    Set<User> users=new HashSet<User>();
    users.add(hayriye);
    users.add(fatma);

    task.setUsers(users);
    task2.setUsers(users);
    taskrepository.save(task);
    taskrepository.save(task2);
    
    
    Role role=new Role();
    role.setRoleName("Admin");
    role.setUsers(users);
    
    Set<Role> roles = new HashSet<Role>();
    roles.add(role);
    hayriye.setRole(role);
    fatma.setRole(role);
    
    
    Authorization yetki1=new Authorization();
    yetki1.setAuthorizationName("Kullanıcı ekleme");
    yetki1.setRoles(roles);
    Set<Authorization> authorizations=new HashSet<Authorization>();
    authorizations.add(yetki1);
    role.setAuthorizations(authorizations);
    
    
    
    
   

    return "done";
    
  }/*
  
 
  @PostMapping(value="/postuser")
  public String postUser() {

      repository.save(new User("Hayriye"," Cingöz","h@madk.com"));
      return "Done";
  }
 //simdi service kullanıp role sınıfından bi nesne oluşturup servisteki ekleme metoduna göndericem servisteki metot crud repostroy kullanıp kaydedecek
  
  @RequestMapping("/saverole")
  public String saveRole(){
      // save a single Customer
      rolerepository.save(new Role("Yönetici"));
      rolerepository.save(new Role("Kullanıcı"));
      
      return "Done";
  }
  */
  @RequestMapping("/api/hi")
  public String hi() {
      return "Hello World from Restful API";
  }

}
