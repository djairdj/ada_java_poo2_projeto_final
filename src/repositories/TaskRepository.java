package repositories;

import domain.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements Crud<Task, Long> {
  private final List<Task> list;

  public TaskRepository() {
    this(new ArrayList<>());
  }

  public TaskRepository(List<Task> list) {
    if(list == null) list = new ArrayList<>();
    this.list = list;
  }

  public List<Task> getList() {
    return this.list;
  }

  @Override
  public Task create(Task element) {
    this.list.add(element);
    return element;
  }

  @Override
  public List<Task> getAll() {
    return this.list.subList(0, this.list.size());
  }

  @Override
  public Task listOne(Long id) {
    return null;
  }

  @Override
  public Task updateOne(Task element) {
    return null;
  }

  @Override
  public Task deleteOne(Long id) {
    return null;
  }
}
