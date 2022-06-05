import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean game = true;
        Scanner input = new Scanner(System.in);
        int x = 0;
        int y = 0;
        Field field = new Field(9,9, 20);
        field.printField();
        System.out.println();
        while(game)
        {
            System.out.print("x = ");
            x = input.nextInt();

            System.out.print("y = ");
            y = input.nextInt();

            System.out.println();
            field.selectLocation(x, y);
            field.printField();
            field.printLocationInfo(x, y);
            System.out.println();
        }
    }
}
