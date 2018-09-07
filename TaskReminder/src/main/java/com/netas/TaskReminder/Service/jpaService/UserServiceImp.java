package com.netas.TaskReminder.Service.jpaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.netas.TaskReminder.DAO.TaskRepository;
import com.netas.TaskReminder.DAO.UserRepository;
import com.netas.TaskReminder.DTO.User;
import com.netas.TaskReminder.exception.UserNotFoundException;
@Service
@Transactional(rollbackFor=Exception.class)
public class UserServiceImp  implements UserService {
  
  private UserRepository userRepository;
  
  private TaskRepository taskRepository;
  
  @Autowired
  public void setOwnerRepository(UserRepository userRepository) {
      this.userRepository = userRepository;
  }
  
  @Autowired
  public void setPetRepository(TaskRepository taskRepository) {
      this.taskRepository = taskRepository;
  }

  @Override
  @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
  public List<User> findUsers() {
      return userRepository.findAll();
  }


  @Override
  @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
  public User findUser(Long id) throws UserNotFoundException {
      User user= userRepository.findById(id);
      if(user == null) {
          throw new UserNotFoundException("User not found with id :" + id);
      }
      return user;
  }

  @Override
  public void createUser(User user) {
      userRepository.create(user);
  }

  @Override
  public void updateUser(User user) {
      userRepository.update(user);
  }

  @Override
  public void deleteUser(Long id) {
    //  taskRepository.deleteByTaskId(id);
      userRepository.delete(id);
      //if(true) throw new RuntimeException("testing rollback...");
  }

}
