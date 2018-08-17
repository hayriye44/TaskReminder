package com.netas.TaskReminder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.netas.TaskReminder.DAO.ITaskRepository;
import com.netas.TaskReminder.DAO.IUserRepository;

public class TaskController {

  @Autowired
  IUserRepository repository;
  @RequestMapping("/index")
  public String getHomePage() {
      return "index";
  }

  @RequestMapping("/findbylastname")
  public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
    String result = "aa";

    return result;
  }
}
