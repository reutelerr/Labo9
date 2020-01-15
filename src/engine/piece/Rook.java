package engine.piece;
import chess.PieceType;
import chess.PlayerColor;
import engine.move.Move;
import engine.move.Straight;

public class Rook extends Piece
{
    private boolean hasMoved;

    public Rook(PlayerColor color)
    {
        super(color);
    }

    private static Straight move = new Straight(-1, Move.Direction.ALL);

    public boolean move(int[] pos, int[] dest, engine.Board b)
    {
        //First, we check if the destination is correct, then if the attempted move is Straight, finally
        //if the move if correct
        if(Straight.isMoveType(pos, dest))
        {
            return super.verifyMove(pos, dest, b, move);
        }
        return false;
    }

    public boolean hasMoved()
    {
        return true;
    }

    @Override
    public PieceType getType()
    {
        return PieceType.ROOK;
    }
}
