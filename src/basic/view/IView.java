package basic.view;

import java.awt.event.MouseAdapter;

import basic.model.IAimGame;

/**
 * Interface represents the view.
 */
public interface IView {

  /**
   * Renders the view given a model.
   */
  void render(IAimGame model);

  /**
   * Adds the mouse listener to the view.
   * I chose this design choice so that the controller could
   * retain all the 'power' in this application.
   * @param listener the mouse listener.
   */
  void addUserMouseListener(MouseAdapter listener);

  /**
   * Re-renders the application without deleting the current screen.
   * @param model the updated model.
   */
  void repaint(IAimGame model);

  /**
   * Kills the view.
   */
  void terminate();
}
