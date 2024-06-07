package Test.Threads.Bal;

public class Producteur implements Runnable{
    private String nom;
    private Bal mailBox;
    private int nbMessage;
    private Thread t;

    public Producteur(String name, Bal boite) {
        nom = name;
        mailBox = boite;
        nbMessage = 0;
    }

    public void ecrire() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        String lettre;
        while (true) {
            nbMessage++;
            lettre = new String("\"" + nom + " numero message " + nbMessage + "\"");
            try {
                mailBox.deposerUnmessage(nom, lettre);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
