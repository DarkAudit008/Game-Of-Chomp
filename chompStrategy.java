package chomp;


//this is a strategy for the computer. which makes it hard for the player to win the game
public class chompStrategy implements Strategy
{
  
  private static int winPositions[][] =
  {
    {1},
    {7,6}, {6,5}, {5,4}, {4,3}, {3,2}, {2,1},
    {7,7,4}, {7,5,2}, {6,4,2}, {4,2,2},
    {7,4,3}, {6,3,3}, {5,5,3},
    {4,1,1,1}, {3,1,1},
    {2,2,2,1},
    {2,2,1}, {3,3,1,1},
    {5,2,1,1},
  };

  // gets the best move
  public Location findBestMove(ChompGame game)
  {
    int rows = game.numRows(), cols = game.numCols(), r;
    int wLength, bLength, bestRow, bestCol;
    int wSteps[], bSteps[];

    
    bSteps = new int[rows];
    for (r = 0; r < rows; r++)
      bSteps[r] = game.countInRow(r);

    for (int i = 0; i < winPositions.length; i++)
    {
      wSteps = winPositions[i];
      bestRow = -1;
      bestCol = cols;

      
      for (r = 0; r < rows; r++)
      {
        if (r < wSteps.length)
          wLength = wSteps[r];
        else
          wLength = 0;

        bLength = bSteps[r];

        if (bestRow < 0 && bLength != wLength)
        {
          bestRow = r;
          bestCol = wLength;
        }

        if (bLength > bestCol)
          bLength = bestCol;

        if (bLength != wLength)
          break;
      }

      if (r == rows && bestRow >= 0)
      {
        return new Location(bestRow, bestCol);
      }
    }
    return null;
  }

  // takes a random move
  public Location findRandomMove(ChompGame game)
  {
    int rows = game.numRows(), cols = game.numCols();
    Location[] list = new Location[rows + cols];

    int count = 0;

 
    for (int r = 0; r < rows; r++)
    {
      for (int c = 0; c < cols; c++)
      {
        if (r + c > 0 && !game.isEmpty(r, c) &&
                 (game.isEmpty(r + 1, c) || game.isEmpty(r, c + 1)))
          list[count++] = new Location(r, c);
      }
    }

    // random element chose
    if (count == 0)
    {
      return new Location(0, 0);
    }
    else
    {
      int n = (int)(count * Math.random());
      return list[n];
    }
  }
}
