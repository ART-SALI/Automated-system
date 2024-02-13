package LibraryConsoleApp.library;

import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publication;
    private LocalDate dateOfPublication;
    private int numberOfCopy;

    public Book(String name, String author, String publication, LocalDate dateOfPublication, int numberOfCopy) {
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.dateOfPublication = dateOfPublication;
        this.numberOfCopy = numberOfCopy;
    }

    public Book() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfCopy() {
        return numberOfCopy;
    }

    public void setNumberOfCopy(int numberOfCopy) {
        this.numberOfCopy = numberOfCopy;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public int getId() {
        return id;
    }

    public boolean compareTo(Book book){
        return this.getId() == book.getId();
    }
    @Override
    public String toString() {
        return "LibraryConsolApp.Book{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                ", dateOfPublication=" + dateOfPublication + '\'' +
                ", numberOfCopy=" + numberOfCopy + '\'' +
                '}';
    }
}
