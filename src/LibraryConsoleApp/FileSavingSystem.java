package LibraryConsoleApp;

import LibraryConsoleApp.library.Book;
import LibraryConsoleApp.library.BookSubscription;
import LibraryConsoleApp.library.BookSubscriptionRequest;
import LibraryConsoleApp.users.Librarian;
import LibraryConsoleApp.users.ReaderUser;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class FileSavingSystem {
    public FileSavingSystem() {
    }

    public void saveBooksData(List<Book> books){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "src/LibraryConsoleApp/SavedData/ListOfBooks.txt"))){


            for (LibraryConsoleApp.library.Book Book : books) {
                writer.write("---start---" + "\r\n" +
                        "id=" + Book.getId() + "\r\n" +
                        "name=" + Book.getName() + "\r\n" +
                        "author=" + Book.getAuthor() + "\r\n" +
                        "publication=" + Book.getPublication() + "\r\n" +
                        "dateOfPublication=" + Book.getDateOfPublication() + "\r\n" +
                        "numberOfCopy=" + Book.getNumberOfCopy() + "\r\n" +
                        "---end---" + "\r\n");
            }
        } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

    public void saveLog(String log){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "src/LibraryConsoleApp/SavedData/Logs.txt", true))){
                    writer.write(LocalDateTime.now() + " | " +log + "\r\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveReadersData(List<ReaderUser> readers){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "src/LibraryConsoleApp/SavedData/Readers.txt"))){

            for (ReaderUser UserReaders : readers) {
                if (UserReaders.getBooksInSubscriptions() == null)
                    writer.write("---start---" + "\r\n" +
                                "id=" + UserReaders.getId() + "\r\n" +
                                "login=" + UserReaders.getLogin() + "\r\n" +
                                "isBlocked=" + UserReaders.isBlocked() + "\r\n" +
                                "password=" + UserReaders.getPassword() + "\r\n" +
                                "fine=" + UserReaders.getFine() + "\r\n" +
                                "---end---" + "\r\n");

                else writer.write("---start---" + "\r\n" +
                            "id=" + UserReaders.getId() + "\r\n" +
                            "login=" + UserReaders.getLogin() + "\r\n" +
                            "isBlocked=" + UserReaders.isBlocked() + "\r\n" +
                            "password=" + UserReaders.getPassword() + "\r\n" +
                            "fine=" + UserReaders.getFine() + "\r\n" +
                            "---BooksInSubscriptionStart---" + "\r\n" +
                            UserReaders.getBooksInSubscriptionToString() +
                            "---BooksInSubscriptionEnd---" + "\r\n" +
                            "---end---" + "\r\n");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveLibrarianData(List<Librarian> librarians){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(
                "src/LibraryConsoleApp/SavedData/Librarians.txt"))) {

            for (Librarian librarian : librarians) {
                writer.write("---start---" + "\r\n" +
                        "id=" + librarian.getId() + "\r\n" +
                        "login=" + librarian.getLogin() + "\r\n" +
                        "password=" + librarian.getPassword() + "\r\n" +
                        "---end---" + "\r\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveRequestData(List<BookSubscriptionRequest> requests){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(
                "src/LibraryConsoleApp/SavedData/ListOfRequests.txt"))) {

            for (BookSubscriptionRequest Request : requests) {
                writer.write("---start---" + "\r\n" +
                        "readerId=" + Request.getReaderId() + "\r\n" +
                        "bookId=" + Request.getBookId() + "\r\n" +
                        "---end---" + "\r\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public List<Book> readBooksData(){
        List<Book> books = new java.util.ArrayList<>(List.of());
        try(BufferedReader reader = new BufferedReader(new FileReader(
                "src/LibraryConsoleApp/SavedData/ListOfBooks.txt"))) {


            String line;
            Book book  = new Book();

            while((line = reader.readLine()) != null) {

                if (line.trim().equals("---start---")) {
                    book  = new Book();
                } else if (line.trim().equals("---end---")) {
                    books.add(book);
                } else if (line.trim().startsWith("id=")) {
                    book.setId(Integer.parseInt(line.substring("id=".length()).trim()));
                } else if (line.trim().startsWith("name=")) {
                    book.setName(line.substring("name=".length()).trim());
                } else if (line.trim().startsWith("author=")) {
                    book.setAuthor(line.substring("author=".length()).trim());
                }else if (line.trim().startsWith("publication=")) {
                    book.setPublication(line.substring("publication=".length()).trim());
                }else if (line.trim().startsWith("dateOfPublication=")) {
                    book.setDateOfPublication( LocalDate.parse(line.substring("dateOfPublication=".length()).trim()));
                }else if (line.trim().startsWith("numberOfCopy=")) {
                    book.setNumberOfCopy(Integer.parseInt(line.substring("numberOfCopy=".length()).trim()));
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public List<BookSubscriptionRequest> readRequestData(){
        List<BookSubscriptionRequest> requests = new java.util.ArrayList<>(List.of());
        try(BufferedReader reader = new BufferedReader(new FileReader("src/LibraryConsoleApp/SavedData/ListOfRequests.txt"))) {

            String line;
            BookSubscriptionRequest request  = new BookSubscriptionRequest();

            while((line = reader.readLine()) != null) {

                if (line.trim().equals("---start---")) {
                    request   = new BookSubscriptionRequest();
                } else if (line.trim().equals("---end---")) {
                    requests.add(request);
                } else if (line.trim().startsWith("readerId=")) {
                    request.setReaderId(Integer.parseInt(line.substring("readerId=".length()).trim()));
                } else if (line.trim().startsWith("bookId=")) {
                    request.setBookId(Integer.parseInt(line.substring("bookId=".length()).trim()));
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return requests;
    }

    public List<ReaderUser> readReadersData() {
        List<ReaderUser> readerUsers = new java.util.ArrayList<>(List.of());
        try (BufferedReader reader = new BufferedReader(new FileReader("src/LibraryConsoleApp/SavedData/Readers.txt"))){

            String line;
            ReaderUser readerUser = new ReaderUser();

            while ((line = reader.readLine()) != null) {

                if (line.trim().equals("---start---")) {
                    readerUser = new ReaderUser();
                } else if (line.trim().equals("---end---")) {
                    readerUsers.add(readerUser);
                } else if (line.trim().startsWith("id=")) {
                    readerUser.setId(Integer.parseInt(line.substring("id=".length()).trim()));
                } else if (line.trim().startsWith("login=")) {
                    readerUser.setLogin(line.substring("login=".length()).trim());
                } else if (line.trim().startsWith("isBlocked=")) {
                    readerUser.setBlocked(line.substring("isBlocked=".length()).trim().equals("true"));
                }
                else if (line.trim().startsWith("password=")) {
                        readerUser.setPassword(line.substring("password=".length()).trim());
                    } else if (line.trim().startsWith("fine=")) {
                        readerUser.setFine(Integer.parseInt(line.substring("fine=".length()).trim()));
                    } else if (line.trim().startsWith("---BooksInSubscriptionStart---")) {
                        List<BookSubscription> bookSubscriptions = new java.util.ArrayList<>(List.of());
                        BookSubscription bookSubscription = new BookSubscription();
                        while (!(line = reader.readLine()).equals("---BooksInSubscriptionEnd---")) {
                            if (line.trim().startsWith("bookId=")) {
                                bookSubscription.setBookId(Integer.parseInt(line.substring("bookId=".length()).trim()));
                            } else if (line.trim().startsWith("dateOfPossibleReturn=")) {
                                bookSubscription.setDateOfPossibleReturn(LocalDate.parse(
                                        line.substring("dateOfPossibleReturn=".length()).trim())
                                );
                            } else if (line.trim().startsWith("fineIfNotReturned=")) {
                                bookSubscription.setFineIfNotReturned(
                                        Integer.parseInt(line.substring("fineIfNotReturned=".length()).trim())
                                );
                                bookSubscriptions.add(bookSubscription);

                            }
                        }
                        readerUser.setBooksInSubscriptions(bookSubscriptions);
                    }


                }
            } catch(IOException e){
                throw new RuntimeException(e);
            }
            return readerUsers;
        }

    public List<Librarian> readLibrariansData() {
        List<Librarian> librarians = new java.util.ArrayList<>(List.of());
        try(BufferedReader reader = new BufferedReader(new FileReader("src/LibraryConsoleApp/SavedData/Librarians.txt"))) {

            String line;
            Librarian librarian = new Librarian();

            while ((line = reader.readLine()) != null) {

                if (line.trim().equals("---start---")) {
                    librarian = new Librarian();
                } else if (line.trim().equals("---end---")) {
                    librarians.add(librarian);
                } else if (line.trim().startsWith("id=")) {
                    librarian.setId(Integer.parseInt(line.substring("id=".length()).trim()));
                } else if (line.trim().startsWith("login=")) {
                    librarian.setLogin(line.substring("login=".length()).trim());
                } else if (line.trim().startsWith("password=")) {
                    librarian.setPassword(line.substring("password=".length()).trim());
                }

            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
        return librarians;
    }

}
