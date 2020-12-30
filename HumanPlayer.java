package chomp;

import java.awt.event.MouseListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class HumanPlayer
    implements Player, MouseListener
{
  private Chomp program;
  private ChompGame game;
  private BoardPanel board;

  private boolean myTurn;

  public HumanPlayer(Chomp program, ChompGame game, BoardPanel board)
  {
    this.program = program;
    this.game = game;
    this.board = board;
    board.addMouseListener(this);
  }

  public String getPrompt()
  {
    return " Chose Your Block";
  }

  public String getWinMessage()
  {
    return " Congrats, you won!";
  }

  
  public void makeMove()
  {
      myTurn = true;
  }

 
  public void mouseReleased(MouseEvent e)
  {
    if (!myTurn)
      return;

    

    Location pos = board.getPos(e.getX(), e.getY());
    int row = pos.getRow();
    int col = pos.getCol();

    if (!game.isEmpty(row, col))
    {
      game.makeMove(row, col);
      program.hasMoved();
      myTurn = false;
    }
  }

  public void mouseClicked(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
}
