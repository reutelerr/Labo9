package engine.piece;

import engine.move.Diagonal;
import engine.move.Move;
import engine.move.Straight;

public class Queen extends Piece
{
    Queen(boolean color)
    {
        super(color);
    }

    private static Diagonal diagonal = new Diagonal(-1, Move.Direction.ALL);
    private static Straight straight = new Straight(-1, Move.Direction.ALL);

    public boolean move(int[] pos, int[] dest)
    {
        if(Diagonal.isMoveType(pos, dest))
        {
            return diagonal.verifyMove(pos, dest);
        }
        if(Straight.isMoveType(pos, dest))
        {
            return straight.verifyMove(pos, dest);
        }
        return false;
    }
}
