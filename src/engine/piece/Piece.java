package engine.piece;
import engine.move.Move;

public abstract class Piece
{
    public boolean color;//true = white, false = black
    protected Move[] moves;//unconditional moves : the conditional ones will be stored and treated separately

    Piece(boolean color)
    {
        this.color = color;
    }

    public boolean move(int[] pos, int[] dest)//returns true if move is valid, false otherwise
    {
        for(Move move : moves)//goes through the list of unconditional moves
        {
            if(move.isMoveType(pos, dest))
            {
                return move.verifyMove(pos, dest);
            }
        }
        return false;
    }
}
