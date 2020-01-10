package engine.piece;
import engine.move.Diagonal;
import engine.move.Move;

public class Bishop extends Piece
{
    Bishop(boolean color)
    {
        super(color);
        moves = new Move[]{new Diagonal(-1, Move.Direction.ALL)};
    }
}
