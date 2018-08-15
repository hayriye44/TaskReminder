package com.netas.TaskReminder.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netas.TaskReminder.DAO.ITaskRepository;
import com.netas.TaskReminder.DTO.Task;

@Service
public class TaskService implements ITaskService {

  @Autowired
  private ITaskRepository taskRepository;

  public List<Task> getAllTasks() {
    return (List<Task>) taskRepository.findAll();
  }
  @Override
  public List<Task> findAll() {

      List<Task> tasks = (List<Task>) taskRepository.findAll();
      
      return tasks;
  }

  public Task getTaskById(Integer id) {
    return taskRepository.findById(id).orElse(null);
  }

  public void addTask(Task task) {
    taskRepository.save(task);
  }

  public void updateTask(Task task) {
    taskRepository.save(task);
  }

  public void deleteTask(Task task) {
    taskRepository.delete(task);
  }

  public void deleteTaskById(Integer id) {
    taskRepository.deleteById(id);
  }

  public void deleteAllTask() {
    taskRepository.deleteAll();
  }
  

}
