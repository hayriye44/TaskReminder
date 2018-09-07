package com.netas.TaskReminder.Service.jpaService;

import java.util.List;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.exception.UserNotFoundException;

public interface RoleService {
  List<Role> findRoles();
  Role findRole(Long id) throws UserNotFoundException;
  void createRole(Role role) ;
  void updateRole(Role role);
  void deleteRole(Long id);
}
