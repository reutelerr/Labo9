package engine.move;

public abstract class Move
{
    public enum Direction {
        UP, RIGHT, DOWN, LEFT,
        UP_RIGHT, DOWN_RIGHT, DOWN_LEFT, UP_LEFT,
        ALL, NONE
        //All veut dire soit toutes les directions droites, soit toutes les diagonales, selon l'instance qui utilise l'enum
    }
    static protected engine.Board b;
    static protected engine.Game g;

    public abstract boolean verifyMove(int[] origin, int[] dest);//true if move correct (no collisions)

    //public  boolean isMoveType(int[] origin, int[] dest);//true if move is of the instance move type

    static public boolean checkDestinationFree(int[] dest)
    {
        return b.getSquare(dest)==null;
    }

    static public boolean checkDestinationTaken(int[] dest)
    {
        return b.getSquare(dest).color == !g.getActivePlayer();
    }

    static public boolean checkDestination(int[] dest)//true si destination ok
    {
        return checkDestinationFree(dest) || checkDestinationTaken(dest);
    }
}
