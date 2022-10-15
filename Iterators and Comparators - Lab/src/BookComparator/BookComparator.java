package BookComparator;

import ComparableBook.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {


    @Override
    public int compare(Book firstBook, Book secondBook) {

        if (firstBook.getTitle().equals(secondBook.getTitle())) {
            if (firstBook.getYear() < secondBook.getYear()) {
                return -1;
            } else if (firstBook.getYear() == secondBook.getYear()) {
                return 0;
            } else if (firstBook.getYear() > secondBook.getYear()) {
                return 1;
            }
        }

        return firstBook.getTitle().compareTo(secondBook.getTitle());
    }
}
