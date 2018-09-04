package com.netas.TaskReminder.Controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netas.TaskReminder.DAO.IRoleRepository;
import com.netas.TaskReminder.DAO.ITaskRepository;
import com.netas.TaskReminder.DAO.IUserRepository;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.DTO.Task;
import com.netas.TaskReminder.DTO.User;
import com.netas.TaskReminder.Service.RoleService;
@RestController
public class UserController {

  @Autowired
  IUserRepository userRepository;
  IRoleRepository rolerepository;
  @Autowired
  ITaskRepository taskrepository;
 /* @RequestMapping("/save")
  public String process(){
      // save a single Customer
      userrepository.save(new User("Hayriye", "Cingöz","hayriye@hotmail.com"));
      userrepository.save(new User("Burak", "Kağan","brk@hotmail.com"));
      
      return "Done";
  }*/
  @RequestMapping("/findall")
  public String findAll(){
      String result = "";
      
      for(User cust : userRepository.findAll()){
          result += cust.toString() + "<br>";
      }
      
      return result;
  }
  
  @RequestMapping( value ="/saveUser")
  public String createOwner()
  {Date simdikiZaman = new Date();
    User hayriye=new User("Hariye","asd","h@gmail.com");
    User fatma=new User("Fatma","asd","h@gmail.com");
    
    Task task=new Task("Spring çalışma","controller deneme",false,simdikiZaman,5);
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
    return "done";
    
  }

  /*
  @RequestMapping("/delete")
  public String deletee(){
    repository.deleteById(1);
      
      return "Done";
  }
  
 
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
