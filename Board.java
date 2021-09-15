package game_of_life;

public class Board {
    private int[][] gameGrid;
    private int gameArea;
    public Board(int _gameGridY, int _gameGridX)
    {
        this.gameGrid = new int[_gameGridY][_gameGridY];
        this.gameArea = _gameGridX * _gameGridY;
    }

    public Board(int _gameGridY, int _gameGridX, int[][] intitalPattern)
    {
        this.gameGrid = new int[_gameGridY][_gameGridY];
        this.gameArea = _gameGridX * _gameGridY;
        setCells(intitalPattern);
    }

    public Board()
    {
        this.gameGrid = new int[10][10];
    }

    /**
     * @return the gameGrid
     */
    public int[][] getBoard()
    {
        return gameGrid;
    }

    /**
     * @return the gameArea
     */
    public int getGameArea() {
        return gameArea;
    }

    /**
    * Sets specified cells to living 
    *
    * @param  cellsToFill  a multidimentional array of coordinates to make living cells
    */
    public void setCells(int cellsToFill[][])
    {
        for(int[] coordinates : cellsToFill)
        {
            if(coordinates != null)
            {
                gameGrid[coordinates[0]][coordinates[1]] = coordinates[2];
            }
        }
    }
}
