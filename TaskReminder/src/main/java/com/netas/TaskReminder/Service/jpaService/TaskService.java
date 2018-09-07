package com.netas.TaskReminder.Service.jpaService;

import java.util.List;
import com.netas.TaskReminder.DTO.Task;
import com.netas.TaskReminder.DTO.User;
import com.netas.TaskReminder.exception.UserNotFoundException;

public interface TaskService {
  List<Task> findTasks();
  Task findTask(Long id) throws UserNotFoundException;
   void createTask(Task taskr) ;
  void updateTask(Task task);
  void deleteTask(Long id);
}
