package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JButton {

    private Location type;
    private Field field;
    private Color mineColor = new Color(52, 46,35);

    /**
     * Construtor de Cell.
     * @param type o Location da Cell.
     * @param field O Fieldda Cell.
     */
    public Cell(Location type, Field field)
    {
        this.type = type;
        this.field = field;
        this.setFocusable(false);
        this.setIcon(type.campo);
        this.setBackground(Color.getColor("", mineColor));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setForeground(Color.white);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                if(e.getButton() == MouseEvent.BUTTON1)
                {
                    clickButtonLeft();
                }
                else if(e.getButton() == MouseEvent.BUTTON3)
                {
                    clickButtonRight();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    /**
     * @return o Location da Cell armazenado em type.
     */
    public Location getType()
    {
        return type;
    }

    /**
     * Se o running de field for true: seleciona está Cell, verifica se o jogo deve continuar rodando ou não
     * e atualiza as imagens de todas as Cells de Field.
     * se for false: não acontece nada.
     */
    public void clickButtonLeft()
    {
        if(field.getRunning() == true)
        {
            field.selectCell(this);
            field.gameStatus();
            field.fieldImage();
        }

    }

    /**
     * Se o running de field for true: Marca está Cell, verifica se o jogo deve continuar rodando ou não
     * e atualiza as imagens de todas as Cells de Field.
     * se for false: não acontece nada.
     */
    public void clickButtonRight()
    {
        if(field.getRunning() == true)
        {
            field.markLocationCell(this);
            field.gameStatus();
            field.fieldImage();
        }
    }
}