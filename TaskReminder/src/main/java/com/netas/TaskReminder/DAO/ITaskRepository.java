package com.netas.TaskReminder.DAO;

import org.springframework.data.repository.CrudRepository;
import com.netas.TaskReminder.DTO.Task;


public interface ITaskRepository extends CrudRepository<Task, Integer> {
  

}
