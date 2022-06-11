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
        if(marked == true && hidden == true)
        {
            return "P ";
        }
        else if(hidden == false)
        {
            return "B ";
        }
        else
        {
            return "  ";
        }
    }
}
