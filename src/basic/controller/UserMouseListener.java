package basic.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import basic.model.Position;

/**
 * Class represents the listener for when the user clicks on the screen.
 */
public class UserMouseListener extends MouseAdapter {
  IController controller;

  UserMouseListener(IController c) {
    this.controller = c;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    controller.mouseClicked(e.getX(), e.getY());
  }
}
