package LibraryConsoleApp.userInterfaces;

import LibraryConsoleApp.library.Library;

public class CatalogView {

    public CatalogView() {
    }

    public void searchBookIdByCatalog(Library library){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
        library.getBooks().forEach(Book -> System.out.println(
                "id = " + Book.getId() + " | " +
                        "name = " + Book.getName() + " | " +
                        "author = " + Book.getAuthor() + " | " +
                        "publication = " + Book.getPublication() + " | " +
                        "date of publication = " + Book.getDateOfPublication() + " | " +
                        "number of copies = " + Book.getNumberOfCopy()
        ));
        System.out.println("\r\n" + "\r\n" +
                "1.Sort by Name" + "\r\n" + "\r\n" +
                "2.Sort by Author" + "\r\n" + "\r\n" +
                "3.Sort by Publication" + "\r\n" + "\r\n" +
                "4.Sort by Date of Publication" + "\r\n" + "\r\n" +
                "5. Back to book ordering" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
    }

    public void searchBookIdByCatalogSortedByName(Library library){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
        library.sortByName().forEach(Book -> System.out.println(
                "name = " + Book.getName() + " | " +
                        "id = " + Book.getId() + " | " +
                        "author = " + Book.getAuthor() + " | " +
                        "publication = " + Book.getPublication() + " | " +
                        "date of publication = " + Book.getDateOfPublication() + " | " +
                        "number of copies = " + Book.getNumberOfCopy()
        ));
        System.out.println("\r\n" + "\r\n" +
                "1.Sort by Author" + "\r\n" + "\r\n" +
                "2.Sort by Publication" + "\r\n" + "\r\n" +
                "3.Sort by Date of Publication" + "\r\n" + "\r\n" +
                "4. Back to book ordering" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
    }

    public void searchBookIdByCatalogSortedByAuthor(Library library){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
        library.sortByAuthor().forEach(Book -> System.out.println(
                "author = " + Book.getAuthor() + " | " +
                        "id = " + Book.getId() + " | " +
                        "name = " + Book.getName() + " | " +
                        "publication = " + Book.getPublication() + " | " +
                        "date of publication = " + Book.getDateOfPublication() + " | " +
                        "number of copies = " + Book.getNumberOfCopy()
        ));
        System.out.println("\r\n" + "\r\n" +
                "1.Sort by Name" + "\r\n" + "\r\n" +
                "2.Sort by Publication" + "\r\n" + "\r\n" +
                "3.Sort by Date of Publication" + "\r\n" + "\r\n" +
                "4. Back to book ordering" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
    }

    public void searchBookIdByCatalogSortedByPublication(Library library){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
        library.sortByPublication().forEach(Book -> System.out.println(
                "publication = " + Book.getPublication() + " | " +
                        "id = " + Book.getId() + " | " +
                        "name = " + Book.getName() + " | " +
                        "author = " + Book.getAuthor() + " | " +
                        "date of publication = " + Book.getDateOfPublication() + " | " +
                        "number of copies = " + Book.getNumberOfCopy()
        ));
        System.out.println("\r\n" + "\r\n" +
                "1.Sort by Author" + "\r\n" + "\r\n" +
                "2.Sort by Name" + "\r\n" + "\r\n" +
                "3.Sort by Date of Publication" + "\r\n" + "\r\n" +
                "4. Back to book ordering" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
    }

    public void searchBookIdByCatalogSortedByDateOfPublication(Library library){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
        library.sortByDateOfPublication().forEach(Book -> System.out.println(
                "date of publication = " + Book.getDateOfPublication() + " | " +
                        "id = " + Book.getId() + " | " +
                        "name = " + Book.getName() + " | " +
                        "author = " + Book.getAuthor() + " | " +
                        "publication = " + Book.getPublication() + " | " +
                        "number of copies = " + Book.getNumberOfCopy()
        ));
        System.out.println("\r\n" + "\r\n" +
                "1.Sort by Author" + "\r\n" + "\r\n" +
                "2.Sort by Publication" + "\r\n" + "\r\n" +
                "3.Sort by Name" + "\r\n" + "\r\n" +
                "4. Back to book ordering" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
    }
}
