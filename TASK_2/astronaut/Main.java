package TASK_2.astronaut;

import java.util.*;
import TASK_2.astronaut.factory.TaskFactory;
import TASK_2.astronaut.manager.ScheduleManager;
import TASK_2.astronaut.model.Task;
import TASK_2.astronaut.observer.ConflictNotifier;



public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduler = ScheduleManager.getInstance();
        scheduler.register(new ConflictNotifier());
        Scanner sc = new Scanner(System.in);

        while(true) {
            printMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addTask(sc, scheduler);
                    break;
                case "2":
                    removeTask(sc, scheduler);
                case "3":
                    scheduler.viewTasks();
                case "4":
                    System.out.println("Exiting application!!!");
                    sc.close();
                    return;
                default:
                    System.err.println("Invalid choice please try again");
            }

        }

    }

    private static void printMenu() {
        System.out.println("\n--- Astronaut Schedule Organizer ---");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View All Tasks");
        System.out.println("4. Exit");
        System.out.println("------------------------------------");
        System.out.print("Enter your choice: ");
    }

      private static void addTask(Scanner scanner, ScheduleManager scheduler) {
        System.out.println("\n--- Add a New Task ---");
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:mm): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
        if (task != null) {
            scheduler.addTask(task);
        }
    }

    private static void removeTask(Scanner sc, ScheduleManager scheduler) {
        System.out.println("\n---- Remove a task -----");
        System.out.println("Enter the description of the task to remove : ");
        String description = sc.nextLine();
        scheduler.removeTask(description);
    }



}
