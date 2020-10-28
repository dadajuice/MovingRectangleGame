package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MovingRectangleGame extends Game {

    private Player playerOne;
    private Player playerTwo;
    private GameController controllerOne;
    private GameController controllerTwo;
    private ArrayList<Footprint> footprints;

    public MovingRectangleGame() {
        controllerOne = new GameController();
        controllerTwo = new GameController();
        controllerTwo.setDownKey(KeyEvent.VK_S);
        controllerTwo.setUpKey(KeyEvent.VK_W);
        controllerTwo.setLeftKey(KeyEvent.VK_A);
        controllerTwo.setRightKey(KeyEvent.VK_D);

        playerOne = new Player(controllerOne, Color.RED);
        playerTwo = new Player(controllerTwo, Color.GREEN);

        footprints = new ArrayList<>();
        super.addKeyListener(controllerOne);
        super.addKeyListener(controllerTwo);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }

    @Override
    public void update() {
        if (controllerOne.isQuitPressed()) {
            super.stop();
        }
        playerOne.update();
        playerTwo.update();
        if (controllerOne.isMoving()) {
            footprints.add(playerOne.layFootprint());
        }
        if (controllerTwo.isMoving()) {
            footprints.add(playerTwo.layFootprint());
        }
    }

    @Override
    public void draw(Buffer buffer) {
        for (Footprint footprint : footprints) {
            footprint.draw(buffer);
        }
        playerOne.draw(buffer);
        playerTwo.draw(buffer);
    }
}
