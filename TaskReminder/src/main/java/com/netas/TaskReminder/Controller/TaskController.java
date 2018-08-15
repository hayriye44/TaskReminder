package com.netas.TaskReminder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.netas.TaskReminder.DAO.ITaskRepository;

public class TaskController {
  @Autowired
  ITaskRepository repository;
  @RequestMapping("/findbylastname")
  public String fetchDataByLastName(@RequestParam("lastname") String lastName){
      String result = "";
      
      return result;
}
}
