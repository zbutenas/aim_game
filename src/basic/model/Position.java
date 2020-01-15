package basic.model;

import java.util.Objects;

/**
 * This class represents a position for a target.
 */
public class Position {
  public int x;
  public int y;

  /**
   * This constructs a new coordinate for a target.
   *
   * @param xValue the x-axis position of the target.
   * @param yValue the y-value position of the target.
   */
  public Position(int xValue, int yValue) {
    this.x = xValue;
    this.y = yValue;
  }

  @Override
  public String toString() {
    return x + " " + y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position p = (Position) o;
    return x == p.x
            && y == p.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x + y);
  }
}
