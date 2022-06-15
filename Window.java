import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window {

    private static JFrame frame;
    private static String title;

    public Window(int largura, int altura, int tamGrid, String title, Field field){

        Window.title = title;
        frame = new JFrame(title);

        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(largura, altura));
        frame.setMinimumSize(new Dimension(largura, altura));
        frame.setMaximumSize(new Dimension(largura, altura));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel painel = new Grid(new GridLayout(tamGrid, tamGrid), field);
        frame.setContentPane(painel);

        JMenuBar bar = new JMenuBar();
        frame.setJMenuBar(bar);
        JMenu restartButton = new JMenu("Restart");
        bar.add(restartButton);

        frame.pack();

        restartButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                field.restartField();
                painel.removeAll();
                ((Grid) painel).RestartGrid();
                frame.pack();
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

}