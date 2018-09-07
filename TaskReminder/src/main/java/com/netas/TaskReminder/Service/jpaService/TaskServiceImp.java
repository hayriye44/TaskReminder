package com.netas.TaskReminder.Service.jpaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.netas.TaskReminder.DAO.TaskRepository;
import com.netas.TaskReminder.DAO.UserRepository;
import com.netas.TaskReminder.DTO.Task;
import com.netas.TaskReminder.DTO.User;
import com.netas.TaskReminder.exception.UserNotFoundException;

@Service
@Transactional(rollbackFor=Exception.class)
public class TaskServiceImp implements TaskService {
 private UserRepository userRepository;
  
  private TaskRepository taskRepository;
  
  @Autowired
  public void setUserRepository(UserRepository userRepository) {
      this.userRepository = userRepository;
  }
  
  @Autowired
  public void setTaskRepository(TaskRepository taskRepository) {
      this.taskRepository = taskRepository;
  }

  @Override
  @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
  public List<Task> findTasks() {
      return taskRepository.findAll();
  }


  @Override
  @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
  public Task findTask(Long id) throws UserNotFoundException {
      Task task= taskRepository.findById(id);
      if(task == null) {
          throw new UserNotFoundException("Task not found with id :" + id);
      }
      return task;
  }

  @Override
  public void createTask(Task task) {
      taskRepository.create(task);
  }

  @Override
  public void updateTask(Task task) {
      taskRepository.update(task);
  }

  @Override
  public void deleteTask(Long id) {
    //  taskRepository.deleteByTaskId(id);
      taskRepository.delete(id);
      //if(true) throw new RuntimeException("testing rollback...");
  }


}
