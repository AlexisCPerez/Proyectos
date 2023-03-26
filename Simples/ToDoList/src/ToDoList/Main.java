package ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("Ingresa una opcion:");
            System.out.println("1. Añadir una tarea");
            System.out.println("2. Remover una tarea");
            System.out.println("3. Ver tareas");
            System.out.println("4. Salir");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Ingresar tarea: ");
                scanner.nextLine(); // consume newline character
                String task = scanner.nextLine();
                tasks.add(task);
                System.out.println("Tarea añadida.");
            } else if (choice == 2) {
                System.out.print("Ingresa el numero de la tarea a remover: ");
                int taskNumber = scanner.nextInt();
                if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                    String removedTask = tasks.remove(taskNumber - 1);
                    System.out.println(removedTask + " removida.");
                } else {
                    System.out.println("Numero de tarea invalido.");
                }
            } else if (choice == 3) {
                if (tasks.size() == 0) {
                    System.out.println("Sin tareas.");
                } else {
                    System.out.println("Tareas:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                }
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Opcion invalida.");
            }
        }
    }
}
