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
    this.list = new ArrayList<>(list);
  }

  @Override
  public Task create(Task element) {
    this.list.add(element);
    return element;
  }

  @Override
  public List<Task> getAll() {
    List<Task> result = new ArrayList<>();
    for(Task task : this.list) {
      try {
        result.add(task.clone());
      } catch(CloneNotSupportedException ignored) {
      }
    }
    return result;
  }

  @Override
  public Task getOne(Integer id) {
    for(Task task : this.list) {
      if(Objects.equals(task.getId(), id)) {
        try {
          return task.clone();
        } catch(CloneNotSupportedException ignored) {
        }
      }
    }
    return null;
  }

  @Override
  public Task updateOne(Task element) {
    int index = 0;
    for(Task task : this.list) {
      if(Objects.equals(task.getId(), element.getId())) {
        this.list.set(index, element);
        return element;
      }
      index++;
    }
    return null;
  }

  @Override
  public Task deleteOne(Integer id) {
    for(int i = 0; i < this.list.size(); i++) {
      var task = this.list.get(i);
      if(Objects.equals(task.getId(), id)) {
        this.list.remove(i);
        return task;
      }
    }
    return null;
  }
}
