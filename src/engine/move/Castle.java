package engine.move;

public class Castle extends Straight
{

    public Castle(Direction direction)
    {
        this.directionPossible = direction;
        distanceMax = 2;
        //TODO : Envoyer une exception si direction n'est pas droite ou gauche ???
    }

    public static boolean isMoveType(int[] origin, int[] dest)
    {
        return (origin[1]==dest[1] && Math.abs(Math.abs(dest[0]-origin[0]))>1);
    }

    protected boolean detectCollision(int[] origin, Direction direction, int distance)
    {
        for(int i=1; i<distance; ++i)
        {
            int[] coord = null;
            switch(direction)
            {
                case RIGHT://droite
                    coord = new int[] {origin[0]+i, origin[1]};
                    break;

                case LEFT://gauche
                    coord = new int[] {origin[0]-i, origin[1]};
                    break;

                default://La direction est incorrecte
                    //TODO : Throw exception ?
            }
            if(b.getSquare(coord)!= null || b.check(coord))
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
        if(dest[0]>origin[0])
        {
            direction = Direction.RIGHT;//droite
        }
        else
        {
            direction = Direction.LEFT;//gauche
        }

        int distance = Math.abs(Math.abs(dest[0]-origin[0]));
        if(directionPossible!=direction)
        {
            return false;
        }
        if(distance!=distanceMax)
        {
            return false;
        }
        return !detectCollision(origin, direction, distance) && !b.check(dest);
    }
}
