package engine.move;

public abstract class Normal extends Move
{
    public enum Direction {
        UP, RIGHT, DOWN, LEFT,
        UP_RIGHT, DOWN_RIGHT, DOWN_LEFT, UP_LEFT,
        ALL, NONE
    }

    int distanceMax = -1;
    int[] directionPossible;
    public abstract boolean detectCollision(int origin[], Direction direction, int distance);//true means there is a collision
}
