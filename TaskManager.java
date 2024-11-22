import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TaskManager extends Remote {

    String addTask(String task) throws RemoteException;

    String removeTask(int taskId) throws RemoteException;

    List<String> listTasks() throws RemoteException;

    String searchTask(String keyword) throws RemoteException;

    String clearTasks() throws RemoteException;
}
