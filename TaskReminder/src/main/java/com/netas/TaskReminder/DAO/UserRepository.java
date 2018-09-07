package com.netas.TaskReminder.DAO;
import java.util.List;
import com.netas.TaskReminder.DTO.User;
public interface UserRepository {
  List<User> findAll();
  User findById(Long id);
  void create(User user);
  User update(User user);
  void delete(Long id);
}
