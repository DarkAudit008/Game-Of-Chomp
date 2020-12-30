//This is a chomp game to play against computer


package chomp;

public class ChompGame extends grid
{
  private BoardPanel board;

  public ChompGame(BoardPanel board)
  {
    super(board.numRows(), board.numCols(), 'x');
    this.board = board;
    board.update(this);
  }

  
  public boolean isEmpty(int row, int col)
  {
    return row < 0 || row >= numRows() || col < 0 || col >= numCols() ||
           super.isEmpty(row, col);
  }


  public boolean isWon()
  {
    return isEmpty(0, 0);
  }

  /**
   * adjusts the board
   */
  public void makeMove(int row, int col)
  {
    clearRect(row, col, numRows() - 1, numCols() - 1);
    board.setDisplayCount(0);
    board.update(this);
  }
}

