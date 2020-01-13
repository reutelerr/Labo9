package engine.piece;
import engine.move.Move;
import engine.Board;

public abstract class Piece
{
    public boolean color;//true = white, false = black

    Piece(boolean color)
    {
        this.color = color;
    }

    public abstract boolean move(int[] pos, int[] dest);
    public boolean hasMoved()
    {
        return false;
    }

    public void moveDone(){}//It's redefined by Kings, Rooks and Pawns
}
