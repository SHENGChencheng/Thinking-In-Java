package Test.Threads.Bal;

import java.util.*;

public class Bal {
    protected String message;

    public Bal() {
        message = null;
    }

    public synchronized void lireUnMessage(String consommateur) throws InterruptedException {
        while (message == null) {
            wait();
            System.out.println("%% " + consommateur + " mise en attente");
        }
        System.out.println("%% retraite de " + message + " par " + consommateur);
        message = null;
        notifyAll();
    }

    public synchronized void deposerUnmessage(String producteur, String lettre) throws InterruptedException {
        while (message != null) {
            wait();
            System.out.println(">> " + producteur + " mise en attente");
        }
        System.out.println(">> depot de " + lettre);
        message = lettre;
        notifyAll();
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        Bal box = new Bal();
        ArrayList<Producteur> setProd = new ArrayList<>();
        setProd.add(new Producteur("P1", box));
        setProd.add(new Producteur("P2", box));
        ArrayList<Consommateur> setCons = new ArrayList<>();
        setCons.add(new Consommateur("C1", box));
        setCons.add(new Consommateur("C2", box));
        setCons.add(new Consommateur("C3", box));
        Iterator<Producteur> itP = setProd.iterator();
        while (itP.hasNext()) {
            itP.next().ecrire();
        }
        Iterator<Consommateur> itC = setCons.iterator();
        while (itC.hasNext()) {
            itC.next().lire();
        }
    }
}
