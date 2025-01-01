package LibRary;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private Map<Integer, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public void displayBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }


    public List<Book> getBooks() {
        return books.values().stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    public List<Book> getBooks(boolean isAvailable) {
        return books.values().stream()
                .filter(book -> book.isAvailable() == isAvailable)
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }


    public long getBookCount() {
        return books.size();
    }


    public long getBookCount(boolean isAvailable) {
        return books.values().stream()
                .filter(book -> book.isAvailable() == isAvailable)
                .count();
    }


    public List<String> getAuthors() {
        return books.values().stream()
                .map(Book::getAuthor)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }


    public List<Book> getBooks(Comparator<Book> comparator) {
        return books.values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }


    public List<Book> getBooks(boolean isAvailable, Comparator<Book> comparator) {
        return books.values().stream()
                .filter(book -> book.isAvailable() == isAvailable)
                .sorted(comparator)
                .collect(Collectors.toList());
    }


    public Map<Boolean, List<Book>> getBooksByAvailability() {
        return books.values().stream()
                .collect(Collectors.partitioningBy(Book::isAvailable));
    }

    public Map<String, List<Book>> getBooksGroupedByAuthor() {
        return books.values().stream()
                .collect(Collectors.groupingBy(Book::getAuthor));


    }
}
