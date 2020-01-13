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
                Diagonal.isMoveType(pos, dest) &&
                move.verifyMove(pos, dest);
        //First, we check if the destination is correct, then if the attempted move is Diagonal, finally if the move if correct
    }
}
