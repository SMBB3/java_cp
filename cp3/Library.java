package JavaTask.task3;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String title) throws BookUnavailableException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    throw new BookUnavailableException("Книга '" + title + "' недоступна");
                }
                book.setAvailable(false);
                System.out.println("Книга '" + title + "' выдана");
                return;
            }
        }
        throw new BookUnavailableException("Книга '" + title + "' не найдена");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setAvailable(true);
                System.out.println("Книга '" + title + "' возвращена");
                return;
            }
        }
        System.out.println("Книга '" + title + "' не найдена");
    }

    // Статический вложенный класс
    public static class LibraryHelper {
        public static Book findBookByTitle(ArrayList<Book> books, String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }
    }

    // Поиск по жанру с анонимным классом
   public ArrayList < Book > findBooksByGenre(Genre genre) {
        BookFilter bookFilter = new BookFilter() {
            @Override
            public List < Book > findBooks(String filter) {
                ArrayList < Book > result = new ArrayList<>();
                for (Book book : books) {
                    if (book.getGenre() == genre) {
                        result.add(book);
                    }
                }
                return result;
            }
        };


        return (ArrayList) bookFilter.findBooks(genre.toString());
    }
}
