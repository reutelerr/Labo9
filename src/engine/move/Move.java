package engine.move;

public abstract class Move
{
    protected engine.Board b;
    protected engine.Game g;

    public abstract boolean verifyMove(int[] origin, int[] dest);
    public boolean checkDestination(int[] dest)//true si destination ok
    {
        return !(b.getSquare(dest).color == g.getActivePlayer());//Vérifier ce qui se passe si la case est vide...
    }
}
