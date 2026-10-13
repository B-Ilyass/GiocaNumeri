/*
* Esercitazione 1: GiocaNumeri
* @author Ilyass Bouafia
* */

public class Giocatore extends Thread {
    String nome;
    GestisceGioco g;

    public Giocatore(String nome, GestisceGioco g) {
        this.nome = nome;
        this.g = g;
    }

    @Override
    public void run() {
        int numero;
        String parola;

        synchronized (g) {
            numero = g.leggiNumero(nome);
            parola = g.leggiParola(nome);
        }

        for (int i = 1; i <= numero; i++) {
            System.out.println(nome + " conta: " + i);
            // punto 13: yield
            Thread.yield();
        }

        System.out.println(nome + " parola: " + parola.toUpperCase());

        // punto 4: sospensione di 2 secondi
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // punto 5: errore
            System.err.println("Errore: sleep interrotto");
        }

        int punteggio = g.calcolaPunteggio(numero, parola);
        System.out.println(nome + " numero scelto: " + numero + ", punteggio: " + punteggio);
    }
}
