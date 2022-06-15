import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JButton {

    private Location type;
    private Field field;

    public Cell(Location type, Field field)
    {
        this.type = type;
        this.field = field;

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
            field.printField();
            setText(type.printRepresentation());
            field.gameStatus();
        }

    }

    public void clickButtonRight()
    {
        if(field.getRunning() == true)
        {
            field.markLocationCell(this);
            field.printField();
            setText(type.printRepresentation());
            field.gameStatus();
        }
    }
}