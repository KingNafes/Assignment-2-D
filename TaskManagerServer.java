import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TaskManagerServer {
    public static void main(String[] args) {
        try {
            int port = 2020;
            LocateRegistry.createRegistry(port);

            TaskManagerImpl taskManager = new TaskManagerImpl();
            Naming.rebind("rmi://localhost:" + port + "/TaskManager", taskManager);

            System.out.println("TaskManagerServer is running on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
