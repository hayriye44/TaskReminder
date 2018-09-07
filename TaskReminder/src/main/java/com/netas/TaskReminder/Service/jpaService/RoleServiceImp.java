package com.netas.TaskReminder.Service.jpaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.netas.TaskReminder.DAO.RoleRepository;
import com.netas.TaskReminder.DAO.TaskRepository;
import com.netas.TaskReminder.DAO.UserRepository;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.DTO.User;
import com.netas.TaskReminder.Service.jpaService.RoleService;
import com.netas.TaskReminder.exception.UserNotFoundException;
@Service
@Transactional(rollbackFor=Exception.class)
public class RoleServiceImp implements RoleService {
private UserRepository userRepository;
  
  private TaskRepository taskRepository;
  private RoleRepository roleRepository;
  
  
  @Autowired
  public void setUserRepository(UserRepository userRepository) {
      this.userRepository = userRepository;
  }
  @Autowired
  public void setTaskRepository(TaskRepository taskRepository) {
      this.taskRepository = taskRepository;
  }
  @Autowired
  public void setRoleRepository(RoleRepository roleRepository) {
      this.roleRepository = roleRepository;
  }

  @Override
  @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
  public List<Role> findRoles() {
      return roleRepository.findAll();
  }
  @Override
  @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
  public Role findRole(Long id) throws UserNotFoundException {
      Role role= roleRepository.findById(id);
      if(role == null) {
          throw new UserNotFoundException("Role not found with id :" + id);
      }
      return role;
  }

  @Override
  public void createRole(Role role) {
      roleRepository.create(role);
  }

  @Override
  public void updateRole(Role role) {
      roleRepository.update(role);
  }

  @Override
  public void deleteRole(Long id) {
    //  taskRepository.deleteByTaskId(id);
      roleRepository.delete(id);
      //if(true) throw new RuntimeException("testing rollback...");
  }

}
