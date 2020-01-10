package engine.piece;
import engine.move.Diagonal;
import engine.move.Straight;
import engine.move.Move;

public class King extends Piece {

    private boolean hasMoved;
    private int[] coord;

    King(boolean color)
    {
        super(color);
        if(color)
        {
            coord = new int[] {0, 4};
        }
    }

    private static Diagonal diagonal = new Diagonal(1, Move.Direction.ALL);
    private static Straight straight = new Straight(1, Move.Direction.ALL);

    //Conditional moves
    private static Straight rightCastle = new Straight(2, Move.Direction.RIGHT);;
    private static Straight leftCastle = new Straight(3, Move.Direction.LEFT);

    public boolean check(engine.Board b)
    {
        return b.check(coord);
    }
}
