package engine.piece;
import chess.PieceType;
import chess.PlayerColor;
import engine.move.Move;
import engine.move.L;

public class Knight extends Piece
{
    public Knight(PlayerColor color)
    {
        super(color);
    }

    private static Move move = new L();

    public boolean move(int[] pos, int[] dest)
    {
        return move.checkDestination(dest) &&
                L.isMoveType(pos, dest) &&
                move.verifyMove(pos, dest);
        //First, we check if the destination is correct, then if the attempted move is Diagonal, finally if the move if correct
    }

    @Override
    public PieceType getType() {
        return PieceType.KNIGHT;
    }
}
