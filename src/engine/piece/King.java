package engine.piece;
import engine.move.Diagonal;
import engine.move.Straight;
import engine.move.Move;

public class King extends Piece
{
    King(boolean color)
    {
        super(color);
        moves = new Move[]{
                new Diagonal(1, Move.Direction.ALL),
                new Straight(1, Move.Direction.ALL)
        };
    }

    //Conditional moves
    Straight rightCastle = new Straight(2, Move.Direction.RIGHT);
    Straight leftCastle = new Straight(3, Move.Direction.LEFT);
}
