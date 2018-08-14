package com.netas.TaskReminder.Task;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  public List<Task> getAllTasks() {
    return (List<Task>) taskRepository.findAll();
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
