package com.netas.TaskReminder.DAO.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.netas.TaskReminder.DAO.TaskRepository;
import com.netas.TaskReminder.DTO.Task;


@Repository("TaskRepository")
public class TaskRepositoryJpaImp implements TaskRepository {
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Task findById(Long id) {
      return entityManager.find(Task.class, id);
  }


  @Override
  public List<Task> findAll() {
      return entityManager.createQuery("From Task as atcl ORDER BY atcl.id", Task.class).getResultList();
  }

  @Override
  public void create(Task task) {
      entityManager.persist(task);
  }

  @Override
  public Task update(Task task) {
      return entityManager.merge(task);
  }

  @Override
  public void delete(Long id) {
      entityManager.remove(entityManager.getReference(Task.class, id));
  }


}
