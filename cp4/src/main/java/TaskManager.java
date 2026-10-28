import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }

    public void changeStatus(int id, TaskStatus newStatus) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setStatus(newStatus);
                return;
            }
        }
    }

    public void sortByPriority() {
        Collections.sort(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void saveToFile(String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(tasks);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName)
            throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Task> loaded = (List<Task>) ois.readObject();
            tasks.clear();
            tasks.addAll(loaded);
        }
    }
}