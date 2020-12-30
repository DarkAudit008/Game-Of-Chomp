package chomp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class ComputerPlayer
    implements Player, ActionListener
{
  private Chomp program;
  private ChompGame game;
  private BoardPanel board;

  private Timer clock;
  private int clockCount;
  private int moveRow, moveCol;

  private Strategy strategy;

  public ComputerPlayer(Chomp program, ChompGame game, BoardPanel board)
  {
    this.program = program;
    this.game = game;
    this.board = board;
    clock = new Timer(250, this);
  }

  //sets the strategy
  public void setStrategy(Strategy strategy)
  {
    this.strategy = strategy;
  }

 
  public String getPrompt()
  {
    return "How do you like it now";
  }

  //returns a message when computer wins
  public String getWinMessage()
  {
    return " You Lose!";
  }

  
  public void makeMove()
  {
    Location pos = strategy.findBestMove(game);
    if (pos == null)
      pos = strategy.findRandomMove(game);

    moveRow = pos.getRow();
    moveCol = pos.getCol();
    clockCount = 5;
    board.setMove(moveRow, moveCol);
    board.setDisplayCount(clockCount);
    clock.start();
  }

  public void actionPerformed(ActionEvent e)
  {
    if (clockCount > 0)
    {
      board.update(game);
      clockCount--;
    }
    else
    {
      clock.stop();
      game.makeMove(moveRow, moveCol);
      program.hasMoved();
    }
  }
}

