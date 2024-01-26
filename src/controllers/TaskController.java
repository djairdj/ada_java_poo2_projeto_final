package controllers;

import domain.StudyTask;
import domain.Task;
import services.TaskService;

import java.util.Scanner;

public class TaskController {
  private final Scanner scan = new Scanner(System.in);
  private final TaskService service = new TaskService();

  public void menu() {
    String menu = """
        ______ Menu Principal _____
        | 0 - Sair                 |
        | 1 - Listar tarefas       |
        | 2 - Listar uma tarefa    |
        | 3 - Atualizar uma tarefa |
        | 4 - Apagar uma tarefa    |
        | 5 - Criar uma tarefa     |
        '''''''''''''''''''''''''''
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
          System.out.println("Opção de listar uma tarefa.");
          break;
        case "3":
          System.out.println("Opção de atualizar uma tarefa.");
          break;
        case "4":
          System.out.println("Opção de apagar uma tarefa.");
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
           ___ Tipos de Tarefas ___
          | 1 - BaseTask
          | 2 - StudyTask
          | 3 - Sair
           """;
      Task task;
      loop:
      for(int i = 1; i <= n; i++) {
        task = null;
        opt = "";
        System.out.printf("Incluindo %dª tarefa:%n", i);
        while(!opt.equals("2") && !opt.equals("1")) {
          System.out.println(subMenu);
          System.out.println("Escolha uma opção acima");
          opt = scan.nextLine().trim();
          switch(opt) {
            case "1" -> task = createTask();
            case "2" -> task = createStudyTask();
            case "3" -> {
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
    System.out.println("Informe o status da StudyTask");
    status = scan.nextLine().trim();
    Task task = new Task(description, status);
    return task;
  }

}
