package com.netas.TaskReminder.DAO.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.netas.TaskReminder.DAO.UserRepository;
import com.netas.TaskReminder.DTO.User;
@Repository("UserRepository")
public class UserRepositoryJpaImp implements UserRepository{
  
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public User findById(Long id) {
      return entityManager.find(User.class, id);
  }


  @Override
  public List<User> findAll() {
      return entityManager.createQuery("From User as atcl ORDER BY atcl.id").getResultList();
  }

  @Override
  public void create(User user) {
      entityManager.persist(user);
  }

  @Override
  public User update(User user) {
     return entityManager.merge(user);
  }

  @Override
  public void delete(Long id) {
      entityManager.remove(entityManager.getReference(User.class, id));
  }



}
