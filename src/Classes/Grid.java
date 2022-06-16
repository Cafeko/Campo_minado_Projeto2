package Classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {

    private int limite = Main.TAMGRID * Main.TAMGRID;
    public static ArrayList<Cell> cellGrid = new ArrayList<Cell>();
    private Field field;

    /**
     * Construtor do Grid.
     * @param g Tipo de layout do Grid.
     * @param field Field que conten as Cells do jogo.
     */
    public Grid(GridLayout g, Field field)
    {
        super(g);
        this.field = field;
        cellGrid = this.field.getCellsList();
        addCells();
    }

    /**
     * Adiciona as Cells da lista cellGrid ao Grid.
     */
    public void addCells()
    {
        for (Cell c : cellGrid)
        {
            add(c);
        }
    }

    /**
     * Da a atual lista de Cells de Field a cellGrid e adiciona as Cells de cellGrid ao Grid.
     */
    public void RestartGrid()
    {
        cellGrid = field.getCellsList();
        addCells();
    }
}