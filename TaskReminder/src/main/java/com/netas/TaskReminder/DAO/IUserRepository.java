package com.netas.TaskReminder.DAO;

import org.springframework.data.repository.CrudRepository;
import com.netas.TaskReminder.DTO.User;

public interface IUserRepository extends CrudRepository<User, Integer> {
  

}