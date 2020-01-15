package engine.piece;
import chess.PieceType;
import chess.PlayerColor;
import engine.move.Diagonal;
import engine.move.Move;

public class Bishop extends Piece
{
    public Bishop(PlayerColor color)
    {
        super(color);
    }

    static private Diagonal move = new Diagonal(-1, Move.Direction.ALL);

    public boolean move(int[] pos, int[] dest, engine.Board b)
    {
        if(Diagonal.isMoveType(pos, dest))
        {
            return verifyMove(pos, dest, b, move);
        }
        return false;
    }

    @Override
    public PieceType getType()
    {
        return PieceType.BISHOP;
    }
}
