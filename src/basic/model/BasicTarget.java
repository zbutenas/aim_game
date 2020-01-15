package basic.model;

import java.awt.Color;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents a target.
 */
public class BasicTarget implements ITarget{
  private final Color color;
  private final int speed;
  private final int size;
  private double direction;
  private Position position;

  /**
   * Constructs a new target which consists of a given color, a random speed between
   * one and ten, a direction based on a random angle, and a random position based
   * on the dimensions of the game board.
   * @param c the given color.
   * @param gameWidth the game board width.
   * @param gameHeight the game board height.
   * @param s the size of the target. For this target, the radius of the circle.
   */
  public BasicTarget(Color c, int s, int gameWidth, int gameHeight) {
    this.color = c;
    this.size = s;
    this.speed = new Random().nextInt(9) + 1;
    this.direction = Math.random() * 360;
    this.position = new Position(new Random().nextInt(gameWidth - s), new Random().nextInt(gameHeight - s));
  }

  /**
   * Constructs a new target that can be accurately tested.
   * @param c the given color.
   * @param s the given size.
   * @param sp the given speed.
   * @param d the given direction.
   * @param p the given position.
   */
  public BasicTarget(Color c, int s, int sp, int d, Position p) {
    this.color = c;
    this.speed = sp;
    this.size = s;
    this.direction = d;
    this.position = p;
  }

  @Override
  public Position getLocation() {
    return this.position;
  }

  @Override
  public void moveTarget(int gameWidth, int gameHeight) {
    double xPositionAfterMove = this.position.x += this.speed * Math.cos(Math.toRadians(this.direction));
    double yPositionAfterMove = this.position.y += this.speed * Math.sin(Math.toRadians(this.direction));
    this.adjustXPosition(xPositionAfterMove, gameWidth);
    this.adjustYPosition(yPositionAfterMove, gameHeight);
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public double getDirection() {
    return this.direction;
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public String toString() {
    return "Target at " + this.position.toString() + " with size of " + this.size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicTarget t = (BasicTarget) o;
    return this.color == t.color && this.speed == t.speed && this.size == t.size &&
            this.direction == t.direction && this.position.equals(t.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this);
  }

  /**
   * This function will adjust the x position of the target. It will go through the
   * scenario of reaching the end of the game board, and the scenario of reaching the
   * beginning of the game board. If neither are reached, it adjusts the x position normally.
   * @param xPositionAfterMove the supposed x position after the move.
   * @param gameWidth the current game board width.
   */
  private void adjustXPosition(double xPositionAfterMove, int gameWidth) {
    double maxTargetWidth = xPositionAfterMove + this.size;
    double minTargetWidth = xPositionAfterMove - this.size;
    if (maxTargetWidth >= gameWidth) {
      this.targetHitMaxWidth(gameWidth);
    }
    else if (minTargetWidth <= 0) {
      this.targetHitMinWidth();
    }
    else {
      this.position.x = (int) xPositionAfterMove;
    }
  }

  /**
   * This function will adjust the y position of the target. It will go through the
   * scenario of reaching the end of the game board, and then the scenario of reaching the
   * beginning of the game board. If neither are reached, it adjusts the y position normally.
   * @param yPositionAfterMove the supposed y position after the move.
   * @param gameHeight the current game board height.
   */
  private void adjustYPosition(double yPositionAfterMove, int gameHeight) {
    double maxTargetHeight = yPositionAfterMove + this.size;
    double minTargetHeight = yPositionAfterMove - this.size;
    if (maxTargetHeight >= gameHeight) {
      this.targetHitMaxHeight(gameHeight);
    }
    else if (minTargetHeight <= 0) {
      this.targetHitMinHeight();
    }
    else {
      this.position.y = (int) yPositionAfterMove;
    }
  }

  /**
   * This function signifies that the target has hit, or will go past the width of the
   * game board. It makes the targets new x position so that the edge of the target
   * will touch the edge of the game board. It then makes a new direction between the
   * degrees of 90 and 270, which ensures that the target will go the other direction.
   * @param gameWidth the current game board width.
   */
  private void targetHitMaxWidth(int gameWidth) {
    this.position.x = gameWidth - this.size;
    this.direction = new Random().nextInt(180) + 90;
  }

  /**
It then randomly makes a new direction between either
   * 0 and 90 degrees or 270 and 360 degrees.
   */
  private void targetHitMinWidth() {
    int randomDirection = new Random().nextInt(1);
    this.position.x = this.size;
    if (randomDirection == 0) {
      this.direction = new Random().nextInt(90) + 270;
    }
    else {
      this.direction = new Random().nextInt(90);
    }
  }

  /**
   * This function signifies that the target has hit, or will go past the height of the
   * game board. It makes the new y position so that the edge of the target will touch
   * the edge of the game board. It then makes a new direction between the degrees of 180
   * and 360 so that the target will go the other direction.
   * @param gameHeight the current game board height.
   */
  private void targetHitMaxHeight(int gameHeight) {
    this.position.y = gameHeight - this.size;
    this.direction = new Random().nextInt(180) + 180;
  }

  /**
   * This function signifies that the target has hit, or will go past the height of the
   * game board. It makes the new y position so that the edge of the target will touch
   * the edge of the game board. It then makes a new direction between the degrees of 0 and
   * 180 so that the target will go the other direction.
   */
  private void targetHitMinHeight() {
    this.position.y = this.size;
    this.direction = new Random().nextInt(180);
  }
}
