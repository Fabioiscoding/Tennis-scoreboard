package singh.g.tennisg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class TennisController {

    private PunteggiGiocatore g1;
    private PunteggiGiocatore g2;
    private Game game;
    private Set set;
    private Match match;

    @FXML
    private Button onGiocatore1Click;

    @FXML
    private Button onGiocatore2Click;

    @FXML
    public Button G2;
    @FXML
    public Button G1;

    @FXML
    private Label set1G1;
    @FXML
    private Label set1G2;
    @FXML
    private Label set2G1;
    @FXML
    private Label set2G2;
    @FXML
    private Label set3G1;
    @FXML
    private Label set3G2;
    @FXML
    private Label set4G1;
    @FXML
    private Label set4G2;

    @FXML
    private Label setG1;
    @FXML
    private Label setG2;

    @FXML
    private Label puntiG1;
    @FXML
    private Label puntiG2;

    @FXML
    private Label matchStatus;

    private boolean partitaFinita = false;
    private List<Label[]> labelsPerSet = List.of(
            new Label[]{set1G1, set1G2},
            new Label[]{set2G1, set2G2},
            new Label[]{set3G1, set3G2},
            new Label[]{set4G1, set4G2}
    );

    public TennisController() {
        // Inizializzazione dei giocatori, del game, del set e del match
        g1 = new PunteggiGiocatore("Luca");
        g2 = new PunteggiGiocatore("David");
        game = new Game(g1, g2);
        set = new Set(g1, g2);
        match = new Match(g1, g2); // Match al meglio di 5 set
    }

    @FXML
    public void onGiocatore1Click(ActionEvent actionEvent) {
        if (!partitaFinita) {
            game.aggiungiPunteggio(g1);
            aggiorna();
        }

    }

    @FXML
    public void onGiocatore2Click(ActionEvent actionEvent) {
        if (!partitaFinita) {
            game.aggiungiPunteggio(g2);
            aggiorna();
        }

    }


    private void aggiorna() {
        String statoGame = game.getPunteggio();

        if (statoGame.contains("ha vinto la partita")) {
            PunteggiGiocatore vincitoreGame = statoGame.startsWith(g1.getNome()) ? g1 : g2;
            set.aggiungiVittoria(vincitoreGame);
            game.resetta();
        }

        setG1.setText(set.getPunteggio().split(" - ")[0]);
        setG2.setText(set.getPunteggio().split(" - ")[1]);

        if (set.isSetFinito()) {
            PunteggiGiocatore vincitoreSet = set.getSetVincitore();
            match.aggiungiSetVinto(vincitoreSet, set);
            set = new Set(g1, g2);

            if (match.isMatchFinito()) {
                PunteggiGiocatore vincitoreMatch = match.getMatchVincitore();
                partitaFinita = true;
                matchStatus.setText("Match vinto da: " + vincitoreMatch.getNome());
                return; // Evita ulteriori aggiornamenti
            } else {
                matchStatus.setText("Set vinto da: " + vincitoreSet.getNome());
            }
        } else {
            matchStatus.setText("Match in corso");
        }

        aggiornaSetCompletati();

        puntiG1.setText(String.valueOf(game.punteggiTennis(g1.getPunteggiGiocatore())));
        puntiG2.setText(String.valueOf(game.punteggiTennis(g2.getPunteggiGiocatore())));
    }


    private void aggiornaSetCompletati() {
        List<Label[]> labelsPerSet = List.of(
                new Label[]{set1G1, set1G2},
                new Label[]{set2G1, set2G2},
                new Label[]{set3G1, set3G2},
                new Label[]{set4G1, set4G2}
        );

        for (int i = 0; i < match.getSetCompletati().size(); i++) {
            Set set = match.getSetCompletati().get(i);
            String[] punteggi = set.getPunteggio().split(" - ");
            labelsPerSet.get(i)[0].setText(punteggi[0]);
            labelsPerSet.get(i)[1].setText(punteggi[1]);

        }
    }

    public void resettaTutto() {
        for (Label[] setLabels : labelsPerSet) {
            setLabels[0].setText("0");
            setLabels[1].setText("0");
        }
        g1.resetPunteggio();
        g2.resetPunteggio();
        game.resetta();
        set = new Set(g1, g2);
        match = new Match(g1, g2);
        partitaFinita = false;
        matchStatus.setText("Match resettato");
        aggiorna();
    }


    public void ResetClick(ActionEvent actionEvent) {
        resettaTutto();
    }
}
