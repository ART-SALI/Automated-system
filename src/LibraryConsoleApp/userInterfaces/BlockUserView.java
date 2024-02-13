package LibraryConsoleApp.userInterfaces;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.users.Librarian;
import LibraryConsoleApp.users.ReadersBase;

import java.util.List;

public class BlockUserView {

    public BlockUserView() {
    }

    public void listOfReaders(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n");
        FileSavingSystem fileSavingSystem = new FileSavingSystem();
        ReadersBase readersBase = new ReadersBase(fileSavingSystem.readReadersData());
        readersBase.getReaders().forEach(readerUser -> {
            System.out.println("id=" + readerUser.getId() + " | " +
                    "login=" + readerUser.getLogin() + " | " +
                    "password=" + readerUser.getPassword() + " | " +
                    "isBlocked=" + readerUser.isBlocked() + " | " +
                    "fine=" + readerUser.getFine() + " || ");
            try {
                readerUser.getBooksInSubscriptions().forEach(bookSubscription ->
                        System.out.print(
                                "bookId=" + bookSubscription.getBookId() + " | " +
                                        "dateOfPossibleReturn=" + bookSubscription.getDateOfPossibleReturn() + " | " +
                                        "fineIfNotReturned=" + bookSubscription.getFineIfNotReturned() + " || "
                        )
                );
            }catch (Exception e){

            }

                }
        );
        System.out.println("\r\n" + "\r\n" + "--------------------------------------------");
    }

    public void block(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write id of user you want to block" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void unblock(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write id of user you want to unblock" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }
}
