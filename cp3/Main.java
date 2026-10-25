import JavaTask.task3.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new FictionBook("Война и мир", "Толстой", 1869));
        library.addBook(new NonFictionBook("Java. Полное руководство", "Шилдт", 2020));

        try {
            library.borrowBook("Война и мир");
            library.borrowBook("Война и мир"); // Исключение
        } catch (BookUnavailableException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        library.returnBook("Война и мир");

        // Поиск по жанру
        ArrayList<Book> fiction = library.findBooksByGenre(Genre.FICTION);
        for (Book b : fiction) {
            b.read();
        }

        // Дополнительно: поиск научно-популярных
        ArrayList<Book> nonFiction = library.findBooksByGenre(Genre.NON_FICTION);
        for (Book b : nonFiction) {
            b.read();
        }

        // Использование LibraryHelper
        Book found = Library.LibraryHelper.findBookByTitle(
                new ArrayList<>(), "Java. Полное руководство"
        );
        if (found != null) found.read();
    }
}
