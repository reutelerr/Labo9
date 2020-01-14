package engine.piece;
import chess.PieceType;
import chess.PlayerColor;
import engine.move.Diagonal;
import engine.move.Straight;
import engine.move.Castle;
import engine.move.Move;

public class King extends Piece {

    private engine.Game g;
    private boolean hasMoved;
    private int[] coord;

    public King(PlayerColor color, engine.Game g)
    {
        super(color);
        if(this.color)
        {
            coord = new int[] {0, 4};
        }
        else
        {
            coord = new int[] {0, 4};
        }
        this.g = g;
        hasMoved = false;
    }

    private static Diagonal diagonal = new Diagonal(1, Move.Direction.ALL);
    private static Straight straight = new Straight(1, Move.Direction.ALL);

    //Conditional moves
    private static Castle rightCastle = new Castle(Move.Direction.RIGHT);
    private static Castle leftCastle = new Castle(Move.Direction.LEFT);

    public boolean check()
    {
        return g.check(coord);
    }

    public boolean move(int[] pos, int[] dest)
    {
        if(Move.checkDestination(dest))
        {
            if(Straight.isMoveType(pos, dest))
            {
                if(!this.hasMoved)
                {
                    if(Castle.isMoveType(pos, dest))
                    {
                        {//rightCastle
                            int[] rook_coord = new int[] {dest[0]+1, dest[1]};
                            Piece piece = g.getSquare(rook_coord);//The corresponding rook
                            if(piece.getClass()==Rook.class &&
                                    piece.color == color &&
                                    !piece.hasMoved() &&
                                    this.hasMoved &&
                                    rightCastle.verifyMove(pos, dest))
                            {//TODO : Normally, if the king can do the castle, so can the rook... use exception just in case ?
                                g.forceMove(rook_coord[0], rook_coord[1],dest[0]-1, dest[1]);
                                return true;
                            }
                        }
                        {//leftCastle
                            int[] rook_coord = new int[] {dest[0]-2, dest[1]};
                            Piece piece = g.getSquare(rook_coord);//The corresponding rook
                            if(piece.getClass()==Rook.class &&
                                    piece.color == color &&
                                    !piece.hasMoved() &&
                                    this.hasMoved &&
                                    leftCastle.verifyMove(pos, dest))
                            {//TODO : Normally, if the king can do the castle, so can the rook... use exception just in case ?
                                g.forceMove(rook_coord[0], rook_coord[1], dest[0]+1, dest[1]);
                                return true;
                            }
                        }
                    }

                }
                return straight.verifyMove(pos, dest);
            }
            if(Diagonal.isMoveType(pos, dest))
            {
                return diagonal.verifyMove(pos, dest);
            }
        }
        return false;
    }

    public void moveDone(int[] pos)
    {
        coord = pos;
        hasMoved = true;
    }

    @Override
    public PieceType getType()
    {
        return PieceType.KING;
    }
}
