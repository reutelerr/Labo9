package engine.move;

public abstract class Normal extends Move
{
    public abstract boolean detectCollision(int origin[], int direction, int distance);//true means there is a collision
}
