package com.netas.TaskReminder.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.netas.TaskReminder.DAO.IUserRepository;
import com.netas.TaskReminder.DTO.User;

public class UserService implements IUserService {
  @Autowired
  private IUserRepository userRepository;
  public List<User> getAllUsers() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public List<User> findAll() {

    List<User> users = (List<User>) userRepository.findAll();

    return users;
  }

  public User getUserById(Integer id) {
    return userRepository.findById(id).orElse(null);
  }

  public void addUser(User user) {
    userRepository.save(user);
  }

  public void updateUSer(User user) {
    userRepository.save(user);
  }

  public void deleteUser(User user) {
    userRepository.delete(user);
  }

  public void deleteUserById(Integer id) {
    userRepository.deleteById(id);
  }

  public void deleteAllUser() {
    userRepository.deleteAll();
  }


}
