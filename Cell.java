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
                clickButton();
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
    public void clickButton()
    {
        field.selectCell(this);
        field.printField();
        setText(type.printRepresentation());
    }
}