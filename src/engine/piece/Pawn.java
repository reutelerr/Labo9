package engine.piece;
import chess.PieceType;
import chess.PlayerColor;
import engine.Board;
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

        Move.Direction forwardDirection;
        Move.Direction attackLeftDirection;
        Move.Direction attackRightDirection;

        if(this.color)
        {
            forwardDirection = Move.Direction.UP;
            attackLeftDirection = Move.Direction.UP_LEFT;
            attackRightDirection = Move.Direction.UP_RIGHT;
        }
        else
        {
            forwardDirection = Move.Direction.DOWN;
            attackLeftDirection = Move.Direction.DOWN_LEFT;
            attackRightDirection = Move.Direction.DOWN_RIGHT;
        }

        forward1 = new Straight(1, forwardDirection);
        forward2 = new Straight(2, forwardDirection);
        attackRight = new Diagonal(1, attackRightDirection);
        attackLeft = new Diagonal(1, attackLeftDirection);
    }

    //Unconditional move
    private Straight forward1;

    //Conditional moves
    private Straight forward2;
    private Diagonal attackRight;
    private Diagonal attackLeft;

    public boolean move(int[] pos, int[] dest, engine.Board b)
    {
        if(Straight.isMoveType(pos, dest) && Move.checkDestinationFree(dest, b))
        {
            if(!hasMoved)
            {
                if(verifyMove(pos, dest, b, forward2))
                {
                    b.setPassedPawn(this);
                    return true;
                }
            }
            return verifyMove(pos, dest, b, forward1);
        }
        if(Move.checkDestination(dest, b))
        {
            if(Diagonal.isMoveType(pos, dest) && Move.checkDestinationTaken(dest, b))
            {
                return verifyMove(pos, dest, b, attackRight) || verifyMove(pos, dest, b, attackLeft);
            }
            if(Move.checkDestinationFree(dest, b) && b.getSquare(new int[] {dest[0], Math.abs(dest[1]-(color ? 1 : -1))}) == b.getPassedPawn())
            {
                if(verifyMove(pos, dest, b, attackRight) || verifyMove(pos, dest, b, attackLeft))
                {
                    b.removePiece(dest[0], dest[1]-(color ? 1 : -1));
                    return true;
                }
            }
        }
        return false;
    }

    public void moveDone(int[] pos)
    {
        hasMoved = true;
    }

    @Override
    public PieceType getType()
    {
        return PieceType.PAWN;
    }
}
