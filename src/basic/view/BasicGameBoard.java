package basic.view;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

import basic.model.IAimGame;
import basic.model.ITarget;

/**
 * Class will paint the game board.
 */
public class BasicGameBoard extends JPanel {
  private final IAimGame model;

  /**
   * Constructs the game board based off of the model.
   * @param m the model.
   */
  BasicGameBoard(IAimGame m) {
    this.model = m;
    this.setSize(800, 800);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for (int ii = 0; ii < this.model.gameBoardSize(); ++ii) {
      ITarget t = this.model.getTargetAt(ii);
      Ellipse2D.Double circle = new Ellipse2D.Double(t.getLocation().x, t.getLocation().y, t.getSize(), t.getSize());
      g2d.setColor(t.getColor());
      g2d.fill(circle);
    }
  }
}
