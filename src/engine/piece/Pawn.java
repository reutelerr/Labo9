package engine.piece;

import engine.move.Move;
import engine.move.Straight;
import engine.move.Diagonal;

public class Pawn extends Piece
{
    private boolean hasMoved;//Used to indicate if the pawn can go forward 2 squares

    Pawn(boolean color)
    {
        super(color);
        Move forward1;
        hasMoved = false;
    }

    //Unconditional move
    private static Straight forward1 = new Straight(1, Move.Direction.UP);

    //Conditional moves
    private static Straight forward2 = new Straight(2, Move.Direction.UP);
    private static Diagonal attackRight = new Diagonal(1, Move.Direction.UP_RIGHT);
    private static Diagonal attackLeft = new Diagonal(1, Move.Direction.UP_LEFT);

    public boolean move(int[] pos, int[] dest)
    {
        if(Move.checkDestination(dest))
        {
            if(Straight.isMoveType(pos, dest) && Move.checkDestinationFree(dest))
            {
                if(!hasMoved && forward2.verifyMove(pos, dest))
                {
                    return true;
                }
                return forward1.verifyMove(pos, dest);
            }
            if(Diagonal.isMoveType(pos, dest) && Move.checkDestinationTaken(dest))
            {
                if(attackRight.verifyMove(pos, dest))
                {
                    return true;
                }
                return attackLeft.verifyMove(pos, dest);
            }
        }
        return false;
    }

    public void moveDone()
    {
        hasMoved = true;
    }
}
