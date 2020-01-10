package engine.piece;

import engine.move.Diagonal;
import engine.move.Move;
import engine.move.Straight;

public class Queen extends Piece
{
    Queen(boolean color)
    {
        super(color);
        moves = new Move[]{
                new Diagonal(-1, Move.Direction.ALL),
                new Straight(-1, Move.Direction.ALL)
        };
    }
}
