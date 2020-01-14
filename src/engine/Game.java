package engine;
import chess.ChessView;
import chess.PlayerColor;
import engine.move.Move;
import engine.piece.Piece;
import engine.piece.*;

public class Game implements chess.ChessController
{
    private chess.ChessView view;

    public Game()
    {
        activePlayer = true;//White starts
    }

    private boolean activePlayer;

    private Piece[][] grid;

    void init(){

        grid = new Piece[8][8];
        grid[0][0] = new Rook(PlayerColor.WHITE);
        grid[1][0] = new Knight(PlayerColor.WHITE);
        grid[2][0] = new Bishop(PlayerColor.WHITE);
        grid[3][0] = new Queen(PlayerColor.WHITE);
        grid[4][0] = new King(PlayerColor.WHITE, this);
        grid[5][0] = new Bishop(PlayerColor.WHITE);
        grid[6][0] = new Knight(PlayerColor.WHITE);
        grid[7][0] = new Rook(PlayerColor.WHITE);

        grid[0][7] = new Rook(PlayerColor.BLACK);
        grid[1][7] = new Knight(PlayerColor.BLACK);
        grid[2][7] = new Bishop(PlayerColor.BLACK);
        grid[3][7] = new Queen(PlayerColor.BLACK);
        grid[4][7] = new King(PlayerColor.BLACK, this);
        grid[5][7] = new Bishop(PlayerColor.BLACK);
        grid[6][7] = new Knight(PlayerColor.BLACK);
        grid[7][7] = new Rook(PlayerColor.BLACK);

        for(int i = 0; i < 8; ++i){
            grid[i][1] = new Pawn(PlayerColor.WHITE);
            grid[i][6] = new Pawn(PlayerColor.BLACK);
        }

        Move.init(this);

    }

    @Override
    public void start(ChessView view) {

        init();

        for(int i = 0; i < 8; ++i){
            view.putPiece(grid[i][0].getType() , grid[i][0].getColorEnum(), i,0);
            view.putPiece(grid[i][1].getType() , grid[i][1].getColorEnum(), i,1);
            view.putPiece(grid[i][6].getType() , grid[i][6].getColorEnum(), i,6);
            view.putPiece(grid[i][7].getType() , grid[i][7].getColorEnum(), i,7);
        }

        this.view = view;
    }

    @Override
    public void newGame() {

    }

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

    public boolean move(int posX, int posY, int destX, int destY)
    {
        if(grid[posX][posY]!=null//Vérifie que la case de départ contient une pièce
                && grid[posX][posY].getColor()==getActivePlayer()//Vérifie que la pièce en question appartienne au bon joueur
                && grid[posX][posY].move(new int[] {posX, posY}, new int[] {destX, destY}))//Vérifie que le mouvement est valide
        {
            forceMove(posX, posY, destX, destY);
            return true;
        }
        return false;
    }

    public void forceMove(int posX, int posY, int destX, int destY)
    {
        Piece piece = grid[posX][posY];
        grid[destX][destY]=piece;
        view.putPiece(piece.getType(), piece.getColorEnum(), destX, destY);
        grid[posX][posY]=null;
        view.removePiece(posX, posY);
        piece.moveDone();
    }

    public boolean getActivePlayer()
    {
        return activePlayer;
    }
}
