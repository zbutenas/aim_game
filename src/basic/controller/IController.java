package basic.controller;

/**
 * Interface represents the controller for this application.
 */
public interface IController {

  /**
   * Launches the initial game.
   */
  void launchGame() throws InterruptedException;

  /**
   * Updates the current screen of the game.
   */
  void updateScreen();

  /**
   * This will possibly mutate the model by deleting a target
   * depending on where the user clicked.
   * @param xCord the x value of where the user clicked.
   * @param yCord the y value of where the user clicked.
   */
  void mouseClicked(int xCord, int yCord);
}
