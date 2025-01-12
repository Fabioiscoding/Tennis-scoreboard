package singh.g.tennisg;

public class Game {
    private PunteggiGiocatore g1;
    private PunteggiGiocatore g2;
    public Game(PunteggiGiocatore p1, PunteggiGiocatore p2) {
        this.g1 = p1;
        this.g2 = p2;
    }
    public String punteggiTennis(int punti) {
        return switch (punti) {
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            case 4 -> "adv";
            default -> "0";
        };
    }

    public String getPunteggio() {
        int p1 = g1.getPunteggiGiocatore();
        int p2 = g2.getPunteggiGiocatore();

        if (p1 >= 4 && p1 >= p2 + 2) {
            return g1.getNome() + " ha vinto la partita";
        } else if (p2 >= 4 && p2 >= p1 + 2) {
            return g2.getNome() + " ha vinto la partita";
        } else if (p1 > 3 && p2 > 3) {
            if (p1 == p2) {
                g1.rimuoviPunteggio();
                g2.rimuoviPunteggio();
                return "deuce";
            } else if (p1 > p2) {
                return g1.getNome() + " è in vantaggio";
            } else {
                return g2.getNome() + " è in vantaggio";
            }
        } else {
            return punteggiTennis(p1) + " - " + punteggiTennis(p2);
        }
    }

    public void aggiungiPunteggio(PunteggiGiocatore giocatore) {
        giocatore.aggiungiPunteggio();
    }

    public void resetta() {
        g1.resetPunteggio();
        g2.resetPunteggio();
    }
}