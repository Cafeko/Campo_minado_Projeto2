package Classes;

import javax.swing.*;

public class Bomb extends Location
{
    private ImageIcon bomba = new ImageIcon("src/Imagens/bomb.png");

    /**
     * construtor de Bomb.
     * @param x cordenada no eixo x.
     * @param y codenada no eixo y.
     */
    public Bomb(int x, int y)
    {
        super(x, y);
    }

    /**
     * @return A imagem que representa o estado atual de Bomb.
     */
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
