package com.netas.TaskReminder.Service;

import java.util.List;
import com.netas.TaskReminder.DTO.Task;

public interface ITaskService {
  public List<Task> findAll();

}
