package Classes;

import javax.swing.*;

public class Ground extends Location
{
    int bombsAround;
    private ImageIcon um = new ImageIcon("src/Imagens/1.png");
    private ImageIcon dois = new ImageIcon("src/Imagens/2.png");
    private ImageIcon tres = new ImageIcon("src/Imagens/3.png");
    private ImageIcon quatro = new ImageIcon("src/Imagens/4.png");
    private ImageIcon cinco = new ImageIcon("src/Imagens/5.png");
    private ImageIcon seis = new ImageIcon("src/Imagens/6.png");
    private ImageIcon sete = new ImageIcon("src/Imagens/7.png");
    private ImageIcon oito = new ImageIcon("src/Imagens/8.png");

    /**
     * construtor de Ground.
     * @param x cordenada no eixo x.
     * @param y codenada no eixo y.
     */
    public Ground(int x, int y)
    {
        super(x, y);
    }

    /**
     * Da a variavel bombsAround o valor do parametro number.
     * @param number numero de bombas ao redor.
     */
    public void setBombNumber(int number)
    {
        bombsAround = number;
    }

    /**
     * @return A imagem que representa o estado atual de Ground.
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
            return imageNumber();
        }
        else
        {
            return null;
        }
    }

    /**
     * @return A imagem que representa o numero de bombas ao redor.
     * @return null caso o valor seja diferente dos especificados.
     */
    public ImageIcon imageNumber()
    {
        if(bombsAround == 1)
        {
            return um;
        }
        else if(bombsAround == 2)
        {
            return dois;
        }
        else if(bombsAround == 3)
        {
            return tres;
        }
        else if(bombsAround == 4)
        {
            return quatro;
        }
        else if(bombsAround == 5)
        {
            return cinco;
        }
        else if(bombsAround == 6)
        {
            return seis;
        }
        else if(bombsAround == 7)
        {
            return sete;
        }
        else if(bombsAround == 8)
        {
            return oito;
        }
        else
        {
            return null;
        }
    }


}
