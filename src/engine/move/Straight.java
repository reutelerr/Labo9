package engine.move;

public class Straight extends Normal
{
    public Straight()
    {
        super();
    }

    public Straight(int distanceMax, Direction direction)//TODO: Throw exeption if direction diagonal ???
    {
        super(distanceMax, direction);
    }

    public static boolean isMoveType(int[] origin, int[] dest)
    {
        return (origin[0]==dest[0] || origin[1]==dest[1]);
    }

    protected boolean detectCollision(int[] origin, Direction direction, int distance)
    {
        for(int i=1; i<distance; ++i)
        {
            int[] coord = null;
            switch(direction)
            {
                case UP://haut
                    coord = new int[] {origin[0], origin[1]+i};
                    break;

                case RIGHT://droite
                    coord = new int[] {origin[0]+i, origin[1]};
                    break;

                case DOWN://bas
                    coord = new int[] {origin[0], origin[1]-i};
                    break;

                case LEFT://gauche
                    coord = new int[] {origin[0]-i, origin[1]};
                    break;

                default://La direction est incorrecte
                    //TODO : Throw exception ?
            }
            if(b.getSquare(coord)!= null)
            {
                return true;
            }
        }
        return false;
    }

    public boolean verifyMove(int[] origin, int[] dest, engine.Board b)
    {
        this.b = b;
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
        if(directionPossible!=Direction.ALL && directionPossible!=direction)
        {
            return false;
        }
        if(distance>distanceMax && distanceMax!=-1)
        {
            return false;
        }
        return !detectCollision(origin, direction, distance);
    }
}
