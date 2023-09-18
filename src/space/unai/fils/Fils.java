package space.unai.fils;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Fils {

    @Getter
    private static List<Hilo> threads = new ArrayList<>(); // lista de threads

    private static final int DEFAULT_TIME = 1000; // Default time,
                                                  // modificar si quieres esperar una eternidad

    public static void main(String[] args) {
        System.out.println("Hola " + Hilo.currentThread().getName()); // Prueba de inicio


        // No hacen falta guardar los hilos, se guardan automáticamente
        new Hilo("Pedro", DEFAULT_TIME);
        new Hilo("Pepe", DEFAULT_TIME);
        new Hilo("Xavi", DEFAULT_TIME);

        // Recorre la lista para que se inicie
        for (int y = 0; y < getThreads().size(); y++) {
            Hilo h = getThreads().get(y);
            h.setTiempo(h.getTiempo() * y); // Multiplica el tiempo por el iterador
            h.start();
        }
    }
}

class Hilo extends Thread {

    @Getter // Instanciar getTiempo();
    @Setter // Instanciar setTiempo(int t);
    private int tiempo;

    public Hilo(String nom, int tiempo) {
        super(nom);
        this.tiempo = tiempo; // Instanciar tiempo
        Fils.getThreads().add(this); // Añadir hilo a la lista
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
