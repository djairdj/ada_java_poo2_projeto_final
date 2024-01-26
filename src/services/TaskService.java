package services;

import domain.Task;
import repositories.TaskRepository;

import java.util.List;

public class TaskService {
  private final TaskRepository repository = new TaskRepository();

  public void listTasks() {
    List<Task> list = this.repository.getAll();
    if(list.isEmpty()) System.out.println("Lista vazia");
    else System.out.println(list);
  }
}
