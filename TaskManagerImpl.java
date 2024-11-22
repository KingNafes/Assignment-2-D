import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerImpl extends UnicastRemoteObject implements TaskManager {
    private final List<String> tasks;
    
    protected TaskManagerImpl() throws RemoteException {
        super();
        tasks = new ArrayList<>();
    }

    @Override
    public synchronized String addTask(String task) throws RemoteException {
        tasks.add(task);
        return "Task added: " + task;
    }

    @Override
    public synchronized String removeTask(int taskId) throws RemoteException {
        if (taskId < 0 || taskId >= tasks.size()) {
            return "Invalid task ID.";
        }
        String removedTask = tasks.remove(taskId);
        return "Task removed: " + removedTask;
    }

    @Override
    public synchronized List<String> listTasks() throws RemoteException {
        if (tasks.isEmpty()) {
            return List.of("No tasks available.");
        }
        return new ArrayList<>(tasks);
    }

    @Override
    public synchronized String searchTask(String keyword) throws RemoteException {
        for (String task : tasks) {
            if (task.contains(keyword)) {
                return "Found task: " + task;
            }
        }
        return "No tasks found with the keyword: " + keyword;
    }

    @Override
    public synchronized String clearTasks() throws RemoteException {
        tasks.clear();
        return "All tasks cleared.";
    }
}
