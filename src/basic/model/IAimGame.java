package basic.model;

/**
 * This interface will represent an instance of the game.
 */
public interface IAimGame {

  /**
   * This function will return an individual {@link ITarget} from the game board.
   * @param location the location in the game board.
   * @return the specified {@link ITarget}.
   * @throws IllegalArgumentException if the location is less than zero or bigger
   * than the size of the game board.
   * @throws IllegalStateException if the game is over.
   */
  ITarget getTargetAt(int location);

  /**
   * Adds a point to the score if the user hits an {@link ITarget}.
   * @throws IllegalStateException if the game is over.
   */
  void addToScore();

  /**
   * Subtracts a second from the current time of the game.
   * @throws IllegalStateException if the game is over.
   */
  void subtractTime();

  /**
   * This function gets the current size of the game board.
   * @return the current size of the game board.
   * @throws IllegalStateException if the game is over.
   */
  int gameBoardSize();

  /**
   * Adds a new {@link ITarget} to the game board.
   * @param target the target to be added to the game.
   * @throws IllegalStateException if the game is over.
   */
  void addTarget(ITarget target);

  /**
   * Deletes an {@link ITarget} from the game board.
   * @param target the specified {@link ITarget} to be deleted.
   * @throws IllegalStateException if the game is over.
   */
  void deleteTarget(ITarget target);

  /**
   * Determines if the game is over.
   * @return whether the game is over.
   */
  boolean isGameOver();

  /**
   * Gets the current score of the game.
   * @return the score.
   */
  int getScore();

  /**
   * Gets the current time of the game.
   * @return the time.
   */
  int getTime();
}
