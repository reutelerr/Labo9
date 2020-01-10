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

    public boolean hasMoved()
    {
        return hasMoved;
    }
}
