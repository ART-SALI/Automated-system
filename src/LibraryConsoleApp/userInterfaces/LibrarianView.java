package LibraryConsoleApp.userInterfaces;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.library.BookSubscriptionRequest;

import java.util.List;

public class LibrarianView {

    public LibrarianView() {
    }

    public void librarianMainMenu() {
        System.out.println("--------------------------------------------" + "\r\n" +
                "1.List of readers" + "\r\n" +
                "2.List of readers requests" + "\r\n" +
                "3.Create book subscription" + "\r\n" +
                "4.Look list of books" + "\r\n" +
                "5.Exit" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void listOfRequests(){
        FileSavingSystem fileSavingSystem = new FileSavingSystem();
        List<BookSubscriptionRequest> bookSubscriptionRequests = fileSavingSystem.readRequestData();
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
        bookSubscriptionRequests.forEach(request -> System.out.println(
                "bookId = " + request.getBookId() + " | " +
                        "readerId = " + request.getReaderId()
        ));
    }

    public void requestBookId(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write id of book of subscription" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void requestReaderId(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write id of reader who want subscription" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void BookSubFine(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write fine of book subscription if reader do not return the book" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void BookSubDate(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write date when book must be returned" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

}
