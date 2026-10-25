package JavaTask.task3;

public abstract class Book implements Readable {
    protected String title;
    protected String author;
    protected int year;
    protected Genre genre;
    protected boolean isAvailable = true;

    public Book(String title, String author, int year, Genre genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() { return title; }
    public Genre getGenre() { return genre; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public void read() {
        System.out.println("Чтение книги: " + title);
    }
}
