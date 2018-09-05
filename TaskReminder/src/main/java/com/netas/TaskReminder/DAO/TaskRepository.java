package com.netas.TaskReminder.DAO;
import java.util.List;
import com.netas.TaskReminder.DTO.Task;
public interface TaskRepository {
  List<Task> findAll();
  Task findById(Long id);
 
  void create(Task task);
  Task update(Task task);
  void delete(Long id);
}
