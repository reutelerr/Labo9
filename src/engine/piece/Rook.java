package engine.piece;

import engine.move.Move;
import engine.move.Straight;

public class Rook extends Piece
{
    Rook(boolean color)
    {
        super(color);
        moves = new Move[]{
                new Straight(-1, Move.Direction.ALL)
        };
    }
}
