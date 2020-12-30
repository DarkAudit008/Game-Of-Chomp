package chomp;


//for the player moves
public interface Player
{
  String getPrompt();
  String getWinMessage();
  void makeMove();
}