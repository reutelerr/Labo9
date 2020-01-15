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

    public abstract boolean move(int[] pos, int[] dest, engine.Board b);

    public boolean verifyMove(int[]pos, int[] dest, engine.Board b, engine.move.Move m)
    {
        if(m.verifyMove(pos, dest, b))
        {
            b.doMove(pos[0], pos[1], dest[0], dest[1]);
            return true;
        }
        return false;
    }

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

    public void moveDone(int[] pos){}//It's redefined by Kings, Rooks and Pawns
}
