package chomp;

public interface Strategy
{
  Location findBestMove(ChompGame game);
  Location findRandomMove(ChompGame game);
}