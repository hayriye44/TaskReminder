package com.netas.TaskReminder;

import java.net.URI;
import java.security.acl.Owner;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import com.netas.TaskReminder.DTO.Role;





public class RestControllerTest {
 
  static String BASE_URL="http://localhost:9090/";
  
  private RestTemplate restTemplate;

/*
  @Test
  public void testCreateRole() {
    restTemplate = new RestTemplate();
    Role role = new Role();
    role.setRoleName("admin");
    
    RestTemplate restTemplate = new RestTemplate();
    URI location = restTemplate.postForLocation(BASE_URL+ "saveRole", role);

    Role role2 = restTemplate.getForObject(location, Role.class);

    MatcherAssert.assertThat(role2.getRoleName(), Matchers.equalTo(role.getRoleName()));
    MatcherAssert.assertThat(role2.getId(), Matchers.equalTo(role.getId()));
  }
  */
}
