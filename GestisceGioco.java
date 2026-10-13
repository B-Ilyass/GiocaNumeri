import java.util.Random;
import java.util.Scanner;

public class GestisceGioco {
    int numeroVincente;
    Scanner sc = new Scanner(System.in);

    public GestisceGioco() {
        numeroVincente = new Random().nextInt(10) + 1;
    }

    public int leggiNumeroGiocatori() {
        while (true) {
            System.out.print("Quanti giocatori? ");
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= 1) {
                    return n;
                }
                // punto 5: errore su standard error
                System.err.println("Errore: serve almeno 1 giocatore");
            } catch (NumberFormatException e) {
                // punto 5: errore su standard error
                System.err.println("Errore: non è un numero");
            }
        }
    }

    public synchronized int leggiNumero(String nome) {
        while (true) {
            System.out.print(nome + ", inserisci un numero da 1 a 10: ");
            try {
                int x = Integer.parseInt(sc.nextLine());
                if (x >= 1 && x <= 10) {
                    return x;
                }
                // punto 5: errore su standard error
                System.err.println("Errore: numero fuori range");
            } catch (NumberFormatException e) {
                // punto 5: errore su standard error
                System.err.println("Errore: non è un numero");
            }
        }
    }

    public synchronized String leggiParola(String nome) {
        while (true) {
            System.out.print(nome + ", inserisci una parola: ");
            String p = sc.nextLine();
            if (!p.isEmpty()) {
                return p;
            }
            // punto 5: errore su standard error
            System.err.println("Errore: parola vuota");
        }
    }

    public int calcolaPunteggio(int numero, String parola) {
        int punti = parola.length();
        if (numero == numeroVincente) {
            punti += 10;
        }
        return punti;
    }
}
