package LibraryConsoleApp.users;

import LibraryConsoleApp.library.BookSubscription;
import LibraryConsoleApp.library.BookSubscriptionRequest;
import LibraryConsoleApp.library.Library;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Librarian extends User {

    public Librarian(int id, String login, String password) {
        super(id, login, password);
    }

    public Librarian() {
    }

    public BookSubscription bookSubscriptionCreate(BookSubscriptionRequest request,
                                                int fine, LocalDate date){
        return new BookSubscription(request.getBookId(), date, fine);
    }

    public ReadersBase bookSubscriptionAdd(BookSubscription bookSubscription,
                                           BookSubscriptionRequest request,
                                           ReadersBase readers){
        ReaderUser newReader = readers.searchById(request.getReaderId());
        List<BookSubscription> bookSubscriptions = newReader.getBooksInSubscriptions();
        bookSubscriptions.add(bookSubscription);
        newReader.setBooksInSubscriptions(bookSubscriptions);
        readers.updateReader(newReader);
        return readers;
    }

    public boolean bookInLibrary(Library library, int bookId){
        AtomicBoolean ans = new AtomicBoolean(false);
        library.getBooks().forEach(book -> {
            if (book.getId() == bookId && book.getNumberOfCopy() > 0) {
                    ans.set(true);
            }
        });
        return ans.get();
    }

}
