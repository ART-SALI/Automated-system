package LibraryConsoleApp.users;

import LibraryConsoleApp.library.BookSubscription;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ReaderUser extends User {
    private int fine = 0;

    private boolean isBlocked = false;
    private List<BookSubscription> booksInSubscriptions;
    public ReaderUser(int id, String login, String password) {
        super(id, login, password);
    }

    public ReaderUser() {
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public List<BookSubscription> getBooksInSubscriptions() {
        return booksInSubscriptions;
    }

    public void setBooksInSubscriptions(List<BookSubscription> booksInSubscriptions) {
        this.booksInSubscriptions = booksInSubscriptions;
    }

    @Override
    public String toString() {
        if(booksInSubscriptions==null){
            return "LibraryConsolApp.ReaderUser{" +
                    "fine=" + fine +
                    '}';
        }
        return "LibraryConsolApp.ReaderUser{" +
                "fine=" + fine +
                ", booksInSubscriptions=" + booksInSubscriptions.toString() +
                '}';
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }


    public String getBooksInSubscriptionToString() {
        AtomicReference<String> ans = new AtomicReference<>("");
        this.booksInSubscriptions.forEach(BookSubscription -> ans.set(
                ans + "bookId=" + String.valueOf(BookSubscription.getBookId()) + "\r\n" +
                        "dateOfPossibleReturn=" + BookSubscription.getDateOfPossibleReturn() + "\r\n" +
                        "fineIfNotReturned=" + BookSubscription.getFineIfNotReturned() + "\r\n"
                ));
        return ans.get();
    }



    public void addBookInSubscription(BookSubscription bookSubscription){
        if (this.booksInSubscriptions == null) this.booksInSubscriptions = List.of(bookSubscription);
        else this.booksInSubscriptions.add(bookSubscription);
    }


}
