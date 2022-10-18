package Library;

import Book.Book;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book boоkThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library(bookOne, bookTwo, boоkThree);

        for (Book book: library) {
            System.out.println(book.getTitle());
        }

    }
}
