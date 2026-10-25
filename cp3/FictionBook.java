package JavaTask.task3;

public class FictionBook extends Book {
    public FictionBook(String title, String author, int year) {
        super(title, author, year, Genre.FICTION);
    }

    @Override
    public void read() {
        System.out.println("Чтение художественной книги: " + title);
    }
}