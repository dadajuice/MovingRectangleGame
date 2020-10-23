package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

import java.awt.*;
import java.util.ArrayList;

public class MovingRectangleGame extends Game {

    private Player player;
    private InputHandler inputHandler;
    private ArrayList<Footprint> footprints;

    public MovingRectangleGame() {
        inputHandler = new InputHandler();
        player = new Player(inputHandler);
        footprints = new ArrayList<>();
        super.addKeyListener(inputHandler); // Viens de Game
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }

    @Override
    public void update() {
        if (inputHandler.isQuitPressed()) {
            super.stop();
        }
        player.update();
        if (inputHandler.isMoving()) {
            footprints.add(player.layFootprint());
        }
    }

    @Override
    public void draw(Buffer buffer) {
        for (Footprint footprint : footprints) {
            footprint.draw(buffer);
        }
        player.draw(buffer);
    }
}
