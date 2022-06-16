package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JButton {

    private Location type;
    private Field field;
    private Color mineColor = new Color(52, 46,35);

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

    public Location getType()
    {
        return type;
    }

    // Ações que são executadas apos ser clicado
    public void clickButtonLeft()
    {
        if(field.getRunning() == true)
        {
            field.selectCell(this);
            field.gameStatus();
            field.fieldImage();
        }

    }

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