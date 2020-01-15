package basic.view;

import java.awt.event.MouseAdapter;

import javax.swing.*;

import basic.model.IAimGame;

/**
 * Class represents a basic view.
 */
public class BasicView extends JFrame implements IView {
  BasicGameBoard b;

  /**
   * Constructs a new instance of a basic view.
   * Utilizes the Java Swing library.
   */
  public BasicView() {
    this.setTitle("Aim Game");
    this.setSize(800, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void render(IAimGame model) {
    this.b = new BasicGameBoard(model);
    this.add(b);
    this.setVisible(true);
  }

  @Override
  public void addUserMouseListener(MouseAdapter listener) {
    this.b.addMouseListener(listener);
  }

  @Override
  public void repaint(IAimGame model) {
    this.createRootPane();
    this.render(model);
  }

  @Override
  public void terminate() {
    this.setVisible(false);
  }
}
