package engine;
import chess.ChessView;
import chess.PlayerColor;
import engine.move.Move;
import engine.piece.*;

public class Board
{
    private Game g;
    private ChessView view;
    private Piece[][] grid;

    private King whiteKing;
    private King blackKing;

    private Pawn passedPawn;

    public Piece getSquare(int[] coord)
    {
        return grid[coord[0]][coord[1]];
    }

    public Board(Game g)
    {
        whiteKing = new King(PlayerColor.WHITE, this);
        blackKing = new King(PlayerColor.BLACK, this);

        grid = new Piece[8][8];
        grid[0][0] = new Rook(PlayerColor.WHITE);
        grid[1][0] = new Knight(PlayerColor.WHITE);
        grid[2][0] = new Bishop(PlayerColor.WHITE);
        grid[3][0] = new Queen(PlayerColor.WHITE);
        grid[4][0] = whiteKing;
        grid[5][0] = new Bishop(PlayerColor.WHITE);
        grid[6][0] = new Knight(PlayerColor.WHITE);
        grid[7][0] = new Rook(PlayerColor.WHITE);

        grid[0][7] = new Rook(PlayerColor.BLACK);
        grid[1][7] = new Knight(PlayerColor.BLACK);
        grid[2][7] = new Bishop(PlayerColor.BLACK);
        grid[3][7] = new Queen(PlayerColor.BLACK);
        blackKing = new King(PlayerColor.BLACK, this);
        grid[4][7] = blackKing;
        grid[5][7] = new Bishop(PlayerColor.BLACK);
        grid[6][7] = new Knight(PlayerColor.BLACK);
        grid[7][7] = new Rook(PlayerColor.BLACK);

        for(int i = 0; i < 8; ++i){
            grid[i][1] = new Pawn(PlayerColor.WHITE);
            grid[i][6] = new Pawn(PlayerColor.BLACK);
        }

        this.g=g;
        passedPawn = null;
    }

    public Board(Game g, Piece[][] grid, King whiteKing, King blackKing, Pawn passedPawn)//Constructeur de copie pour la mise en échec
    {
        this.g = g;
        this.whiteKing = whiteKing;
        this.blackKing = blackKing;
        this.grid = grid;
        this.passedPawn = passedPawn;
    }

    public boolean check(int[] coord)
    {
        Board newBoard = new Board(g, grid, whiteKing, blackKing, passedPawn);
        for(int i=0; i<grid.length; ++i)
        {
            for(int j=0; j<grid.length; ++j)
            {
                if(grid[i][j]!=null)
                {
                    Piece piece = grid[i][j];
                    if(piece.move(new int[]{i,j}, coord, newBoard))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Board move(int posX, int posY, int destX, int destY, ChessView view)//Retourne la pièce déplacée
    {
        Piece p = grid[posX][posY];
        if(p!=null//Vérifie que la case de départ contient une pièce
                && p.getColor()==g.getActivePlayer()//Vérifie que la pièce en question appartienne au bon joueur
                && Move.checkDestination(new int[] {destX, destY}, this))
        {
            Board newBoard = new Board(g, grid, whiteKing, blackKing, passedPawn);
            p.move(new int[] {posX, posY}, new int[] {destX, destY}, newBoard);

            //On vérifie que le Roi ne soit pas en échec
            King k;
            if(g.getActivePlayer())
            {//Roi blanc
                k = whiteKing;
            }
            else
            {
                k = blackKing;
            }
            if(k.check(newBoard))//On annule le coup
            {
                return this;
            }

            p.moveDone();
            return newBoard;
        }
        return this;
    }

    public void removePiece(int posX, int posY)//Pour la prise en passant
    {
        grid[posX][posY] = null;
        view.removePiece(posX, posY);
    }

    public void doMove(int posX, int posY, int destX, int destY)
    {
        Piece p = grid[posX][posY];
        grid[destX][destY]=p;
        grid[posX][posY]=null;
        view.putPiece(p.getType(), p.getColorEnum(), destX, destY);
        view.removePiece(posX, posY);
    }

    public void setPassedPawn(Pawn p)
    {
        this.passedPawn = p;
    }

    public Pawn getPassedPawn()
    {
        return passedPawn;
    }
}
