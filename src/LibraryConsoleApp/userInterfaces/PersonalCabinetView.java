package LibraryConsoleApp.userInterfaces;

import LibraryConsoleApp.library.Book;
import LibraryConsoleApp.library.Library;
import LibraryConsoleApp.users.ReaderUser;

public class PersonalCabinetView {

    public PersonalCabinetView() {
    }

    public void loginChanging(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write your new login" + "\r\n" + "\r\n" + "\r\n" +
                "\r\n" +  "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void loginChangingSuccess(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Login changed successfully" + "\r\n" + "\r\n" + "\r\n" +
                "1.Go to main menu"+  "\r\n" + "\r\n" +
                "2.Exit"+  "\r\n" + "\r\n" +
                "\r\n" +  "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void passwordChanging(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write your new password" + "\r\n" + "\r\n" + "\r\n" +
                "\r\n" +  "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void passwordChangingSuccess(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Password changed successfully" + "\r\n" + "\r\n" + "\r\n" +
                "1.Go to main menu"+  "\r\n" + "\r\n" +
                "2.Exit"+  "\r\n" + "\r\n" +
                "\r\n" +  "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void finePayingSuccess(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "You paid your fine successfully" + "\r\n" + "\r\n" + "\r\n" +
                "1.Go to main menu"+  "\r\n" + "\r\n" +
                "2.Exit"+  "\r\n" + "\r\n" +
                "\r\n" +  "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }


    public void listOfBooksInSubscription(Library library, ReaderUser reader){
        if (reader.getBooksInSubscriptions() == null) {
            System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                    "You do not have any book in subscription" + "\r\n" + "\r\n" + "\r\n" +
                    "1.Go to main menu"+  "\r\n" + "\r\n" +
                    "2.Exit"+  "\r\n" + "\r\n" +
                    "\r\n" +  "\r\n" + "\r\n" +
                    "--------------------------------------------"
            );
        } else {

            System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");
            reader.getBooksInSubscriptions().forEach(BookInSubscription -> {
                Book book = library.searchById(BookInSubscription.getBookId());
                System.out.println(
                        "id = " + book.getId() + " | " +
                                "name = " + book.getName() + " | " +
                                "author = " + book.getAuthor() + " | " +
                                "publication = " + book.getPublication() + " | " +
                                "date of publication = " + book.getDateOfPublication() + " | " +
                                "number of copies = " + book.getNumberOfCopy());
            });

            System.out.println("\r\n" + "\r\n" +
                    "1.Return book by id" + "\r\n" + "\r\n" +
                    "5.Go to main menu" + "\r\n" + "\r\n" + "\r\n" +
                    "--------------------------------------------" + "\r\n" + "\r\n" + "\r\n");

        }

    }

    public void personalCabinet(ReaderUser user){

            System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                    "Your current user information:" + "\r\n" + "\r\n" + "\r\n" +
                    "Login: " + user.getLogin()  + "\r\n" + "\r\n"
            );

            if (user.getBooksInSubscriptions() == null) {
                System.out.println(
                        "Your have not any book subscription" + "\r\n" + "\r\n"
                );
            } else System.out.println(user.getBooksInSubscriptionToString() + "\r\n" + "\r\n" );


            if (user.getFine() == 0)System.out.println("Your have not any fines" + "\r\n" + "\r\n");
            else System.out.println("Your current fine is " + user.getFine() + "$" + "\r\n" + "\r\n" + "\r\n");


            System.out.println(
                    "1.Change login" + "\r\n" + "\r\n" +
                            "2.Change password" + "\r\n" + "\r\n" +
        "3.Return book" + "\r\n" + "\r\n");

            if (user.getFine() == 0) System.out.println("4.Back to main menu" + "\r\n" + "\r\n" + "\r\n");
            else System.out.println("4.Pay for your fine" + "\r\n" + "\r\n" +
                        "5.Back to main menu" + "\r\n" + "\r\n" + "\r\n");

            System.out.println("--------------------------------------------");

    }

    public void noBookToReturn(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "You do not have book subscription" +
                "\r\n" +  "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void bookReturnId(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write id of book you want to return" +
                "\r\n" +  "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void todayDate(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write todayDate" +
                "\r\n" +  "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

}
