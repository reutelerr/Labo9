package engine.move;

public abstract class Normal extends Move
{
    int distanceMax;
    Direction directionPossible;

    Normal()
    {
        this.distanceMax = -1;
        this.directionPossible = Direction.ALL;
    }

    Normal(int distanceMax, Direction directionPossible)
    {
        this.distanceMax = distanceMax;
        this.directionPossible = directionPossible;
    }

    public abstract boolean detectCollision(int[] origin, Direction direction, int distance);//true means there is a collision
}
