package basic;

import basic.controller.BasicController;
import basic.controller.IController;
import basic.model.BasicAimGame;
import basic.model.IAimGame;
import basic.view.BasicView;
import basic.view.IView;

public class BasicMain {

  public static void main(String[] args) throws InterruptedException {
    IAimGame model = new BasicAimGame(60);
    IView view = new BasicView();
    IController controller = new BasicController(model, view);
    controller.launchGame();
  }
}
