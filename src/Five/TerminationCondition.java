package Five;

class Book {
    boolean checkedout = false;
    Book(boolean checkOut) {
        checkedout = checkOut;
    }

    void checkIn() {
        checkedout = false;
    }

    protected void finalize() {
        if (checkedout) {
            System.out.println("Error: checked out");
        }
    }
}

public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        //Book comedy = new Book(true);
        System.gc();
    }
}
