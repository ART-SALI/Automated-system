package LibraryConsoleApp.userInterfaces;

public class OrderingView {

    public OrderingView() {
    }

    public void bookOrdering(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "If you want to order the book. You have next options." + "\r\n" + "\r\n" + "\r\n" +
                "1.If you know bookId you can start ordering"  + "\r\n" + "\r\n" +
                "2.If you do not know bookId you can search book or look at catalog"  + "\r\n" + "\r\n" +
                "3.Back to main menu"  + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void bookOrderingGetId(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write id of book you want order to" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void bookRequestSanded(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Your order was sanded to librarian. Wait for his agreement" + "\r\n" + "\r\n" + "\r\n" +
                "1.Go to main menu"  + "\r\n" +  "\r\n" +
                "2.Exit"  + "\r\n" +  "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

}
