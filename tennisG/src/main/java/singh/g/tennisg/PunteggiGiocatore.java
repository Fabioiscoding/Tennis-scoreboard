package singh.g.tennisg;

public class PunteggiGiocatore {
    private int punteggiGiocatore;
    private String nome;

    public PunteggiGiocatore(String nome) {
        this.nome = nome;
        this.punteggiGiocatore = 0;
    }

    public void aggiungiPunteggio() {
        punteggiGiocatore++;
    }

    public void rimuoviPunteggio() {
        punteggiGiocatore--;
    }

    public int getPunteggiGiocatore() {
        return punteggiGiocatore;
    }

    public void resetPunteggio() {
        punteggiGiocatore = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
