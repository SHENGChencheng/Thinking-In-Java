package Five;

class Person {
    public void eat (Apple apple) {
        @SuppressWarnings("unused")
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        return apple;
    }
}

class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}
public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
