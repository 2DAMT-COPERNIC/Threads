package space.unai.fils;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Fils {

    @Getter
    private static List<Hilo> threads = new ArrayList<>();

    private static int DEFAULT_TIME = 1000;

    public static void main(String[] args) {
        System.out.println("Hola " + Hilo.currentThread().getName());

        Hilo t1 = new Hilo("Pedro", DEFAULT_TIME);
        Hilo t2 = new Hilo("Pepe", DEFAULT_TIME);
        Hilo t3 = new Hilo("Xavi", DEFAULT_TIME);

        for (int y = 0; y < getThreads().size(); y++) {
            Hilo h = getThreads().get(y);
            h.setTiempo(h.getTiempo() * y);
            h.start();
        }
    }
}

class Hilo extends Thread {

    @Getter
    @Setter
    private int tiempo;

    public Hilo(String nom, int tiempo) {
        super(nom);
        this.tiempo = tiempo;
        Fils.getThreads().add(this);
    }


    @SneakyThrows
    @Override
    public void run() {
        System.out.println("[" + this.getName() + "] starts");
        wait(tiempo);
        System.out.println("[" + this.getName() + "] ends");
    }

    public void wait(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
