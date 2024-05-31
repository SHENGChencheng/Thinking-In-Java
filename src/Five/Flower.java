package Five;

public class Flower {
    int petalCount = 0;
    String s = "initial value";
    
    Flower(int petails) {
        petalCount = petails;
        System.out.println("Constructor w/ int arg only, petailCount="
            + petalCount);
    }

    Flower(String ss) {
        System.out.println("Constructor w/ String arg only, s=" + ss);
    }

    Flower(String s, int petails) {
        this(petails);
        this.s = s;
        System.out.println("String and int args");
    }

    Flower() {
        this("hi", 47);
        System.out.println("default constructor no args");
    }

    void printPetalCount() {
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
