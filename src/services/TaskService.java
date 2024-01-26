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

  public void createTask(Task task) {
    if(task != null) {
      Task created = repository.create(task);
      if(created != null) System.out.println("Tarefa criada com sucesso!");
      else System.out.println("Erro ao criar a tarefa.");
    } else System.out.println("Objeto recebido nulo.");
  }

}
