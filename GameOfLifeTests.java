package game_of_life;
import java.util.Scanner;

public class GameOfLifeTests 
{
    public static void main(String[] args)
    {
        int ySize = 20;
        int xSize = 20;
        int cellsToFill[][] = 
        {
            {0,0,1},
            {1,1,1},
            {0,2,1},
            {1,2,1},
            {2,1,1}
        };

        GameOfLife game = new GameOfLife(ySize, xSize, cellsToFill);
        Scanner input = new Scanner(System.in);
        String quit = "";
        while(!(quit.equals("quit"))){
            int[][] gameGrid = game.getBoard();
            printBoard(gameGrid);
            game.updateBoard();
            System.out.println();
            quit = input.nextLine();
        }
        input.close();
        
    }
    public static void printBoard(int[][] gameGrid)
    {
        for(int y = 0; y < gameGrid.length; y++)
        {
            for(int x = 0; x < gameGrid[y].length; x++)
            {
                System.out.print(gameGrid[y][x]);
            }
            System.out.println();
        }
    }
}
