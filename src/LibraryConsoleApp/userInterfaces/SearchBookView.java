package LibraryConsoleApp.userInterfaces;

import LibraryConsoleApp.library.Library;

public class SearchBookView {

    public SearchBookView() {
    }

    public void searchingBookOptions() {
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "You have two options in searching" + "\r\n" + "\r\n" +
                "1.Search book by name" + "\r\n" + "\r\n" +
                "2.Search book by author" + "\r\n" + "\r\n" +
                "3.Return to main menu" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void searchByAuthor(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write the author you want to find book(s)" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void searchByAuthor(Library library, String author){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
        library.searchByAuthor(author).forEach(Book -> System.out.println(
                "id = " + Book.getId() + " | " +
                        "name = " + Book.getName() + " | " +
                        "author = " + Book.getAuthor() + " | " +
                        "publication = " + Book.getPublication() + " | " +
                        "date of publication = " + Book.getDateOfPublication() + " | " +
                        "number of copies = " + Book.getNumberOfCopy()
        ));
        System.out.println("\r\n" + "\r\n" + "\r\n" + "Enter anything to go to main menu" + "\r\n" + "--------------------------------------------");
    }

    public void searchByName(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write the name of book(s) you want to find" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void searchByName(Library library, String name){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
        library.searchByName(name).forEach(Book -> System.out.println(
                "id = " + Book.getId() + " | " +
                        "name = " + Book.getName() + " | " +
                        "author = " + Book.getAuthor() + " | " +
                        "publication = " + Book.getPublication() + " | " +
                        "date of publication = " + Book.getDateOfPublication() + " | " +
                        "number of copies = " + Book.getNumberOfCopy()
        ));
        System.out.println("\r\n" + "\r\n" + "\r\n" + "Enter anything to go to main menu" + "\r\n" + "--------------------------------------------");
    }
}
