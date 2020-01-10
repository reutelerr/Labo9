package engine.move;
import engine.piece.Rook;

public class Castle extends Straight
{
    private Rook rook;

    Castle(Direction direction, Rook rook)
    {
        this.rook = rook;
        this.directionPossible = direction;
        if(direction == Direction.LEFT)
        {
            distanceMax = 3;
        }
        else if(direction == Direction.RIGHT)
        {
            distanceMax = 2;
        }
        //TODO : Envoyer une exception si direction n'est pas doite ou gauche ???
    }

    public boolean isMoveType(int[] origin, int[] dest)
    {
        return (origin[1]==dest[1] && Math.abs(Math.abs(dest[0]-origin[0]))>1);
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
        if(rook.hasMoved())
        {
            return false;
        }

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
        return detectCollision(origin, direction, distance);
    }
}
