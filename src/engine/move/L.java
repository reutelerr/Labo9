package engine.move;

public class L extends Move
{
    public static boolean isMoveType(int[] origin, int[] dest)
    {
        int horizontalDistance = Math.abs(origin[0]-dest[0]);
        int verticalDistance   = Math.abs(origin[1]-dest[1]);
        return  verticalDistance == 2 && horizontalDistance == 1 ||
                verticalDistance == 1 && horizontalDistance == 2;
    }

    public boolean verifyMove(int[] origin, int[] dest, engine.Board b)
    {
        return true;
    }
}
