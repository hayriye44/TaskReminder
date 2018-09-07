package com.netas.TaskReminder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.netas.TaskReminder.DAO.IRoleRepository;
import com.netas.TaskReminder.DAO.ITaskRepository;
import com.netas.TaskReminder.DAO.IUserRepository;
import com.netas.TaskReminder.DTO.Task;
import com.netas.TaskReminder.DTO.User;

@SpringBootApplication
public class TaskReminderApplication{
  public static void main(String[] args) {
    SpringApplication.run(TaskReminderApplication.class, args);
  }
  
}
