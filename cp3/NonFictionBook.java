package JavaTask.task3;

public class NonFictionBook extends Book {
    public NonFictionBook(String title, String author, int year) {
        super(title, author, year, Genre.NON_FICTION);
    }

    @Override
    public void read() {
        System.out.println("Чтение научно-популярной книги: " + title);
    }
}
