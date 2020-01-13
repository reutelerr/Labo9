package engine;
import engine.piece.Piece;

public class Game
{
    private boolean activePlayer;

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

    public void move(int posX, int posY, int destX, int destY)
    {
        if(grid[posX][posY]!=null && grid[posX][posY].move(new int[] {posX, posY}, new int[] {destX, destY}))
        {
            grid[destX][destY]=grid[posX][posY];
            grid[posX][posY]=null;
        }
    }

    public boolean getActivePlayer()
    {
        return activePlayer;
    }
}
