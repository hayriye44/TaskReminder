package com.netas.TaskReminder.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.DTO.User;
@Repository
public interface IRoleRepository extends CrudRepository<Role, Integer> {

}
