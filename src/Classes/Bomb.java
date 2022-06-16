package Classes;

import javax.swing.*;

public class Bomb extends Location
{
    private ImageIcon bomba = new ImageIcon("src/Imagens/bomb.png");

    // construtor da classe
    public Bomb(int x, int y)
    {
        super(x, y);
    }

    // Printa a representação no campo
    public ImageIcon imageRepresentation()
    {
        if(marked == true && hidden == true)
        {
            return bandeira;
        }
        else if(hidden == true)
        {
            return campo;
        }
        else if(hidden == false)
        {
            return bomba;
        }
        else
        {
            return null;
        }
    }
}
