package launcher;
import chess.ChessController;
import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;
import chess.views.gui.GUIView;
import engine.Game;

public class Main {
    public static void main(String[] args) {

        // 1. Création du contrôleur pour gérer le jeu d’échec
        ChessController controller = new Game(); // Instancier un ChessController
        // 2. Création de la vue
        ChessView view = new GUIView(controller); // mode GUI
        // ChessView view = new ConsoleView(controller);
        // = new ConsoleView(controller); // mode Console
        // 3 . Lancement du programme.
        controller.start(view);
        view.startView();

    }
}
