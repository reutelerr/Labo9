package engine.piece;

import engine.move.Move;
import engine.move.L;

public class Knight extends Piece
{
    Knight(boolean color)
    {
        super(color);
    }

    private static Move move = new L();
}
