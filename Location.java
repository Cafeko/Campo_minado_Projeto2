public abstract class Location
{
    protected int x;
    protected int y;
    protected boolean hidden = true;
    private String representation;

    // construtor da classe
    public Location(int x, int y, String representation)
    {
        this.x = x;
        this.y = y;
        this.representation = representation;
    }

    // Printa as informações do Location
    public void printInfo()
    {
        System.out.println("x = " + x + " y = " + y);
        System.out.println("Tipe = " + representation);
    }

    abstract public String printRepresentation();

    public void setHiddenFalse()
    {
        hidden = false;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public boolean getHidden()
    {
        return hidden;
    }
}
