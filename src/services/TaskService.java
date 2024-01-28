package services;

import domain.Task;
import repositories.TaskRepository;

import java.util.List;

public class TaskService {
  private final TaskRepository repository;

  public TaskService() {
    this.repository = new TaskRepository();
  }

  public TaskService(List<Task> list) {
    this.repository = new TaskRepository(list);
  }

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

  public Task deleteTask(String id) {
    try {
      Integer identifier = Integer.parseInt(id);
      return repository.deleteOne(identifier);
    } catch(NumberFormatException ignored) {
      System.out.println("Não foi possível remover uma tarefa com esse id");
    }
    return null;
  }

}
