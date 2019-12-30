package engine.piece;
import engine.move.Move;

public abstract class Piece
{
    public boolean color;//true = white, false = black
    private Move[] moves;

    public boolean move(int[] pos, int[] dest)//returns true if move is valid, false otherwise
    {
        for(Move move : moves)
        {
            if(move.verifyMove(pos, dest))
            {
                return true;
            }
        }
        return false;
    }
}
