package engine.piece;

import engine.move.Move;
import engine.move.Straight;

public class Rook extends Piece
{
    private boolean hasMoved;

    Rook(boolean color)
    {
        super(color);
    }

    private static Straight move = new Straight(-1, Move.Direction.ALL);

    public boolean move(int[] pos, int[] dest)
    {
        return Move.checkDestination(dest) &&
                Straight.isMoveType(pos, dest) &&
                move.verifyMove(pos, dest);
        //First, we check if the destination is correct, then if the attempted move is Straight, finally if the move if correct
    }

    public boolean hasMoved()
    {
        return true;
    }
}
