# Tennis-scoreboard
Tennis Scoreboard è un'applicazione Java sviluppata con JavaFX per gestire e monitorare i punteggi di una oartita di tennis.
Questo progetto simula un match di tennis, gestendo game, set e match in base alle regole ufficiali.

---


## Caratteristiche:

Gestione dei punteggi per i singoli game, set e match.
Interfaccia grafica interattiva basata su JavaFX (con scenebuilder).
Sistema di aggiornamento automatico del punteggio e stato del match.
Resetta il match per iniziare una nuova partita.
Supporto per partite al meglio di 5 set.

---


## Requisiti:

Java 17 o versioni successive
JavaFX 17 o versioni successive
Un ambiente di sviluppo come IntelliJ IDEA, Eclipse o Visual Studio Code

---


## Come eseguire il Progetto:

1. Clona il repository:
   ```bash
   git clone https://github.com/tuo-username/tennis-match-tracker.git
   ```
2. Importa il progetto nel tuo IDE.
3. Configura JavaFX aggiungendo il seguente argomento alla VM:
   ```bash
   --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
   ```
   **Nota:** Sostituisci `/path/to/javafx-sdk/lib` con il percorso effettivo della libreria JavaFX sul tuo sistema.
4. Esegui il file `TennisApplication.java` per avviare l'app.

---


## Struttura del progetto:

TennisController: Gestisce la logica dell'interfaccia utente e gli eventi.
Game: Implementa la logica di un singolo game.
Set: Gestisce i set, le vittorie e i punteggi.
Match: Tiene traccia dell'intero match e determina il vincitore.
PunteggiGiocatore: Modella un giocatore e il suo punteggio.

## Contatti

Per domande o suggerimenti, contattami a:  
**Gurjinder07italy@gmail.com**  
