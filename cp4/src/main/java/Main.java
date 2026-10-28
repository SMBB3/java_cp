import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Создание задач
        manager.addTask(new Task(1, "Написать отчёт", "Квартальный отчёт"));
        manager.addTask(new Task(2, "Позвонить клиенту", "Уточнить детали"));
        manager.addTask(new PriorityTask(3, "Сдать проект", "Дедлайн близко",
                Priority.HIGH));
        manager.addTask(new Task(4, "Прочитать статью", "Java Concurrency"));

        System.out.println("Все задачи");
        manager.getTasks().forEach(System.out::println);

        // Изменение статуса
        manager.changeStatus(1, TaskStatus.IN_PROGRESS);
        manager.changeStatus(2, TaskStatus.DONE);
        System.out.println("\nПосле изменения статусов");
        manager.getTasks().forEach(System.out::println);

        // Сортировка по приоритету
        manager.sortByPriority();
        System.out.println("\nПосле сортировки по приоритету");
        manager.getTasks().forEach(System.out::println);

        // Удаление
        manager.removeTask(4);
        System.out.println("\nПосле удаления задачи id=4");
        manager.getTasks().forEach(System.out::println);

        // Сохранение в файл
        String fileName = "tasks.dat";
        try {
            manager.saveToFile(fileName);
            System.out.println("\nЗадачи сохранены в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения: " + e.getMessage());
        }

        // Загрузка из файла с проверкой
        TaskManager loaded = new TaskManager();
        try {
            loaded.loadFromFile(fileName);
            System.out.println("Загружено из файла: " + fileName);
            loaded.getTasks().forEach(System.out::println);

            boolean same = loaded.getTasks().equals(manager.getTasks());
            System.out.println("\nДанные совпадают с исходными: " + same);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка загрузки: " + e.getMessage());
        }

        ImmutableTask it = new ImmutableTask(100, "Оригинал", Priority.LOW);
        ImmutableTask it2 = it.withTitle("Изменённая");

        System.out.println("\nImmutableTask");
        System.out.println("Оригинал (не изменился): " + it);
        System.out.println("Копия (новый объект):    " + it2);
        System.out.println("it == it2 ? " + (it == it2)); // false — разные объекты
    }
}