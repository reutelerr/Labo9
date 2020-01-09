package engine.move;

public abstract class L extends Move
{
    public boolean isMoveType(int[] origin, int[] dest)
    {
        int horizontalDistance = Math.abs(origin[0]-dest[0]);
        int verticalDistance   = Math.abs(origin[1]-dest[1]);
        return  verticalDistance == 2 && horizontalDistance == 1 ||
                verticalDistance == 1 && horizontalDistance == 2;
    }
}
