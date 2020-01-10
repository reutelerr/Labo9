package engine.piece;

import engine.move.Move;
import engine.move.Straight;
import engine.move.Diagonal;

public class Pawn extends Piece
{
    Pawn(boolean color)
    {
        super(color);
        Move forward1;
    }

    //Unconditional move
    private static Straight forward1 = new Straight(1, Move.Direction.UP);

    //Conditional moves
    private static Straight forward2 = new Straight(2, Move.Direction.UP);
    private static Diagonal attackRight = new Diagonal(1, Move.Direction.UP_RIGHT);
    private static Diagonal attackLeft = new Diagonal(1, Move.Direction.UP_LEFT);
}
