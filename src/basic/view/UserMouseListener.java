package basic.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import basic.controller.BasicController;
import basic.model.Position;

/**
 * Class represents the mouse listener.
 */
public class UserMouseListener extends MouseAdapter {
  private BasicController c;

  UserMouseListener(BasicController controller) {
    this.c = controller;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    Position p = new Position(e.getX(), e.getY());
  }
}
