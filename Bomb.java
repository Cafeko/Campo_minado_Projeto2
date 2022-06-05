public class Bomb extends Location
{
    // construtor da classe
    public Bomb(int x, int y, String representation)
    {
        super(x, y, representation);
    }

    // Printa a representação no campo
    public String printRepresentation()
    {
        if(!hidden)
        {
            return "B ";
        }
        else
        {
            return "  ";
        }
    }
}
