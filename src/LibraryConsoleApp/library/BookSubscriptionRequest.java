package LibraryConsoleApp.library;

import java.util.Objects;

public class BookSubscriptionRequest {


    private int bookId;
    private int readerId;

    public BookSubscriptionRequest(int bookId, int readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookSubscriptionRequest that = (BookSubscriptionRequest) o;
        return bookId == that.bookId && readerId == that.readerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, readerId);
    }

    public BookSubscriptionRequest() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "LibraryConsolApp.BookSubscriptionRequest{" +
                "bookId=" + bookId +
                ", readerId=" + readerId +
                '}';
    }
}
