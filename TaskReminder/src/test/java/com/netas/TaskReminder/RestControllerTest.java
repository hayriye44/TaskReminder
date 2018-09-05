package com.netas.TaskReminder;

import java.net.URI;
import java.security.acl.Owner;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.DTO.Task;
import com.netas.TaskReminder.DTO.User;

public class RestControllerTest {
 
  static String BASE_URL="http://localhost:9090/";
  
  private RestTemplate restTemplate;
  //çalışıyor
  @Test
  public void testGetUsers() {

    restTemplate = new RestTemplate();
      ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:9090/users", List.class);
      List<Map<String,String>> body = response.getBody();

      MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
      
      List<String> firstNames = body.stream().map(e->e.get("userFullName")).collect(Collectors.toList());
      
      MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Hasan","Hatice", "Hasan"));
  }

  @Test
  public void testUpdateUser() {
       restTemplate = new RestTemplate();

       Date simdikiZaman = new Date();
      User user = restTemplate.getForObject("http://localhost:9090/user/8", User.class);

      MatcherAssert.assertThat(user.getUserFullName(), Matchers.equalTo("Hasan"));

      user.setUserFullName("Hayriye Cingöz");
      user.setMail("h@jgkh");
      Role r=new Role();
      r.setRoleName("admin");
      user.setRole(r);
      Task task=new Task("spring","çalış",false,simdikiZaman,30);
      Task task2=new Task("android","çalış",false,simdikiZaman,20);
      Set<Task> tasks = new HashSet<Task>();
      tasks.add(task);
      tasks.add(task2);
      user.setTasks(tasks);
      user.setSifre("1234");
      restTemplate.put("http://localhost:9090/user/1",user);
      user = restTemplate.getForObject("http://localhost:9090/user/1", User.class);

      MatcherAssert.assertThat(user.getUserFullName(), Matchers.equalTo("Hayriye Cingöz"));
  }
  //çalışıyor
  @Test
  public void testDeleteUser() {

    restTemplate = new RestTemplate();
      restTemplate.delete("http://localhost:9090/user/1");

      try {
          restTemplate.getForEntity("http://localhost:9090/user/8", User.class);
          Assert.fail("Should have not returned user");
      } catch (HttpClientErrorException ex) {
          MatcherAssert.assertThat(ex.getStatusCode().value(), Matchers.equalTo(404));
      }
  }
  //metot çalışıyo test çalışmıyo
  @Test
  public void testGetUserById() {

    restTemplate = new RestTemplate();
      ResponseEntity<User> response = restTemplate.getForEntity("http://localhost:9090/user/5", User.class);
      MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
      MatcherAssert.assertThat(response.getBody().getUserFullName(), Matchers.equalTo("Hatice"));
  }
  //çalışmıyo
  @Test
  public void testCreateUser() {

     restTemplate = new RestTemplate();
      Date simdikiZaman = new Date();
     User user = new User();
      user.setUserFullName("Hayriye");
      user.setSifre("Cingöz");
      user.setMail("h@gmail.com");
      Task task=new Task("İşsiz","controller deneme",false,simdikiZaman,5);
      Task task2=new Task("Angular çalışma","sayfalar arası geçiş",false,simdikiZaman,1);
      Set<Task> tasks = new HashSet<Task>();
      tasks.add(task);
      tasks.add(task2);
      user.setTasks(tasks);

      RestTemplate restTemplate = new RestTemplate();
      URI location = restTemplate.postForLocation("http://localhost:9090/savesave", user);

      User user2 = restTemplate.getForObject(location, User.class);

      MatcherAssert.assertThat(user2.getUserFullName(), Matchers.equalTo(user.getUserFullName()));
  }

}
