public class GiocaNumeri {
    public static void main(String[] args) {
        System.out.println("GIOCHIAMO!!!");
        GestisceGioco gioco = new GestisceGioco();
        int n = gioco.leggiNumeroGiocatori();

        Giocatore[] giocatori = new Giocatore[n];
        for (int i = 0; i < n; i++) {
            giocatori[i] = new Giocatore("Giocatore" + (i + 1), gioco);
        }

        for (int i = 0; i < n; i++) {
            giocatori[i].start();
            if (i == 0) {
                // punto 8: sospensione di 5 secondi dopo l'avvio del primo thread
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // punto 5: errore
                    System.err.println("Errore: sleep interrotto");
                }
            }
        }

        // punto 11: join
        for (int i = 0; i < n; i++) {
            try {
                giocatori[i].join();
            } catch (InterruptedException e) {
                // punto 5: errore su standard error
                System.err.println("Errore: join interrotto");
            }
        }
        System.out.println("====PER IL GRAN FINALE====");
        // continua .... 
        System.out.println("FINITO IL GIOCO BRAWO");
    }
}
