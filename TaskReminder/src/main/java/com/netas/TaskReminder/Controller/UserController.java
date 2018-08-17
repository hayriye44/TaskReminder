package com.netas.TaskReminder.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netas.TaskReminder.DAO.IRoleRepository;
import com.netas.TaskReminder.DAO.IUserRepository;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.DTO.User;
import com.netas.TaskReminder.Service.RoleService;
@RestController
public class UserController {

  @Autowired
  IUserRepository repository;
  IRoleRepository rolerepository;
  @RequestMapping("/save")
  public String process(){
      // save a single Customer
      repository.save(new User("Hayriye", "Cingöz","hayriye@hotmail.com"));
      repository.save(new User("Burak", "Kağan","brk@hotmail.com"));
      
      return "Done";
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
