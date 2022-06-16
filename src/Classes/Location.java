package Classes;

import javax.swing.*;

public abstract class Location
{
    protected int x;
    protected int y;
    protected boolean hidden = true;
    protected boolean marked = false;
    protected ImageIcon campo = new ImageIcon("src/Imagens/field_def.png");
    protected ImageIcon bandeira = new ImageIcon("src/Imagens/flag.png");


    /**
     * construtor de Location.
     * @param x cordenada no eixo x.
     * @param y codenada no eixo y.
     */
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Metodo abstrato que é executado nas subclasses de Location.
     * @return A imagem que representa o estado atual do Location.
     */
    abstract public ImageIcon imageRepresentation();

    /**
     * Da a hidden o valor de false.
     */
    public void setHiddenFalse()
    {
        hidden = false;
    }

    /**
     * Da a marked o valor do parametro v.
     * @param v valor que sera dado para marked.
     */
    public void setMark(boolean v)
    {
        marked = v;
    }

    /**
     * @return Valor de marked.
     */
    public boolean getMark()
    {
        return marked;
    }

    /**
     * @return Valor de x.
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * @return Valor de y.
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * @return Valor de hidden.
     */
    public boolean getHidden()
    {
        return hidden;
    }
}
