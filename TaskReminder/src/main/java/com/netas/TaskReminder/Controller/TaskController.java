package com.netas.TaskReminder.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.netas.TaskReminder.DAO.IRoleRepository;
import com.netas.TaskReminder.DAO.ITaskRepository;
import com.netas.TaskReminder.DAO.IUserRepository;
import com.netas.TaskReminder.DTO.Task;
import com.netas.TaskReminder.DTO.User;
import com.netas.TaskReminder.Service.jpaService.TaskService;
import com.netas.TaskReminder.Service.jpaService.UserService;
import com.netas.TaskReminder.exception.InternalServerException;
import com.netas.TaskReminder.exception.UserNotFoundException;
@RequestMapping("/task")
@RestController
public class TaskController {

  @Autowired
  IUserRepository userRepository;
  IRoleRepository rolerepository;
  @Autowired
  ITaskRepository taskrepository;
  @Autowired
  private TaskService taskService;
  @Autowired
  private UserService userService;
//create metodu yazıcam
//create metodu yazıcam
//create metodu yazıcam
//create metodu yazıcam
//updateyazacam
  @RequestMapping(method = RequestMethod.GET, value = "/tasks")
  public ResponseEntity<List<Task>> getTasks() {
      List<Task> tasks = taskService.findTasks();
      return ResponseEntity.ok(tasks);
  }
//tasks metodu ile findall metodu aynı işi yapıyor.tasks  hazır jpa repositoriyle findall kendi yazdığım service metodu
  @RequestMapping("/findall")
  public String findAll(){
      String result = "";

      for(Task cust : taskrepository.findAll()){
          result += cust.toString() + "<br>";
      }
      
      return result;
  }
  @RequestMapping(method = RequestMethod.GET, value = "/task/{id}")
  public ResponseEntity<?> getTask(@PathVariable("id") Long id) {
      try {
          Task task = taskService.findTask(id);
          return ResponseEntity.ok(task);
      } catch (UserNotFoundException ex) {
          return ResponseEntity.notFound().build();
      }
  }
  @RequestMapping(method = RequestMethod.DELETE, value = "/task/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteTask(@PathVariable("id") Long id) {
      try {
          taskService.deleteTask(id);
      } catch (UserNotFoundException ex) {
          throw ex;
      } catch (Exception ex) {
          throw new InternalServerException(ex);
      }
  }
  
  
}
