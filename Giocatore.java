/**
 * @see UdA n. 1: Esercitazione n. 1 - Giocanumeri
 * @author Ilyass Bouafia
 */
public class Giocatore extends Thread {
    String nome;
    private String parola;
    private int punteggio;

    /**
     * nome del Giocatore
     */
    public Giocatore(String nome) {
        this.nome = nome;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
    
    public void gioca() {
        int numero = 19;
        String parola = "staccionata";
        setParola(parola);

        for (int i = 0; i < numero; i++) {
            System.out.println("Giocatore : " + nome + " i: " + i);
            try{
                sleep(2000);
            } catch (InterruptedException e){
                System.err.println("Errore: run-sleep");
            }


        }

        setPunteggio(100);

        System.out.println("Giocatore : " + nome + " parola: " + getParola() + " punteggio: " + punteggio);
    }

    public void comunica() {
    }

    @Override
    public void run() {
        gioca();
    }
}
