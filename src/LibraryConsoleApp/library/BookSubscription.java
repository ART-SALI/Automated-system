package LibraryConsoleApp.library;

import java.time.LocalDate;
import java.util.Objects;

public class BookSubscription {
    private int bookId;
    private LocalDate dateOfPossibleReturn;
    private int fineIfNotReturned;

    public BookSubscription(int bookId, LocalDate dateOfPossibleReturn, int fineIfNotReturned) {
        this.bookId = bookId;
        this.dateOfPossibleReturn = dateOfPossibleReturn;
        this.fineIfNotReturned = fineIfNotReturned;
    }

    public BookSubscription() {

    }

    @Override
    public String toString() {
        return "LibraryConsolApp.BookSubscription{" +
                "bookId=" + bookId +
                ", dateOfPossibleReturn=" + dateOfPossibleReturn +
                ", fineIfNotReturned=" + fineIfNotReturned +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookSubscription that = (BookSubscription) o;
        return bookId == that.bookId && fineIfNotReturned == that.fineIfNotReturned && Objects.equals(dateOfPossibleReturn, that.dateOfPossibleReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, dateOfPossibleReturn, fineIfNotReturned);
    }

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getDateOfPossibleReturn() {
        return dateOfPossibleReturn;
    }

    public void setDateOfPossibleReturn(LocalDate dateOfPossibleReturn) {
        this.dateOfPossibleReturn = dateOfPossibleReturn;
    }

    public int getFineIfNotReturned() {
        return fineIfNotReturned;
    }

    public void setFineIfNotReturned(int fineIfNotReturned) {
        this.fineIfNotReturned = fineIfNotReturned;
    }
}
