package com.netas.TaskReminder.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.netas.TaskReminder.DTO.User;
@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
  

}