import controllers.TaskController;
import domain.StudyTask;
import domain.Task;

import java.util.List;

public class Run {
  public static void main(String[] args) {
    List<Task> listagem = List.of(
        new StudyTask("Tratamento de errors na API", "done", "Tratamento de erros"),
        new Task("Caminhada matinal de 5 km", "done"),
        new Task("Encaminhar os emails", "pendente"),
        new StudyTask("Desenvolvimento de um projeto em Java", "em andamento", "Projeto final Java")
    );
    TaskController controller = new TaskController(listagem);
    controller.menu();
  }
}
