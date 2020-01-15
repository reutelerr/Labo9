package engine.piece;
import chess.PieceType;
import chess.PlayerColor;
import engine.move.Diagonal;
import engine.move.Move;
import engine.move.Straight;

public class Queen extends Piece
{
    public Queen(PlayerColor color)
    {
        super(color);
    }

    private static Diagonal diagonal = new Diagonal(-1, Move.Direction.ALL);
    private static Straight straight = new Straight(-1, Move.Direction.ALL);

    public boolean move(int[] pos, int[] dest, engine.Board b)
    {
        if(Diagonal.isMoveType(pos, dest))
        {
            return verifyMove(pos, dest, b, diagonal);
        }
        if(Straight.isMoveType(pos, dest))
        {
            return verifyMove(pos, dest, b, straight);
        }
        return false;
    }

    @Override
    public PieceType getType()
    {
        return PieceType.QUEEN;
    }
}
