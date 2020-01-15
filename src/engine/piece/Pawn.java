package engine.piece;
import chess.PieceType;
import chess.PlayerColor;
import engine.move.Move;
import engine.move.Straight;
import engine.move.Diagonal;

public class Pawn extends Piece
{
    private boolean hasMoved;//Used to indicate if the pawn can go forward 2 squares

    public Pawn(PlayerColor color)
    {
        super(color);
        hasMoved = false;
    }

    //Unconditional move
    private static Straight forward1 = new Straight(1, Move.Direction.UP);

    //Conditional moves
    private static Straight forward2 = new Straight(2, Move.Direction.UP);
    private static Diagonal attackRight = new Diagonal(1, Move.Direction.UP_RIGHT);
    private static Diagonal attackLeft = new Diagonal(1, Move.Direction.UP_LEFT);

    public boolean move(int[] pos, int[] dest, engine.Board b)
    {
        if(Straight.isMoveType(pos, dest) && Move.checkDestinationFree(dest, b))
        {
            if(!hasMoved)
            {
                if(super.verifyMove(pos, dest, b, forward2))
                {
                    b.setPassedPawn(this);
                    return true;
                }
            }
            return super.verifyMove(pos, dest, b, forward1);
        }
        if(Move.checkDestination(dest, b))
        {
            if(Diagonal.isMoveType(pos, dest) && Move.checkDestinationTaken(dest, b) ||
                    Move.checkDestinationFree(dest, b) &&
                            b.getSquare(new int[] {dest[0], dest[1]-1}) == b.getPassedPawn())
            {
                return super.verifyMove(pos, dest, b, attackRight) || super.verifyMove(pos, dest, b, attackLeft);
            }
        }
        return false;
    }

    public void moveDone()
    {
        hasMoved = true;
    }

    @Override
    public PieceType getType()
    {
        return PieceType.PAWN;
    }
}
