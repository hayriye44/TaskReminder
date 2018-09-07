package com.netas.TaskReminder.DAO.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.netas.TaskReminder.DAO.RoleRepository;
import com.netas.TaskReminder.DTO.Role;

@Repository("RoleRepository")
public class RoleRepositoryJpaImp  implements RoleRepository {
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Role findById(Long id) {
      return entityManager.find(Role.class, id);
  }
  @Override
  public List<Role> findAll() {
      return entityManager.createQuery("From Role as atcl ORDER BY atcl.id", Role.class).getResultList();
  }

  @Override
  public void create(Role role) {
      entityManager.persist(role);
  }

  @Override
  public Role update(Role role) {
      return entityManager.merge(role);
  }
  
  @Override
  public void delete(Long id) {
      entityManager.remove(entityManager.getReference(Role.class, id));
  }

}
