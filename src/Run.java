import controllers.TaskController;
import domain.Task;
import repositories.TaskRepository;

import java.util.UUID;

public class Run {
  public static void main(String[] args) {
    Task task = new Task();
    task.setId(UUID.randomUUID());
    TaskRepository taskRepository = new TaskRepository();
    taskRepository.create(task);
    System.out.println(taskRepository.getAll());
    TaskController controller = new TaskController();
    controller.menu();
  }
}
