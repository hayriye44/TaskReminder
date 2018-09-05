package com.netas.TaskReminder.Service.jpaService;

import java.util.List;
import com.netas.TaskReminder.DTO.User;
import com.netas.TaskReminder.exception.UserNotFoundException;
public interface UserService {
  List<User> findUsers();
  User findUser(Long id) throws UserNotFoundException;
   void createUser(User user) ;
  void updateUser(User user);
  void deleteUser(Long id);
}
