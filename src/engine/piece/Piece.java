package engine.piece;
import chess.PlayerColor;

public abstract class Piece
{
    protected boolean color;//true = white, false = black

    Piece(boolean color)
    {
        this.color = color;
    }

    public abstract boolean move(int[] pos, int[] dest);
    public boolean hasMoved()
    {
        return false;
    }

    public chess.PieceType getType()
    {
        return null;
    }

    public boolean getColor()
    {
        return color;
    }

    public PlayerColor getColorEnum()
    {
        if(color)
        {
            return PlayerColor.WHITE;
        }
        else
        {
            return PlayerColor.BLACK;
        }
    }

    public void moveDone(){}//It's redefined by Kings, Rooks and Pawns
}
