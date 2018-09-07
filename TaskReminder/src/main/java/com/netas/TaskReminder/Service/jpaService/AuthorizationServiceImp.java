package com.netas.TaskReminder.Service.jpaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.netas.TaskReminder.DAO.AuthorizationRepository;
import com.netas.TaskReminder.DAO.RoleRepository;
import com.netas.TaskReminder.DAO.TaskRepository;
import com.netas.TaskReminder.DAO.UserRepository;
import com.netas.TaskReminder.DTO.Authorization;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.exception.UserNotFoundException;

@Service
@Transactional(rollbackFor=Exception.class)
public class AuthorizationServiceImp implements AuthorizationService {
private UserRepository userRepository;
  
  private TaskRepository taskRepository;

  private AuthorizationRepository authorizationRepository;
  private RoleRepository roleRepository;
  
  
  @Autowired
  public void setAuthorizationRepository(AuthorizationRepository authorizationRepository) {
      this.authorizationRepository = authorizationRepository;
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
  public List<Authorization> findAuthorizations() {
      return authorizationRepository.findAll();
  }
  @Override
  @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
  public Authorization findAuthorization(Long id) throws UserNotFoundException {
      Authorization authorization= authorizationRepository.findById(id);
      if(authorization == null) {
          throw new UserNotFoundException("Authorization not found with id :" + id);
      }
      return authorization;
  }

  @Override
  public void createAuthorization(Authorization authorization) {
      authorizationRepository.create(authorization);
  }

  @Override
  public void updateAuthorization(Authorization authorization) {
      authorizationRepository.update(authorization);
  }

  @Override
  public void deleteAuthorization(Long id) {
    //  taskRepository.deleteByTaskId(id);
      authorizationRepository.delete(id);
      //if(true) throw new RuntimeException("testing rollback...");
  }


}
