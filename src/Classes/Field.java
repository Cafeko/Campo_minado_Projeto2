package Classes;

import java.util.ArrayList;
import java.util.Random;

public class Field
{
    private ArrayList<Cell> cellsList = new ArrayList<Cell>();
    private int width;
    private int height;
    private float bombChance;
    private Random random = new Random();
    private boolean running;

    /**
     * Construtor de Field.
     * @param width largura do Field.
     * @param height altura do Field.
     * @param bombChance porcentagem de chance de criar uma bomba.
     */
    public Field(int width, int height, float bombChance)
    {
        this.width = width;
        this.height = height;
        this.bombChance = bombChance;
        this.running = true;
        createField(this.width, this.height, bombChance);
    }

    /**
     * Seleciona uma Cell e verifica o Location dela:
     * se o Location for intancia de Bomb, revela todas as bombas.
     * se o Location for instancia de Ground, verifica as Cells ao redor.
     * @param c Cell selecionada.
     */
    public void selectCell(Cell c)
    {
        if(c != null)
        {
            Location l = c.getType();
            l.setHiddenFalse();
            if(l instanceof Ground)
            {
                lookAroundCell(c);
            }
            else if(l instanceof Bomb)
            {
                revealBombsCell();
            }
        }
    }


    /**
     * Marca e desmarca o Location de uma Cell.
     * @param c Cell cujo Location sera marcado/desmarcado.
     */
    public void markLocationCell(Cell c)
    {
        Location l = c.getType();
        if(l != null)
        {
            if(l.getMark() == false)
            {
                l.setMark(true);
            }
            else
            {
                l.setMark(false);
            }

        }
    }

    /**
     * Retorna um Location de acordo com suas cordenadas x e y
     * @param x cordenada no eixo x.
     * @param y cordenada no eixo y.
     * @return o Location que tem as cordenadas x e y.
     * @return null se não houver um Location com as cordenadas especificadas.
     */
    public Location getLocation(int x, int y)
    {
        for (Cell c : cellsList) {
            Location l = c.getType();
            if (l.getX() == x && l.getY() == y)
            {
                return l;
            }
        }
        return null;
    }

    /**
     * Retorna um Cell de acordo com as cordenadas x e y de seu Location.
     * @param x cordenada no eixo x.
     * @param y cordenada no eixo y.
     * @return a Cell que o Location tem as cordenadas x e y.
     * @return null se não houver uma Cell cujo Location tem as cordenadas especificadas.
     */
    public Cell getCell(int x, int y)
    {
        for (Cell c : cellsList) {
            Location l = c.getType();
            if (l.getX() == x && l.getY() == y)
            {
                return c;
            }
        }
        return null;
    }

    /**
     * Verifica os arredores de uma Cell, conta o numero de bombas ao redor
     * e manda o valor para o Ground da Cell.
     * Se não tiver bombas ao redor ira selecionar as Cells ao redor.
     * @param c Cell que os arredores serão verificados.
     */
    public void lookAroundCell(Cell c)
    {
        Location g = c.getType();
        if(g instanceof Ground)
        {
            int x = g.getX();
            int y = g.getY();
            int bombsAround = 0;
            for(int j = y - 1; j < y + 2; j += 1)
            {
                for(int i = x - 1; i < x + 2; i += 1)
                {
                    if(getLocation(i, j) != null)
                    {
                        if(getLocation(i, j) instanceof Bomb)
                        {
                            bombsAround += 1;
                        }
                    }
                }
            }
            ((Ground) g).setBombNumber(bombsAround);
            if(bombsAround == 0)
            {
                selectAroundCell(g.getX(), g.getY());
            }
        }
    }

    /**
     * Seleciona as Cells ao redor de uma cordenada.
     * @param x cordenada no eixo x.
     * @param y cordenada no eixo y.
     */
    public void selectAroundCell(int x, int y)
    {
        for(int j = y - 1; j < y + 2; j += 1)
        {
            for(int i = x - 1; i < x + 2; i += 1)
            {
                if(getLocation(i, j) != null)
                {
                    Cell c = getCell(i, j);
                    Location l = c.getType();
                    if(l instanceof Ground && l.getHidden())
                    {
                        c.clickButtonLeft();
                    }
                }
            }
        }
    }

    /**
     * Revela todas as bombas do Field.
     */
    public void revealBombsCell()
    {
        for(int j = 1; j <= height; j += 1)
        {
            for(int i = 1; i <= width; i += 1)
            {
                Cell c = getCell(i, j);
                Location l = c.getType();
                if(l instanceof Bomb)
                {
                    l.setHiddenFalse();
                }
            }
        }
    }

    /**
     * Coloca o icone de todas as Cells do Field de acordo com seu  estado atual.
     */
    public void fieldImage()
    {
        for(Cell c: cellsList)
        {
            c.setIcon(c.getType().imageRepresentation());
        }
    }

    /**
     * Verifica se Todos os Grounds foram revelados, se sim, finaliza o jogo.
     * @return True caso o jogo ainda esteja rolando.
     * @return false caso o jogo tenha chegado ao seu fim.
     */
    public boolean checkGround()
    {
        boolean game = false;
        for(int j = 1; j <= height; j += 1)
        {
            for(int i = 1; i <= width; i += 1)
            {
                Location l = getLocation(i, j);
                if(l instanceof Ground)
                {
                    if(l.getHidden() == true)
                    {
                        game = true;
                        return game;
                    }
                }
            }
        }
        if(game == false)
        {
            System.out.println("Você Ganhou");
        }
        return game;
    }

    /**
     * Verifica se uma Bomb foi revelada, se sim, finaliza o jogo.
     * @return True caso o jogo ainda esteja rolando.
     * @return false caso o jogo tenha chegado ao seu fim.
     */
    public boolean checkBomb()
    {
        boolean game = true;
        for(int j = 1; j <= height; j += 1)
        {
            for(int i = 1; i <= width; i += 1)
            {
                Location l = getLocation(i, j);
                if(l instanceof Bomb)
                {
                    if(l.getHidden() == false)
                    {
                        game = false;
                        System.out.println("Gama Over");
                        return game;
                    }
                }
            }
        }
        return game;
    }

    /**
     * Verifica o estado do jogo e da esse valor para running.
     */
    public void gameStatus()
    {
        boolean r;
        r = checkGround();
        if(r != false)
        {
            r = checkBomb();
        }
        running = r;
    }

    /**
     * Adiciona uma Cell a cellsList.
     * @param c Cell que sera adicionada a lista.
     */
    public void addCell(Cell c)
    {
        cellsList.add(c);
    }

    /**
     * Cria todas as Cells, e seus respectivos Locations, e as adiciona a lista de Cells do Field .
     * @param width largura do Field.
     * @param height altura do Field.
     * @param bombChance porcentagem de chance de criar uma bomba.
     */
    public void createField(int width, int height,float bombChance)
    {
        double chance;
        if(bombChance >= 100)
        {
            chance = 1;
        }
        else if(bombChance < 100 && bombChance > 0)
        {
            chance = bombChance/100;
        }
        else
        {
            chance = 0.01;
        }
        for(int j = 1; j <= height; j += 1)
        {
            for(int i = 1; i <= width; i += 1)
            {
                double isBomb = random.nextDouble();
                if(isBomb <= chance)
                {
                    addCell(new Cell(new Bomb(i, j), this));
                }
                else
                {
                    addCell(new Cell(new Ground(i, j), this));
                }
            }
        }
    }

    /**
     * Apaga e as Cells do Field, cria novas do zero e da a running o valor de true.
     */
    public void restartField()
    {
        cellsList.clear();
        createField(this.width, this.height, bombChance);
        running = true;
    }

    /**
     * @return a lista de Cells.
     */
    public ArrayList<Cell> getCellsList()
    {
        return cellsList;
    }

    /**
     * @return o valor de running.
     */
    public boolean getRunning()
    {
        return running;
    }
}