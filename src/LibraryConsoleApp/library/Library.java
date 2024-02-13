package LibraryConsoleApp.library;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    private int numberOfUniqueBooks = 0;

    public Library(List<Book> books, boolean withId) {
        if (!withId) {
            books.forEach(Book -> {Book.setId(numberOfUniqueBooks);
                this.numberOfUniqueBooks+=1;
            });
        }
        this.books = books;
    }

    public int getNumberOfUniqueBooks() {
        return numberOfUniqueBooks;
    }

    public Library(List<Book> books) {
        this.books = books;
        this.numberOfUniqueBooks = books.size();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> sortByName(){
        return this.books.stream().sorted(Comparator.comparing(Book::getName)).collect(Collectors.toList());
    }

    public List<Book> sortByAuthor(){
        return this.books.stream().sorted(Comparator.comparing(Book::getAuthor)).collect(Collectors.toList());
    }

    public List<Book> sortByPublication(){
        return this.books.stream().sorted(Comparator.comparing(Book::getPublication)).collect(Collectors.toList());
    }

    public List<Book> sortByDateOfPublication(){
        return this.books.stream().sorted(Comparator.comparing(Book::getDateOfPublication)).collect(Collectors.toList());
    }

    public List<Book> searchByName(String name){
        return this.books.stream().filter(Book -> Book.getName().contains(name)).collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author){
        return this.books.stream().filter(Book -> Objects.equals(Book.getAuthor(), author)).collect(Collectors.toList());
    }

    public Book searchById(int id){
        return this.books.stream().filter(Book -> Book.getId() == id).findAny().orElse(null);
    }

    public void addUniqueBook(){
        this.numberOfUniqueBooks += 1;
    }

    public void minusUniqueBook(){
        this.numberOfUniqueBooks -= 1;
    }
    @Override
    public String toString() {
        return books.toString();
    }
}
