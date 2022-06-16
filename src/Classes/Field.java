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

    // construtor da classe
    public Field(int width, int height, float bombChance)
    {
        this.width = width;
        this.height = height;
        this.bombChance = bombChance;
        this.running = true;
        createField(this.width, this.height, bombChance);
    }

    /*
    Seleciona/revela a localização
    se for Classes.Ground vai ver o numero de bombas ao redor
    se for Classes.Bomb vai revelar as bombas
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


    //Marca/desmarca uma localização
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

    /*
    Obtem e retorna um location de acordo com sua cordenada x e y
    se não existir retorna nulo
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

    /*
    Recebe um Classes.Location, conta o número de bombas ao redor dele e envia o valor para ele
    se o valor for zero ele vai selecionar as Cells ao redor
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

    /*
    Seleciona as Cells ao redor
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

    //Revela todas as bombas
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

    // printa o campo inteiro
    public void fieldImage()
    {
        for(Cell c: cellsList)
        {
            c.setIcon(c.getType().imageRepresentation());
        }
    }

    // Verifica se o jogador venceu ou não
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

    // Verifica se o jogador perdeu ou não
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

    //Verifica o status do jogo e printa o mesmo
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

    // Recebe um Classes.Location e adiciona na lista de Locations
    public void addCell(Cell c)
    {
        cellsList.add(c);
    }

    // Cria o campo minado
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

    //Apaga e recria o campo
    public void restartField()
    {
        cellsList.clear();
        createField(this.width, this.height, bombChance);
        running = true;
    }

    public ArrayList<Cell> getCellsList()
    {
        return cellsList;
    }

    public boolean getRunning()
    {
        return running;
    }
}