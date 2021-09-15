package game_of_life;

/**
 * @author      Evan Hughes
 * @version     0.1               (current version number of program)
 * @since       8/19/2021         (the version of the package this class was first added to)
 */

public class GameOfLife 
{
    private Board gameBoard;
    public GameOfLife(int _gameGridY, int _gameGridX)
    {
        gameBoard = new Board(_gameGridY, _gameGridX);
    }
    public GameOfLife(int _gameGridY, int _gameGridX, int[][] initalPattern)
    {
        gameBoard = new Board(_gameGridY, _gameGridX, initalPattern);
    }

    public GameOfLife()
    {
        gameBoard = new Board();
    }

    public int[][] getBoard()
    {
        return gameBoard.getBoard();
    }

    /**
     * Game Rules
     * 
     * Any live cell with two or three live neighbours survives.
     * Any dead cell with three live neighbours becomes a live cell.
     * All other live cells die in the next generation. Similarly, all other dead cells stay dead.
     * 
     */

    public void updateBoard()
    {
        int gameArea = gameBoard.getGameArea();
        int changedCells[][] = new int[gameArea][3];
        int changedCellsUsed = 0;
        int gameGrid[][] = gameBoard.getBoard();
        for(int y = 0; y < gameGrid.length; y++)
        {
            for(int x = 0; x < gameGrid[y].length; x++)
            {
                int stateOfCell = gameGrid[y][x];
                int numberOfNeighbors = findNumberOfNeighbors(y, x, gameGrid);
                if(stateOfCell == 0)
                {
                    if(numberOfNeighbors == 3)
                    {
                        changedCells[changedCellsUsed][0] = y;
                        changedCells[changedCellsUsed][1] = x;
                        changedCells[changedCellsUsed][2] = 1;
                        changedCellsUsed++;
                    }
                }
                else if(stateOfCell == 1)
                {
                    if(numberOfNeighbors != 2 && numberOfNeighbors != 3)
                    {
                        changedCells[changedCellsUsed][0] = y;
                        changedCells[changedCellsUsed][1] = x;
                        changedCells[changedCellsUsed][2] = 0;
                        changedCellsUsed++;
                    }
                }
            }
        }
        for(int i = changedCellsUsed; i < changedCells.length; i++)
        {
            changedCells[i] = null;
        }
        gameBoard.setCells(changedCells);
    }
    private int findNumberOfNeighbors(int yPosition, int xPosition, int[][] gameGrid)
    {
        int numberOfNeighbors = 0;
        if(xPosition < gameGrid[yPosition].length-1 && gameGrid[yPosition][xPosition+1] == 1)
        {
            numberOfNeighbors++;
        }
        if(xPosition != 0 && gameGrid[yPosition][xPosition-1] == 1)
        {
            numberOfNeighbors++;
        }
        if(yPosition < gameGrid.length-1 && gameGrid[yPosition + 1][xPosition] == 1)
        {
            numberOfNeighbors++;
        }
        if(yPosition != 0 && gameGrid[yPosition - 1][xPosition] == 1)
        {
            numberOfNeighbors++;
        }
        if(xPosition != 0 && yPosition != 0 && gameGrid[yPosition - 1][xPosition - 1] == 1)
        {
            numberOfNeighbors++;
        }
        if(yPosition < gameGrid.length-1 && xPosition < gameGrid[yPosition].length-1 && gameGrid[yPosition + 1][xPosition + 1] == 1)
        {
            numberOfNeighbors++;
        }
        if(yPosition < gameGrid.length-1 && xPosition != 0 && gameGrid[yPosition + 1][xPosition - 1] == 1)
        {
            numberOfNeighbors++;
        }
        if(yPosition != 0 && xPosition < gameGrid[yPosition].length-1 && gameGrid[yPosition - 1][xPosition + 1] == 1)
        {
            numberOfNeighbors++;
        }
        return numberOfNeighbors;
    }
}
