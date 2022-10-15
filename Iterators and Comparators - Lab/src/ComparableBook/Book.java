package ComparableBook;

import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = List.of(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        this.authors = List.of(authors);
    }

    @Override
    public int compareTo(Book b) {

        if (this.title.equals(b.getTitle())){
            if (this.year > b.getYear()){
                return 1;
            }else if(this.year == b.getYear()){
                return 0;
            }else if (this.year < b.getYear()){
                return -1;
            }
        }

            return this.title.compareTo(b.getTitle());

    };


    @Override
    public String toString() {
        return String.format("%s" , title);
    }
}
