package basic.model;

import java.util.ArrayList;

/**
 * This class represents a basic version of the aim game.
 */
public class BasicAimGame implements IAimGame{
  private int time;
  private int score;
  private ArrayList<ITarget> board;

  /**
   * Constructs a new game based on a specified time.
   * @param timeAllowed the number that the timer will start at.
   */
  public BasicAimGame(int timeAllowed) {
    this.time = timeAllowed;
    this.score = 0;
    this.board = new ArrayList<>();
  }

  @Override
  public ITarget getTargetAt(int location) {
    if (location > this.board.size() || location < 0) {
      throw new IllegalArgumentException("Location does not exists.");
    }
    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    }
    return this.board.get(location);
  }

  @Override
  public void addToScore() {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    }
    this.score ++;
  }

  @Override
  public void subtractTime() {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    }
    this.time --;
  }

  @Override
  public int gameBoardSize() {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    }
    return this.board.size();
  }

  @Override
  public void addTarget(ITarget target) {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    }
    this.board.add(target);
  }

  @Override
  public void deleteTarget(ITarget target) {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    }
    this.board.removeIf(t -> t.equals(target));
  }

  @Override
  public boolean isGameOver() {
    return this.time <= 0;
  }

  @Override
  public int getScore() {
    return this.score;
  }

  @Override
  public int getTime() {
    return this.time;
  }
}
