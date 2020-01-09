package engine.move;

public abstract class Move
{
    public enum Direction {
        UP, RIGHT, DOWN, LEFT,
        UP_RIGHT, DOWN_RIGHT, DOWN_LEFT, UP_LEFT,
        ALL, NONE
    }
    protected engine.Board b;
    protected engine.Game g;

    public abstract boolean isMoveType(int[] origin, int[] dest);//true if move is of the instance move type

    public boolean checkDestination(int[] dest)//true si destination ok
    {
        return !(b.getSquare(dest).color == g.getActivePlayer());//Vérifier ce qui se passe si la case est vide...
    }
}
