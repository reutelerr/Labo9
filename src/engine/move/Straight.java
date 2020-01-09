package engine.move;

public class Straight extends Normal
{
    public boolean isMoveType(int[] origin, int[] dest)
    {
        return origin[0]==dest[0] || origin[1]==dest[1];
    }

    public boolean detectCollision(int[] origin, Direction direction, int distance)
    {
        for(int i=1; i<distance; ++i)
        {
            switch(direction)
            {
                case UP://haut
                    if(b.getSquare(new int[] {origin[0], origin[1]+i})!=null)
                    {
                        return true;
                    }
                    break;

                case RIGHT://droite
                    if(b.getSquare(new int[] {origin[0]+i, origin[1]})!=null)
                    {
                        return true;
                    }
                    break;

                case DOWN://bas
                    if(b.getSquare(new int[] {origin[0], origin[0]-i})!=null)
                    {
                        return true;
                    }
                    break;
                case LEFT://gauche
                    if(b.getSquare(new int[] {origin[0]-i, origin[1]})!=null)
                    {
                        return true;
                    }
                    break;
            }

        }
        return false;
    }

    public boolean verifyMove(int[] origin, int[] dest)
    {
        Direction direction = Direction.NONE;
        if(dest[1]==origin[1])
        {
            if(dest[0]>origin[0])
            {
                direction = Direction.RIGHT;//droite
            }
            else
            {
                direction = Direction.LEFT;//gauche
            }
        }
        else
        {
            if(dest[1]>origin[1])
            {
                direction = Direction.UP;//haut
            }
            else
            {
                direction = Direction.DOWN;//bas
            }
        }
        int distance = Math.abs(dest[1]-origin[1]) + Math.abs(dest[0]-origin[0]);
        return detectCollision(origin, direction, distance) && checkDestination(dest);
    }
}
