package engine.piece;

import engine.move.Move;
import engine.move.Straight;
import engine.move.Diagonal;

public class Pawn extends Piece
{
    Pawn(boolean color)
    {
        super(color);
        moves = new Move[]{
                new Straight(1, Move.Direction.ALL)
        };
    }

    //Conditional moves
    Straight forward2 = new Straight(2, Move.Direction.UP);
    Diagonal attackLeft = new Diagonal(1, Move.Direction.UP_LEFT);
    Diagonal attackRight = new Diagonal(1, Move.Direction.UP_RIGHT);
}
