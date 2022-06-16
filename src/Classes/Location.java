package Classes;

import javax.swing.*;

public abstract class Location
{
    protected int x;
    protected int y;
    protected boolean hidden = true;
    protected boolean marked = false;
    protected ImageIcon campo = new ImageIcon("src/Imagens/grama.png");
    protected ImageIcon bandeira = new ImageIcon("src/Imagens/flag.png");


    // construtor da classe
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    abstract public ImageIcon imageRepresentation();

    public void setHiddenFalse()
    {
        hidden = false;
    }

    public void setMark(boolean v)
    {
        marked = v;
    }

    public boolean getMark()
    {
        return marked;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public boolean getHidden()
    {
        return hidden;
    }
}
