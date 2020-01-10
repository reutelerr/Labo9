package engine.piece;
import engine.move.Diagonal;
import engine.move.Move;

public class Bishop extends Piece
{
    Bishop(boolean color)
    {
        super(color);
    }

    static private Diagonal move = new Diagonal(-1, Move.Direction.ALL);

    public boolean move(int[] pos, int[] dest)
    {
        return Move.checkDestination(dest) &&
                verifyMove(move, pos, dest);
        
    }
}
