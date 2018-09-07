package com.netas.TaskReminder.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.netas.TaskReminder.DAO.IRoleRepository;
import com.netas.TaskReminder.DTO.Role;

public class RoleService  implements IRoleService {

  @Autowired
  private IRoleRepository roleRepository;

  public List<Role> getAllRoles() {
    return (List<Role>) roleRepository.findAll();
  }

  @Override
  public List<Role> findAll() {

    List<Role> roles = (List<Role>) roleRepository.findAll();

    return roles;
  }

  public Role getRoleById(Integer id) {
    return roleRepository.findById(id).orElse(null);
  }

  public void addRole(Role role) {
    roleRepository.save(role);
  }

  public void updateRole(Role role) {
    roleRepository.save(role);
  }

  public void deleteRole(Role role) {
    roleRepository.delete(role);
  }

  public void deleteRoleById(Integer id) {
    roleRepository.deleteById(id);
  }

  public void deleteAllRole() {
    roleRepository.deleteAll();
  }


}

