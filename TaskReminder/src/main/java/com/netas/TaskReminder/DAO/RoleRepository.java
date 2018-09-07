package com.netas.TaskReminder.DAO;

import java.util.List;
import com.netas.TaskReminder.DTO.Role;

public interface RoleRepository {
  List<Role> findAll();
  Role findById(Long id);
  void create(Role role);
  Role update(Role role);
  void delete(Long id);
}
