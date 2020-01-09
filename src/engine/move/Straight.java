package engine.move;

public class Straight extends Normal
{
    public boolean isMoveType(int[] origin, int[] dest)
    {
        return origin[0]==dest[0] || origin[1]==dest[1];
    }

    public boolean detectCollision(int[] origin, int direction, int distance)
    {
        for(int i=1; i<distance; ++i)
        {
            switch(direction)
            {
                case 1://haut
                    if(b.getSquare(new int[] {origin[0], origin[1]+i})!=null)
                    {
                        return true;
                    }
                    break;

                case 2://droite
                    if(b.getSquare(new int[] {origin[0]+i, origin[1]})!=null)
                    {
                        return true;
                    }
                    break;

                case 3://bas
                    if(b.getSquare(new int[] {origin[0], origin[0]-i})!=null)
                    {
                        return true;
                    }
                    break;
                case 4://gauche
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
        int direction = 0;
        if(dest[1]==origin[1])
        {
            if(dest[0]>origin[0])
            {
                direction = 2;//droite
            }
            else
            {
                direction = 4;//gauche
            }
        }
        else
        {
            if(dest[1]>origin[1])
            {
                direction = 1;//haut
            }
            else
            {
                direction = 3;//bas
            }
        }
        int distance = Math.abs(dest[1]-origin[1]) + Math.abs(dest[0]-origin[0]);
        return detectCollision(origin, direction, distance) && checkDestination(dest);
    }
}
