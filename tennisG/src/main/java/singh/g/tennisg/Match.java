package singh.g.tennisg;
import java.util.ArrayList;
import java.util.List;

public class Match {
    private PunteggiGiocatore g1;
    private PunteggiGiocatore g2;
    private int vittorieG1;
    private int vittorieG2;
    private final int nSet;
    private List<Set> setCompletati; // Lista per salvare i set completati

    public Match(PunteggiGiocatore g1, PunteggiGiocatore g2) {
        this.g1 = g1;
        this.g2 = g2;
        this.nSet = 5;
        this.vittorieG1 = 0;
        this.vittorieG2 = 0;
        this.setCompletati = new ArrayList<>();
    }

    public void aggiungiSetVinto(PunteggiGiocatore giocatore, Set set) {
        if (isMatchFinito()) {
            throw new IllegalStateException("Il match è già terminato");
        }

        if (giocatore == g1) {
            vittorieG1++;
        } else if (giocatore == g2) {
            vittorieG2++;
        } else {
            throw new IllegalArgumentException("Giocatore non valido");
        }

        setCompletati.add(set);
    }


    public boolean isMatchFinito() {
        int setDaVincere = (nSet / 2) + 1;
        return vittorieG1 >= setDaVincere || vittorieG2 >= setDaVincere;
    }

    public PunteggiGiocatore getMatchVincitore() {
        if (isMatchFinito()) {
            return vittorieG1 > vittorieG2 ? g1 : g2;
        }
        return null;
    }

    public List<Set> getSetCompletati() {
        return setCompletati;
    }
}
