package chomp;

import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Chomp extends JFrame
{
  private ChompGame chGame;
  private JTextField dis;
  private Player players[];
  private int currentPlayer;

  public Chomp()
  {
    Container c = getContentPane();

    dis = new JTextField(20);
    dis.setBackground(Color.GREEN);
    dis.setEditable(false);
    c.add(dis, BorderLayout.NORTH);

    BoardPanel board = new BoardPanel();
    c.add(board, BorderLayout.CENTER);

    chGame = new ChompGame(board);

    HumanPlayer human = new HumanPlayer(this, chGame, board);
    ComputerPlayer computer = new ComputerPlayer(this, chGame, board);
    computer.setStrategy(new chompStrategy());

    players = new Player[2];
    players[0] = human;
    players[1] = computer;
    currentPlayer = 0;

    dis.setText(" You go first...");
    players[currentPlayer].makeMove();
  }


  public void hasMoved()
  {
    currentPlayer = (currentPlayer + 1) % 2;
    Player p = players[currentPlayer];
    if (chGame.isWon())
    {
      dis.setText(p.getWinMessage());
    }
    else
    {
      dis.setText(p.getPrompt());
      p.makeMove();
    }
  }

  public static void main(String[] args)
  {
    Chomp window = new Chomp();
    window.setTitle("Chomp");
    window.setBounds(200, 200, 300, 270);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
}
