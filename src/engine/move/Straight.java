package engine.move;

public class Straight extends Normal
{
    public boolean detectCollision(int[] origin, int direction, int distance)
    {
        for(int i=1; i<distance; ++i)
        {
            switch(direction)
            {
                case 1://haut
                    if(b.getSquare(new int[] {origin[0]+i, origin[1]})!=null)
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
            }

        }
        return false;
    }
}
