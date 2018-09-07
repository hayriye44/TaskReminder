package com.netas.TaskReminder.Service.jpaService;

import java.util.List;
import com.netas.TaskReminder.DTO.Authorization;
import com.netas.TaskReminder.DTO.Role;
import com.netas.TaskReminder.exception.UserNotFoundException;

public interface AuthorizationService {
  List<Authorization> findAuthorizations();
  Authorization findAuthorization(Long id) throws UserNotFoundException;
  void createAuthorization(Authorization authorization) ;
  void updateAuthorization(Authorization authorization);
  void deleteAuthorization(Long id);
}
