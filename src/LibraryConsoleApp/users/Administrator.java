package LibraryConsoleApp.users;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.library.Book;
import LibraryConsoleApp.library.Library;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Administrator {

    FileSavingSystem dataBase = new FileSavingSystem();
    Library library = new Library(dataBase.readBooksData());
    ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());

    List<Librarian> librarians = dataBase.readLibrariansData();

    public Administrator() {
    }

    public ReadersBase blockReader(int readerId) {
        ReaderUser reader = readersBase.getReaders().get(readerId);
        reader.setBlocked(true);
        readersBase.updateReader(reader);
        dataBase.saveReadersData(readersBase.getReaders());
        return readersBase;
    }

    public ReadersBase unblockReader(int readerId) {
        ReaderUser reader = readersBase.getReaders().get(readerId);
        reader.setBlocked(false);
        readersBase.updateReader(reader);
        dataBase.saveReadersData(readersBase.getReaders());
        return readersBase;
    }

    public Library addBook(Book book){
        List<Book> books = library.getBooks();
        AtomicBoolean bookInLibrary = new AtomicBoolean(false);
        books.forEach(book1 -> {
            if (book1.getAuthor().equals(book.getAuthor()) &&
                    book1.getName().equals(book.getName()) &&
            book1.getDateOfPublication().equals(book.getDateOfPublication()) &&
            book1.getPublication().equals(book.getPublication())) {
                book1.setNumberOfCopy(book1.getNumberOfCopy() + 1);
                library.setBooks(books);
                bookInLibrary.set(true);
            }
        });
        if (bookInLibrary.get()) {
            return library;
        }
        book.setId(library.getNumberOfUniqueBooks());
        books.add(book);
        library.setBooks(books);
        library.addUniqueBook();
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library addBook(String name, String author, String publication, LocalDate dateOfPublication, int numberOfCopy){
        return this.addBook(new Book(name, author, publication, dateOfPublication, numberOfCopy));
    }

    public Library deleteBook(Book book){
        if (library.getNumberOfUniqueBooks() == 0) {
            return library;
        } else if (library.getNumberOfUniqueBooks() == 1){
            library.setBooks(null);
            library.minusUniqueBook();
            dataBase.saveBooksData(library.getBooks());
            return library;
        } else if (book.getId() == 0) {
            library.setBooks(library.getBooks().subList(1, library.getNumberOfUniqueBooks()));
            library.minusUniqueBook();
            List<Book> books = library.getBooks();
            books.forEach(book1 -> book1.setId(book1.getId() - 1));
            dataBase.saveBooksData(books);
            return library;
        } else if (book.getId() == library.getNumberOfUniqueBooks() - 1) {
            library.setBooks(library.getBooks().subList(0, library.getNumberOfUniqueBooks() - 1));
            library.minusUniqueBook();
            dataBase.saveBooksData(library.getBooks());
            return library;
        } else {
            List<Book> books = library.getBooks().subList(0, book.getId());
            List<Book> books2 = library.getBooks().subList(book.getId() + 1, library.getNumberOfUniqueBooks());
            books2.forEach(book1 -> book1.setId(book1.getId() - 1));
            books.addAll(books2);
            library.minusUniqueBook();
            library.setBooks(books);
            dataBase.saveBooksData(library.getBooks());
            return library;
        }
    }

    public Library deleteBook(int bookId){
        return this.deleteBook(library.searchById(bookId));
    }

    public Library changeBookName(Book book, String name){
        List<Book> books = library.getBooks();
        book.setName(name);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library changeBookName(int bookId, String name){
        List<Book> books = library.getBooks();
        Book book = books.get(bookId);
        book.setName(name);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library changeBookPublication(Book book, String publication){
        List<Book> books = library.getBooks();
        book.setPublication(publication);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library changeBookPublication(int bookId, String publication){
        List<Book> books = library.getBooks();
        Book book = books.get(bookId);
        book.setPublication(publication);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library changeBookAuthor(Book book, String author){
        List<Book> books = library.getBooks();
        book.setAuthor(author);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library changeBookAuthor(int bookId, String author){
        List<Book> books = library.getBooks();
        Book book = books.get(bookId);
        book.setAuthor(author);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library changeBookDateOfPublication(Book book, LocalDate dateOfPublication){
        List<Book> books = library.getBooks();
        book.setDateOfPublication(dateOfPublication);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library changeBookDateOfPublication(int bookId, LocalDate dateOfPublication){
        List<Book> books = library.getBooks();
        Book book = books.get(bookId);
        book.setDateOfPublication(dateOfPublication);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library changeBookNumberOfCopy(Book book, int numberOfCopy){
        List<Book> books = library.getBooks();
        book.setNumberOfCopy(numberOfCopy);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library changeBookNumberOfCopy(int bookId, int numberOfCopy){
        List<Book> books = library.getBooks();
        Book book = books.get(bookId);
        book.setNumberOfCopy(numberOfCopy);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library addBookNumberOfCopy(Book book, int numberOfCopy){
        List<Book> books = library.getBooks();
        book.setNumberOfCopy(book.getNumberOfCopy() + numberOfCopy);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library addBookNumberOfCopy(int bookId, int numberOfCopy){
        List<Book> books = library.getBooks();
        Book book = books.get(bookId);
        book.setNumberOfCopy(book.getNumberOfCopy() + numberOfCopy);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library minusBookNumberOfCopy(Book book, int numberOfCopy){
        List<Book> books = library.getBooks();
        book.setNumberOfCopy(book.getNumberOfCopy() - numberOfCopy);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }

    public Library minusBookNumberOfCopy(int bookId, int numberOfCopy){
        List<Book> books = library.getBooks();
        Book book = books.get(bookId);
        book.setNumberOfCopy(book.getNumberOfCopy() - numberOfCopy);
        books.set(book.getId(), book);
        library.setBooks(books);
        dataBase.saveBooksData(library.getBooks());
        return library;
    }


    public void deleteLibrarian(int librarianId){
        librarians.remove(librarianId);
        dataBase.saveLibrarianData(librarians);
    }

    public void addLibrarian(String log, String pass){
        librarians.add(new Librarian(librarians.get(librarians.size() - 1).getId() + 1, log, pass));
        dataBase.saveLibrarianData(librarians);
    }


}
