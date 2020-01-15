import org.junit.Test;

import java.awt.*;

import basic.model.BasicAimGame;
import basic.model.BasicTarget;
import basic.model.Position;

import static org.junit.Assert.assertEquals;

/**
 * Class holds the tests for the {@link basic.model.BasicAimGame}.
 */
public class BasicAimGameTest {

  @Test
  public void testGetTargetAt() {
    BasicAimGame b = new BasicAimGame(60);
    BasicTarget t = new BasicTarget(Color.black, 10, 10, 10, new Position(100, 100));
    b.addTarget(t);
    assertEquals(b.getTargetAt(0), t);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testGetTargetAtArgumentException() {
    BasicAimGame b = new BasicAimGame(60);
    BasicTarget t = new BasicTarget(Color.black, 10, 10, 10, new Position(100, 100));
    b.addTarget(t);
    b.getTargetAt(12);
  }

  @Test (expected = IllegalStateException.class)
  public void testGetTargetAtStateException() {
    BasicAimGame b = new BasicAimGame(0);
    BasicTarget t = new BasicTarget(Color.black, 10, 10, 10, new Position(100, 100));
    b.addTarget(t);
    b.getTargetAt(0);
  }

  @Test
  public void testAddToScore() {
    BasicAimGame b = new BasicAimGame(60);
    b.addToScore();
    assertEquals(b.getScore(), 1);
  }

  @Test (expected = IllegalStateException.class)
  public void testAddToScoreStateException() {
    BasicAimGame b = new BasicAimGame(0);
    b.addToScore();
  }

  @Test
  public void testSubtractTime() {
    BasicAimGame b = new BasicAimGame(60);
    b.subtractTime();
    assertEquals(b.getTime(), 59);
  }

  @Test (expected = IllegalStateException.class)
  public void testSubtractTimeException() {
    BasicAimGame b = new BasicAimGame(0);
    b.subtractTime();
  }

  @Test
  public void testDeleteTargetAlone() {
    BasicAimGame b = new BasicAimGame(60);
    BasicTarget t = new BasicTarget(Color.black, 10, 10, 10, new Position(100, 100));
    b.addTarget(t);
    b.deleteTarget(t);
    assertEquals(b.gameBoardSize(), 0);
  }

  @Test
  public void testDeleteTargetMultiple() {
    BasicAimGame b = new BasicAimGame(60);
    BasicTarget t = new BasicTarget(Color.black, 10, 10, 10, new Position(100, 100));
    BasicTarget z = new BasicTarget(Color.black, 10, 10, 10, new Position(200, 100));
    b.addTarget(t);
    b.addTarget(z);
    b.deleteTarget(t);
    assertEquals(b.getTargetAt(0), z);
  }
}