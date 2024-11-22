import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class TaskManagerClient {
    public static void main(String[] args) {
        try {
            
            int port = 2020;
            TaskManager taskManager = (TaskManager) Naming.lookup("rmi://localhost:" + port + "/TaskManager");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n--- Task Manager ---");
                System.out.println("1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. List Tasks");
                System.out.println("4. Search Task");
                System.out.println("5. Clear Tasks");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter task description: ");
                        String task = scanner.nextLine();
                        System.out.println(taskManager.addTask(task));
                    }
                    case 2 -> {
                        System.out.print("Enter task ID to remove: ");
                        int taskId = scanner.nextInt();
                        System.out.println(taskManager.removeTask(taskId));
                    }
                    case 3 -> {
                        List<String> tasks = taskManager.listTasks();
                        System.out.println("\nTasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + ": " + tasks.get(i));
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter keyword to search: ");
                        String keyword = scanner.nextLine();
                        System.out.println(taskManager.searchTask(keyword));
                    }
                    case 5 -> System.out.println(taskManager.clearTasks());
                    case 6 -> {
                        System.out.println("Exiting Task Manager...");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
