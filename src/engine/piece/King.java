package engine.piece;
import chess.PieceType;
import chess.PlayerColor;
import engine.move.Diagonal;
import engine.move.Straight;
import engine.move.Castle;
import engine.move.Move;

public class King extends Piece {

    private engine.Board b;
    private boolean hasMoved;
    private int[] coord;

    public King(PlayerColor color, engine.Board b)
    {
        super(color);
        if(this.color)
        {
            coord = new int[] {4, 0};
        }
        else
        {
            coord = new int[] {4, 7};
        }
        this.b = b;
        hasMoved = false;
    }

    private static Diagonal diagonal = new Diagonal(1, Move.Direction.ALL);
    private static Straight straight = new Straight(1, Move.Direction.ALL);

    //Conditional moves
    private static Castle rightCastle = new Castle(Move.Direction.RIGHT);
    private static Castle leftCastle = new Castle(Move.Direction.LEFT);

    public boolean move(int[] pos, int[] dest, engine.Board b)
    {
        if(Move.checkDestination(dest, b))
        {
            if(Straight.isMoveType(pos, dest))
            {
                if(!this.hasMoved && !b.check(coord))
                {
                    if(Castle.isMoveType(pos, dest))
                    {
                        {//rightCastle
                            int[] rook_coord = new int[] {dest[0]+1, dest[1]};
                            Piece piece = b.getSquare(rook_coord);//The corresponding rook
                            if(piece != null && piece.getClass()==Rook.class &&
                                    piece.color == color &&
                                    !piece.hasMoved() &&
                                    !this.hasMoved)
                            {
                                if(verifyMove(pos, dest, b, rightCastle))
                                {
                                    b.doMove(rook_coord[0], rook_coord[1],dest[0]-1, dest[1]);
                                    return true;
                                }

                            }
                        }
                        {//leftCastle
                            int[] rook_coord = new int[] {dest[0]-2, dest[1]};
                            Piece piece = b.getSquare(rook_coord);//The corresponding rook
                            if(piece != null && piece.getClass()==Rook.class &&
                                    piece.color == color &&
                                    !piece.hasMoved() &&
                                    !this.hasMoved)
                            {
                                if(verifyMove(pos, dest, b, leftCastle))
                                {
                                    b.doMove(rook_coord[0], rook_coord[1], dest[0]+1, dest[1]);
                                    return true;
                                }
                            }
                        }
                    }
                }
                return super.verifyMove(pos, dest, b, straight);
            }
            if(Diagonal.isMoveType(pos, dest))
            {
                return super.verifyMove(pos, dest, b, diagonal);
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
