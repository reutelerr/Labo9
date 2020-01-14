package engine.piece;
import chess.PlayerColor;

public abstract class Piece
{
    protected boolean color;//true = white, false = black

    public Piece(PlayerColor color)
    {
        if(color == PlayerColor.WHITE)
        {
            this.color = true;
        }
        else
        {
            this.color = false;
        }

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
