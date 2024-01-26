package repositories;

import domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskRepository implements Crud<Task, Integer> {
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
  public Task getOne(Integer id) {
    return null;
  }

  @Override
  public Task updateOne(Task element) {
    return null;
  }

  @Override
  public Task deleteOne(Integer id) {
    for(int i = 0; i < this.list.size(); i++) {
      var task = this.list.get(i);
      if(Objects.equals(task.getId(), id)) {
        list.remove(i);
        return task;
      }
    }
    return null;
  }
}
