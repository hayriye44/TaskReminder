package com.netas.TaskReminder.DAO;

import java.util.List;
import com.netas.TaskReminder.DTO.Authorization;
import com.netas.TaskReminder.DTO.Role;

public interface AuthorizationRepository {
  List<Authorization> findAll();
  Authorization findById(Long id);
  void create(Authorization authorization);
  Authorization update(Authorization authorization);
  void delete(Long id);
}
