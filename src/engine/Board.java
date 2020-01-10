package engine;
import engine.piece.Piece;

public class Board
{
    private Piece[][] grid;
    public Piece getSquare(int[] coord)
    {
        return grid[coord[0]][coord[1]];
    }

    public boolean check(int[] coord)
    {
        for(int i=0; i<grid.length; ++i)
        {
            for(int j=0; j<grid.length; ++j)
            {
                if(grid[i][j]!=null)
                {
                    Piece piece = grid[i][j];
                    if(piece.move(new int[]{i,j}, coord))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
