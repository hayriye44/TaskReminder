package com.netas.TaskReminder.Task;

import java.util.Optional;

public class TaskRepository implements TaskRepositoryIn {

  @Override
  public <S extends Task> S save(S s) {
    return null;
  }

  @Override
  public <S extends Task> Iterable<S> saveAll(Iterable<S> it) {
    return null;
  }

  @Override
  public Optional<Task> findById(Integer id) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Integer id) {
    return false;
  }

  @Override
  public Iterable<Task> findAll() {
    return null;
  }

  @Override
  public Iterable<Task> findAllById(Iterable<Integer> it) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Integer id) {

  }

  @Override
  public void delete(Task task) {

  }

  @Override
  public void deleteAll(Iterable<? extends Task> it) {

  }

  @Override
  public void deleteAll() {

  }
}
