package engine.move;

public class Diagonal extends Normal
{
    public Diagonal(int distanceMax, Direction direction)//TODO: Throw exeption if direction straight ???
    {
        super(distanceMax, direction);
    }

    public static boolean isMoveType(int[] origin, int[] dest)
    {
        return Math.abs(dest[1]-origin[1])==Math.abs(dest[0]-origin[0]);
    }

    public boolean detectCollision(int[] origin, Direction direction, int distance)
    {
        for(int i=1; i<distance; ++i)
        {
            int[] coord = null;
            switch(direction)
            {
                case UP_RIGHT://haut-droite
                    coord = new int[] {origin[0]+i, origin[1]+i};
                    break;

                case DOWN_RIGHT://bas-droite
                    coord = new int[] {origin[0]+i, origin[1]-i};
                    break;

                case DOWN_LEFT://bas-gauche
                    coord = new int[] {origin[0]-i, origin[1]-i};
                    break;

                case UP_LEFT://haut-gauche
                    coord = new int[] {origin[0]-i, origin[1]+i};
                    break;
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

        if(dest[0]>origin[0])
        {
            if(dest[1]>origin[1])
                direction = Direction.UP_RIGHT;//haut-droite
            else
                direction = Direction.DOWN_RIGHT;//bas-droite
        }
        else
        {
            if(dest[1]>origin[1])
                direction = Direction.UP_LEFT;//haut-gauche
            else
                direction = Direction.DOWN_LEFT;//bas-gauche
        }
        int distance = Math.abs(dest[1]-origin[1]);
        return !detectCollision(origin, direction, distance);
    }
}
