package Test.Threads.Voiture;

import java.util.*;

public class Voiture implements Runnable{
    public static final int TEMPORISATION = 1000;
    public final int capaciteReservoir = 50;
    public final double consommation = 5;
    protected double essence;
    protected boolean roule;

    private String nom;
    private Thread t;

    public Voiture(String nom) {
        this.essence = capaciteReservoir;
        this.roule = false;
        this.nom = nom;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Le vehicule " + this.nom);
        if (this.roule == false) {
            sb.append(" est a l'arret.");
        } else {
            sb.append(" roule encore.");
        }
        sb.append(" Il reste ");
        sb.append(this.essence);
        sb.append(" litres d'essences dans son reservoir. \n");
        return sb.toString();
    }

    public void stopper() {
        this.roule = false;
    }

    public void rouler() {
        t = new Thread(this);
        t.start();;
    }

    public void run() {
        this.roule = true;
        System.out.println("Le vehicule " + this.nom + " demarre.");
        while (this.roule && this.essence > 0) {
            this.essence -= this.consommation;
            try {
                Thread.sleep(2 * Voiture.TEMPORISATION);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(this);
        }
        System.out.println(this.nom + " s'arrete...");
    }

    public static void main(String[] args) {
        ArrayList<Voiture> setVoiture = new ArrayList<>();
        setVoiture.add(new Voiture("Peugeot 104"));
        setVoiture.add(new Voiture("Renault 4L"));
        setVoiture.add(new Voiture("Ford T"));
        setVoiture.add(new Voiture("VW Beetle"));
        setVoiture.add(new Voiture("Mustang Shelby"));

        Iterator<Voiture> itV = setVoiture.iterator();
        while (itV.hasNext()) {
            itV.next().rouler();
        }
        try {
            Thread.sleep(10 * Voiture.TEMPORISATION);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Iterator<Voiture> itV1 = setVoiture.iterator();
        while (itV1.hasNext()) {
            itV1.next().stopper();;
        }
    }
}
