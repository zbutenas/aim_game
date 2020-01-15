package basic.view;

import java.awt.*;

import javax.swing.*;

import basic.model.BasicAimGame;
import basic.model.BasicTarget;
import basic.model.IAimGame;

/**
 * Class represents a basic view.
 */
public class BasicView extends JFrame implements IView {
  private final IAimGame model;

  /**
   * Constructs a new view based on the given model.
   * @param m the model.
   */
  BasicView(IAimGame m) {
    this.model = m;
    this.setTitle("Aim Game");
    this.setSize(800, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void render() {
    BasicGameBoard b = new BasicGameBoard(this.model);
    b.addMouseListener(new UserMouseListener(this));
    this.add(b);
    this.setVisible(true);
  }

  public static void main(String [] args) {
    IAimGame m = new BasicAimGame(100);
    m.addTarget(new BasicTarget(Color.red, 50, 800, 800));
    m.addTarget(new BasicTarget(Color.black, 100, 800, 800));
    IView v = new BasicView(m);
    v.render();
  }
}
