package engine.piece;
import engine.move.Move;

public abstract class Piece
{
    public boolean color;//true = white, false = black

    Piece(boolean color)
    {
        this.color = color;
    }

    public boolean verifyMove(Move move, int[] pos, int[] dest)//returns true if move is valid, false otherwise
    {
        return move.isMoveType(pos, dest) && move.verifyMove(pos, dest);
    }

    public abstract boolean move(int[] pos, int[] dest);
}
