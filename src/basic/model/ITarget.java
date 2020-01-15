package basic.model;

import java.awt.Color;

/**
 * Represents a target.
 */
public interface ITarget {

  /**
   * This function gets the current position of this target.
   * @return the current position.
   */
  Position getLocation();

  /**
   * Moves the target based on the targets direction and speed. If the target has moved off
   * of the screen, it is given a new direction.
   * @param gameWidth the current gameWidth.
   * @param gameHeight the current gameHeight.
   */
  void moveTarget(int gameWidth, int gameHeight);

  /**
   * Gets the color of the target.
   * @return the color.
   */
  Color getColor();

  /**
   * Gets the direction of the target.
   * @return the direction.
   */
  double getDirection();

  /**
   * Gets the size of the target.
   * @return the size.
   */
  int getSize();
}
