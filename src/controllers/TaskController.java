package controllers;

import services.TaskService;

import java.util.Scanner;

public class TaskController {
  private final Scanner scan = new Scanner(System.in);
  private final TaskService service = new TaskService();

  public void menu() {
    String menu = """
        ______ Menu Principal _____
        |0 - Sair                 |
        |1 - Listar tarefas       |
        |2 - Listar uma tarefa    |
        |3 - Atualizar uma tarefa |
        |4 - Apagar uma tarefa    |
        |5 - Criar uma tarefa     |
        '''''''''''''''''''''''''''
        """;
    String option = "";
    while(!option.equals("0")) {
      System.out.println(menu);
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
          System.out.println("Opção de criar uma tarefa.");
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  private void listTasks() {
    System.out.println("Chamando o service pra listar as tarefas:");
    this.service.listTasks();
  }
}
