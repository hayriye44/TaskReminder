package com.netas.TaskReminder.DAO;

import org.springframework.data.repository.CrudRepository;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.DTO.User;

public interface IRoleRepository extends CrudRepository<Role, Integer> {

}
