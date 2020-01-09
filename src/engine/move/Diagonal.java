package engine.move;

public class Diagonal extends Normal
{
    public boolean isMoveType(int[] origin, int[] dest)
    {
        return Math.abs(dest[1]-origin[1])==Math.abs(dest[0]-origin[0]);
    }

    public boolean detectCollision(int[] origin, int direction, int distance)
    {
        for(int i=1; i<distance; ++i)
        {
            switch(direction)
            {
                case 1://haut-droite
                    if(b.getSquare(new int[] {origin[0]+i, origin[1]+i})!=null)
                    {
                        return true;
                    }
                    break;

                case 2://bas-droite
                    if(b.getSquare(new int[] {origin[0]+i, origin[1]-i})!=null)
                    {
                        return true;
                    }
                    break;

                case 3://bas-gauche
                    if(b.getSquare(new int[] {origin[0]-i, origin[1]-i})!=null)
                    {
                        return true;
                    }
                    break;

                case 4://haut-gauche
                    if(b.getSquare(new int[] {origin[0]-i, origin[0]+i})!=null)
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

        if(dest[0]>origin[0])
        {
            if(dest[1]>origin[1])
                direction = 1;//haut-droite
            else
                direction = 2;//bas-droite
        }
        else
        {
            if(dest[1]>origin[1])
                direction = 4;//haut-gauche
            else
                direction = 3;//bas-gauche
        }
        int distance = Math.abs(dest[1]-origin[1]);

        return detectCollision(origin, direction, distance) && checkDestination(dest);
    }
}
