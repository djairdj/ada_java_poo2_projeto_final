package controllers;

import domain.StudyTask;
import domain.Task;
import domain.WorkTask;
import services.TaskService;

import java.util.List;
import java.util.Scanner;

public class TaskController {
  private final Scanner scan = new Scanner(System.in);
  private final TaskService service;

  public TaskController() {
    this.service = new TaskService();
  }

  public TaskController(List<Task> list) {
    this.service = new TaskService(list);
  }

  public void menu() {
    String menu = """
        ______ Menu Principal ______
        | 0 - Sair                 |
        | 1 - Listar tarefas       |
        | 2 - Listar uma tarefa    |
        | 3 - Atualizar uma tarefa |
        | 4 - Apagar uma tarefa    |
        | 5 - Criar uma tarefa     |
        ''''''''''''''''''''''''''''
        """;
    String option = "";
    while(!option.equals("0")) {
      System.out.print(menu);
      System.out.println("Escolha uma opção acima: ");
      option = scan.nextLine();
      switch(option) {
        case "0":
          System.out.println("Saindo do menu.");
          break;
        case "1":
          listTasks();
          break;
        case "2":
          getOneTask();
          break;
        case "3":
          updateOne();
          break;
        case "4":
          deleteTask();
          break;
        case "5":
          createTasks();
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  private void listTasks() {
    this.service.listTasks();
  }

  private void createTasks() {
    System.out.println("Quantas tarefas desejas criar? ");
    String opt = scan.nextLine().trim();
    try {
      int n = Integer.parseInt(opt.replaceAll("[,.]", ""));

      String subMenu = """
          __ Tipos de Tarefas __
          | 0 - Sair
          | 1 - BaseTask
          | 2 - StudyTask
          | 3 - WorkTask
           """;
      Task task;
      loop:
      for(int i = 1; i <= n; i++) {
        task = null;
        opt = "";
        System.out.printf("Incluindo %dª tarefa:%n", i);
        while(!opt.equals("2") && !opt.equals("1") && !opt.equals("3")) {
          System.out.println(subMenu);
          System.out.println("Escolha uma opção acima");
          opt = scan.nextLine().trim();
          switch(opt) {
            case "1" -> task = createTask();
            case "2" -> task = createStudyTask();
            case "3" -> task = createWorkTask();
            case "0" -> {
              System.out.println("Encerrada a inclusão.");
              break loop;
            }
            default -> System.out.println("Opção inválida!");
          }
        }
        service.createTask(task);
      }
    } catch(NumberFormatException ignored) {
      System.out.println("O valor '" + opt + "' não é válido.");
    }
  }

  private WorkTask createWorkTask() {
    String status, description, setor;
    System.out.println("Informe a descrição da WorkTask");
    description = scan.nextLine().trim();
    System.out.println("Informe o setor da WorkTask");
    setor = scan.nextLine().trim();
    System.out.println("Informe o status da WorkTask");
    status = scan.nextLine().trim();
    WorkTask workTask = new WorkTask(description, status, setor);
    return workTask;
  }

  private StudyTask createStudyTask() {
    String status, description, subject;
    System.out.println("Informe a descrição da StudyTask");
    description = scan.nextLine().trim();
    System.out.println("Informe o assunto da StudyTask");
    subject = scan.nextLine().trim();
    System.out.println("Informe o status da StudyTask");
    status = scan.nextLine().trim();
    StudyTask studyTask = new StudyTask(description, status, subject);
    return studyTask;
  }

  private Task createTask() {
    String status, description;
    System.out.println("Informe a descrição da Task");
    description = scan.nextLine().trim();
    System.out.println("Informe o status da Task");
    status = scan.nextLine().trim();
    Task task = new Task(description, status);
    return task;
  }

  public void getOneTask() {
    System.out.println("Informe o id da tarefa que pretendes listar: ");
    String id = scan.nextLine().trim();
    Task task = service.getOneTask(id);
    if(task != null) {
      System.out.println("A seguinte task foi encontrada:");
      System.out.println(task);
    } else System.out.println("Não foi possível obter a task a partir do id informado.");
  }

  public void updateOne() {
    System.out.print("Informe o id da tarefa que pretendes atualizar: ");
    String id = scan.nextLine().trim();
    Task task = service.getOneTask(id);
    if(task != null) {
      boolean modified = false;
      System.out.println("A seguinte task foi encontrada:");
      System.out.println(task);
      String status, description;
      System.out.println("Informe a descrição da Task");
      description = scan.nextLine().trim();
      System.out.println("Informe o status da Task");
      status = scan.nextLine().trim();
      if(!description.isBlank()) {
        task.setDescription(description);
        modified = true;
      }
      if(!status.isBlank()) {
        task.setStatus(status);
        modified = true;
      }
      if(task instanceof StudyTask) {
        System.out.println("Informe o assunto da StudyTask");
        String subject = scan.nextLine().trim();
        if(!subject.isBlank()) {
          ((StudyTask) task).setSubject(subject);
          modified = true;
        }
      } else if(task instanceof WorkTask) {
        System.out.println("Informe o setor da WorkTask");
        String setor = scan.nextLine().trim();
        if(!setor.isBlank()) {
          ((WorkTask) task).setSetor(setor);
          modified = true;
        }
      }
      if(modified) {
        Task taskUpdated = this.service.updateOneTask(task);
        if(taskUpdated != null) {
          System.out.println("Tarefa atualizada com sucesso.");
        } else {
          System.out.println("Não foi possível atualizar essa tarefa.");
        }
      } else System.out.println("Sem dados válidos para modificação.");
    } else System.out.println("Não foi possível obter a tarefa a partir do id informado.");
  }

  private void deleteTask() {
    System.out.println("Informe o id da tarefa que pretendes apagar: ");
    String id = scan.nextLine().trim();
    Task taskDeleted = service.deleteTask(id);
    if(taskDeleted != null) {
      System.out.println("A seguinte task foi deletada com sucesso:");
      System.out.println(taskDeleted);
    } else System.out.println("Não foi possível deletar.");
  }
}
