package Test.Threads.Bal;

public class Consommateur implements Runnable{
    private String nom;
    private Bal mailBox;
    private Thread t;

    public Consommateur(String name, Bal boite) {
        nom = name;
        mailBox = boite;
    }

    public void lire() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            try {
                mailBox.lireUnMessage(nom);
                Thread.sleep((long)(Math.random() * 8000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
