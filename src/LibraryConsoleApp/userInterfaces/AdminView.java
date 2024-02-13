package LibraryConsoleApp.userInterfaces;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.library.Library;

public class AdminView {

    public AdminView() {
    }

    public void mainAdminMenu(){
        System.out.println("-----------------ADMIN-MENU-----------------" + "\r\n" +
                "1.Add the book" + "\r\n" +
                "2.Delete the book" + "\r\n" +
                "3.Change the book information" + "\r\n" +
                "4.Add the librarian" + "\r\n" +
                "5.Delete the librarian" + "\r\n" +
                "6.Look the librarians list" + "\r\n" +
                "7.Block the reader" + "\r\n" +
                "8.Unblock the reader" + "\r\n" +
                "9.Look the readers list" + "\r\n" +
                "10.Look at book catalog" + "\r\n" +
                "11.Exit" + "\r\n" +
                "--------------------------------------------"
        );


    }

    public void addBookName(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write book name" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }
    public void addBookAuthor(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write book author" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }
    public void addBookPublication(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write book publication" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }
    public void addBookDateOfPublication(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write book date of publication(format YYYY-MM-DD)" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }
    public void addBookNumberOfCopy(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write book number of copy" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void deleteBook(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write id fo book you want delete" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }
    public void listOfBooks(){
        FileSavingSystem fileSavingSystem = new FileSavingSystem();
        Library library = new Library(fileSavingSystem.readBooksData());
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
        library.getBooks().forEach(Book -> System.out.println(
                "id = " + Book.getId() + " | " +
                        "name = " + Book.getName() + " | " +
                        "author = " + Book.getAuthor() + " | " +
                        "publication = " + Book.getPublication() + " | " +
                        "date of publication = " + Book.getDateOfPublication() + " | " +
                        "number of copies = " + Book.getNumberOfCopy()
        ));
    }


}
