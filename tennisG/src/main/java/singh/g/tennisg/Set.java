package singh.g.tennisg;

public class Set {
    private PunteggiGiocatore g1;
    private PunteggiGiocatore g2;
    private int vittorieG1;
    private int vittorieG2;

    public Set(PunteggiGiocatore g1, PunteggiGiocatore g2) {
        this.g1 = g1;
        this.g2 = g2;
        this.vittorieG1 = 0;
        this.vittorieG2 = 0;
    }

    public void aggiungiVittoria(PunteggiGiocatore player) {
        if (player == g1) {
            vittorieG1++;
        } else if (player == g2) {
            vittorieG2++;
        } else {
            throw new IllegalArgumentException("Giocatore non valido");
        }

        // Controllo se il set è finito subito dopo l'aggiornamento
        if (isSetFinito() && getSetVincitore() == null) {
            throw new IllegalStateException("Errore nella determinazione del vincitore del set");
        }
    }


    public boolean isSetFinito() {
        return (vittorieG1 >= 6 && vittorieG1 >= vittorieG2 + 2) ||
                (vittorieG2 >= 6 && vittorieG2 >= vittorieG1 + 2);
    }

    public String getPunteggio() {
        return vittorieG1 + " - " + vittorieG2;
    }

    public PunteggiGiocatore getSetVincitore() {
        if (isSetFinito()) {
            return vittorieG1 > vittorieG2 ? g1 : g2;
        }
        return null;
    }
}
