package chomp;

public class grid
{
  // Fields:
  private char[][] m;

  /**
   * creating the grid with rows and column
   */
  public grid(int rows, int cols)
  {
    new grid(rows,cols,' ');
}

  
  public grid(int rows, int cols, char fill)
  {
    m = new char[rows][cols];
     
      for(int i = 0; i < rows; i++)    
      {
          for(int j = 0;j < cols; j++)
          {
              m[i][j]= fill;
          }
      }
  }

  /**
   * Returns the number of rows in grid
   */
  public int numRows()
  {
    return m.length;
  }

  /**
   * Returns the number of columns in grid
   */
  public int numCols()
  {
    return m[0].length;
  }

  
   
   
  public char charAt(int row, int col)
  {
    return m[row][col];
  }

  
  public void setCharAt(int row, int col, char ch)
  {
    m[row][col] = ch;
  }

  
  public boolean isEmpty(int row, int col)
  {
    if (m[row][col] == ' ')
    {
        return true;
    }
    else
    {
        return false;
    }
  }

  
   
  public void fillRect(int row0, int col0, int row1, int col1, char fill)
  {
     for (int i = row0; i <= row1; i++)    
   {
    for (int j = col0; j <= col1; j++)
    {
     m[i][j] = fill;
    }
   }
  }

  
  public void clearRect(int row0, int col0, int row1, int col1)
  {
    for (int i = row0; i <= row1; i++)    
   {
    for (int j = col0; j <= col1; j++)
    {
     m[i][j] = ' ';
    }
   }
  }

  
  public int countInRow(int row)
  {
    int num = 0;
 
   for (int i = 0; i < m[row].length; i++)
   {
    if (m[row][i] != ' ')
    {
     num++;
    }
   }
   return num;
  }

  
  public int countInCol(int col)
  {
    int num = 0;
 
   for (int i = 0; i < m[col].length; i++)
   {
    if (m[i][col] != ' ')
    {
     num++;
    }
   }
   return num;
  }
}
