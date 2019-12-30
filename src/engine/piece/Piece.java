package engine.piece;

import engine.Coordinates;

public abstract class Piece
{
    private boolean color;//true = white, false = black
    private Coordinates pos;

    public abstract boolean move(Coordinates dest);//returns true if move is valid, false otherwise
}
