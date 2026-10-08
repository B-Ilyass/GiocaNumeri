public class Main {
    public static void main(String[] args) {
        System.out.println("START");

        Giocatore g1 = new Giocatore("Simone");
        Giocatore g2 = new Giocatore("Paolo");

        // Li avvii subito entrambi
        g1.start();
        g2.start();

        // Attendi che entrambi finiscano
        try {
            g1.join();
            g2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Endgame");
    }
}