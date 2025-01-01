package LibRary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Library lib = new Library();

        lib.addBook(new Book(1, "DubZeleniy", "Pushkin", true));
        lib.addBook(new Book(2, "War and Peace", "Tolstoy", false));
        lib.addBook(new Book(3, "Java", "JohnDoe", false));
        lib.addBook(new Book(4, "Revizor", "Gogol", true));
        lib.addBook(new Book(5, "Prorok", "Pushkin", false));
        lib.addBook(new Book(6, "Vii", "Gogol", true));


        System.out.println("All books sorted by title:");
        lib.getBooks().forEach(System.out::println);


        System.out.println("\nВсе доступные книги:");
        lib.getBooks(true).forEach(System.out::println);


        System.out.println("\nОбщее количество книг " + lib.getBookCount());


        System.out.println("\nКоличество доступных книг по доступу " + lib.getBookCount(true));


        System.out.println("\nСписок книг по авторам, без дубликатов");
        lib.getAuthors().forEach(System.out::println);


        System.out.println("\nУниверсальный метод, сортировка по автору");
        lib.getBooks(Comparator.comparing(Book::getAuthor)).forEach(System.out::println);


        System.out.println("\nДоступные книги по автору: ");
        lib.getBooks(true, Comparator.comparing(Book::getAuthor)).forEach(System.out::println);


        System.out.println("\nПолучение одной книги по id: " + lib.getBookById(3));


        System.out.println("\nРазделение книг по доступности:");
        Map<Boolean, List<Book>> booksByAvailability = lib.getBooksByAvailability();
        booksByAvailability.forEach((available, booksList) -> {
            System.out.println(available ? "Доступные книги:" : "Недоступные книги:");
            booksList.forEach(System.out::println);
        });

        System.out.println("\nГруппировка книг по авторам:");
        Map<String, List<Book>> booksGroupedByAuthor = lib.getBooksGroupedByAuthor();
        booksGroupedByAuthor.forEach((author, booksList) -> {
            System.out.println("\nАвтор: " + author);
            booksList.forEach(System.out::println);
        });

    }
}

