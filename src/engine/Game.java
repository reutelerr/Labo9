package engine;
import chess.ChessView;
import chess.PlayerColor;
import engine.move.Move;
import engine.piece.Piece;
import engine.piece.*;

public class Game implements chess.ChessController
{
    private chess.ChessView view;
    private Board b;

    public Game()
    {
        activePlayer = true;//White starts
        b = new Board(this);
    }

    public ChessView getView()
    {
        return view;
    }

    public boolean checkMate()
    {
        /* TODO :
        1. On vérifie si le roi peut bouger sur une case adjacente
        2. On établit la liste des pièces menaçant le roi
        3. Si il n'y a qu'une pièce menaçant le roi, on vérifie si on peut la "manger" (pour toutes le pièces du camp en échec)
        4. Si la pièce ennemie est une reine, une tour ou un fou, on vérifie pour toutes les pièces si elles peuvent se mettre dans le chemin
         */
        return false;
    }

    private boolean activePlayer;

    private void init(){
        Move.init(this);
    }

    @Override
    public void start(ChessView view)
    {
        init();

        for(int i = 0; i < 8; ++i)
        {
            for(int j=0; j < 8; ++j)
            {
                Piece square = b.getSquare(new int[] {i, j});
                if(square!=null)
                {
                    view.putPiece(square.getType(), square.getColorEnum(), i, j);
                }
            }
        }

        this.view = view;
    }

    @Override
    public void newGame() {

    }

    public boolean move(int posX, int posY, int destX, int destY)
    {
        Board newB = b.move(posX, posY, destX, destY);
        if(newB == b)
        {
            display();
            return false;
        }
        else
        {
            b = newB;
            activePlayer = !activePlayer;
            display();
            return true;
        }
    }

    public void display()
    {
        for(int i = 0; i < 8; ++i)
        {
            for(int j = 0; j < 8; ++j){
                Piece p = b.getSquare(new int[] {i,j});
                if(p!=null)
                {
                    view.putPiece(p.getType(), p.getColorEnum(), i, j);
                }
                else
                {
                    view.removePiece(i, j);
                }
            }
        }
    }

    public boolean getActivePlayer()
    {
        return activePlayer;
    }
}
