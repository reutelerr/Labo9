package engine;
import engine.piece.Piece;

public class Board
{
    private Piece[][] grid;
    public Piece getSquare(int[] coord)
    {
        return grid[coord[0]][coord[1]];
    }
}
