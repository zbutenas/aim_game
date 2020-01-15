package basic.controller;

import java.awt.*;

import basic.model.BasicTarget;
import basic.model.IAimGame;
import basic.model.ITarget;
import basic.model.Position;
import basic.view.IView;

/**
 * The controller for the basic game mode.
 */
public class BasicController implements IController {
  private IAimGame model;
  private IView view;

  /**
   * Constructs a new controller given a version of the model and a version of the view.
   * @param m the model.
   * @param v the view.
   */
  public BasicController(IAimGame m, IView v) {
    this.model = m;
    this.view = v;
  }

  @Override
  public void launchGame() throws InterruptedException {
    this.view.render(this.model);
    this.view.addUserMouseListener(new UserMouseListener(this));
    Thread move = new Thread(this::moveTargets);
    Thread realTime = new Thread(() -> {
      try {
        initiateGame();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    realTime.start();
    move.start();
    realTime.join();
    move.join();
  }

  @Override
  public void updateScreen() {
    this.view.repaint(this.model);
  }

  @Override
  public void mouseClicked(int xCord, int yCord) {
    for (int ii = 0; ii < this.model.gameBoardSize(); ++ii) {
      ITarget target = this.model.getTargetAt(ii);
      if (target.getLocation().equals(new Position(xCord, yCord))) {
        this.model.deleteTarget(target);
      }
    }
  }

  /**
   * This function will serve at the director for the game.
   */
  private void initiateGame() throws InterruptedException {
    while (!this.model.isGameOver()) {
      this.model.addTarget(new BasicTarget(Color.black, 10, 500, 500));
      this.model.subtractTime();
      this.updateScreen();
      Thread.sleep(1000);
    }
    this.view.terminate();
  }

  /**
   * Moves all of the targets.
   */
  private void moveTargets() {
    while (!this.model.isGameOver()) {
      for (int ii = 0; ii < this.model.gameBoardSize(); ++ii) {
        ITarget target = this.model.getTargetAt(ii);
        target.moveTarget(500, 500);
      }
      updateScreen();
    }
  }
}
