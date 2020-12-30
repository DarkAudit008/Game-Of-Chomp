package chomp;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class BoardPanel extends JPanel
{
  private final int ROWS = 4, COLS = 7;   // board dimensions
  private final int CELLSIZE = 40;
  private final Color chocolate = new Color(110, 70, 50);

  private int tentativeRow, tentativeCol, displayCount;

  // Constructor
  public BoardPanel()
  {
    setPreferredSize(new Dimension(COLS * CELLSIZE, ROWS * CELLSIZE));
    setBackground(Color.LIGHT_GRAY);
  }

  // return the row numbers
  public int numRows()
  {
    return ROWS;
  }

  //return the column numbers
  public int numCols()
  {
    return COLS;
  }

  
  public Location getPos(int x, int y)
  {
    return new Location(y / CELLSIZE, x / CELLSIZE);
  }

  
  public void setMove(int row, int col)
  {
    tentativeRow = row;
    tentativeCol = col;
  }

  // set counts for the feedback
  public void setDisplayCount(int count)
  {
    displayCount = count;
  }

  private ChompGame game;

 
  public void update(ChompGame game)
  {
    this.game = game;
    repaint();
  }

  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    if (game == null)
      return;

    for (int r = 0; r < ROWS; r++)
    {
      for (int c = 0; c < COLS; c++)
      {
        Color color;

        if (game.isEmpty(r, c))
          color = Color.YELLOW;
        else if (displayCount % 2 != 0 && r >= tentativeRow && c >= tentativeCol)
          color = Color.RED;
        else
          color = chocolate;
        g.setColor(color);
        int x = c * CELLSIZE;
        int y = r * CELLSIZE;
        g.fillRect(x, y, CELLSIZE, CELLSIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, CELLSIZE, CELLSIZE);
        g.drawRect(x+1, y+1, CELLSIZE-2, CELLSIZE-2);
        if (r == 0 && c == 0)
        {
          g.setColor(Color.YELLOW);
          g.drawLine(x+3, y+3, x + CELLSIZE - 6, y + CELLSIZE - 6);
          g.drawLine(x+3, y + CELLSIZE - 6, x + CELLSIZE - 6, y+3);
        }
      }
    }

    if (displayCount > 0)
      displayCount--;
  }
}