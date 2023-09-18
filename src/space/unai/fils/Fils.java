package space.unai.fils;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.logging.Logger;

public class Fils {

    public static void main(String[] args) {
        Thread thread = new Hilo1("Pedro");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        Thread thread2 = new Hilo1("Pepe");
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();

    }
}

class Hilo1 extends Thread {

    @Getter
    @Setter
    private String nom;

    public Hilo1(String nom) {
        this.nom = nom;
    }


    @SneakyThrows
    @Override
    public void run() {
        System.out.println("[" + nom + "] starts");
        wait(2000);
        System.out.println("[" + nom + "] ends");
    }

    public static void wait(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
