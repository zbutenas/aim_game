import org.junit.Test;

import java.awt.*;

import basic.model.BasicTarget;
import basic.model.Position;

import static org.junit.Assert.*;

/**
 * This class will hold all of the tests for {@link basic.model.BasicTarget}.
 */
public class BasicTargetTest {

  @Test
  public void testGetLocation() {
    BasicTarget t = new BasicTarget(Color.black, 10, 10, 270, new Position(100, 100));
    assertEquals(t.getLocation(), new Position(100, 100));
  }

  @Test
  public void testsGetColor() {
    BasicTarget t = new BasicTarget(Color.black, 10, 10, 270, new Position(100, 100));
    assertEquals(t.getColor(), Color.black);
  }

  @Test
  public void testToString() {
    BasicTarget t = new BasicTarget(Color.black, 10, 10, 270, new Position(100, 100));
    assertEquals(t.toString(), "Target at 100 100 with size of 10");
  }

  @Test
  public void testEquals() {
    BasicTarget tOne = new BasicTarget(Color.black, 10, 10, 270, new Position(100, 100));
    BasicTarget tTwo = new BasicTarget(Color.black, 10, 10, 270, new Position(100, 100));
    assertEquals(tOne, tTwo);
  }

  @Test
  public void testMoveRegularDegrees270() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 270, new Position(100, 100));
    t.moveTarget(500, 500);
    assertEquals(new Position(100, 95), t.getLocation());
  }

  @Test
  public void testMoveRegularDegrees90() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 90, new Position(100, 100));
    t.moveTarget(500, 500);
    assertEquals(new Position(100, 105), t.getLocation());
  }

  @Test
  public void testMoveRegularDegrees180() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 180, new Position(100, 100));
    t.moveTarget(500, 500);
    assertEquals(new Position(95, 100), t.getLocation());
  }

  @Test
  public void testMoveRegularDegrees31() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 31, new Position(100, 100));
    t.moveTarget(500, 500);
    assertEquals(new Position(104, 102), t.getLocation());
  }

  @Test
  public void testMoveRegularDegrees341() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 341, new Position(100, 100));
    t.moveTarget(500, 500);
    assertEquals(new Position(104, 98), t.getLocation());
  }

  @Test
  public void testMoveRegularDegrees0() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 0, new Position(100, 100));
    t.moveTarget(500, 500);
    assertEquals(new Position(105, 100), t.getLocation());
  }

  @Test
  public void testMoveRegularDegrees360() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 360, new Position(100, 100));
    t.moveTarget(500, 500);
    assertEquals(new Position(105, 100), t.getLocation());
  }

  @Test
  public void testMoveHitMaxGreaterThanPositionX() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 0, new Position(489, 100));
    t.moveTarget(500, 500);
    assertEquals(new Position(490, 100), t.getLocation());
  }

  @Test
  public void testMoveHitMaxGreaterThanDirectionX() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 0, new Position(499, 100));
    t.moveTarget(500, 500);
    assertNotEquals(t.getDirection(), 0.);
  }

  @Test
  public void testMoveHitMaxGreaterThanPositionY() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 90, new Position(100, 489));
    t.moveTarget(500, 500);
    assertEquals(new Position(100, 490), t.getLocation());
  }

  @Test
  public void testMoveHitMaxGreaterThanDirectionY() {
    BasicTarget t = new BasicTarget(Color.black, 10, 5, 90, new Position(499, 100));
    t.moveTarget(500, 500);
    assertNotEquals(t.getDirection(), 90.);
  }
}