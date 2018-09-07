package com.netas.TaskReminder.DAO.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.netas.TaskReminder.DAO.AuthorizationRepository;
import com.netas.TaskReminder.DTO.Authorization;

@Repository("AuthorizationRepository")
public class AuthorizationRepositoryJpaImp implements AuthorizationRepository{
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Authorization findById(Long id) {
      return entityManager.find(Authorization.class, id);
  }
  @Override
  public List<Authorization> findAll() {
      return entityManager.createQuery("From Authorization as atcl ORDER BY atcl.id", Authorization.class).getResultList();
  }

  @Override
  public void create(Authorization authorization) {
      entityManager.persist(authorization);
  }

  @Override
  public Authorization update(Authorization authorization) {
      return entityManager.merge(authorization);
  }
  
  @Override
  public void delete(Long id) {
      entityManager.remove(entityManager.getReference(Authorization.class, id));
  }

}
