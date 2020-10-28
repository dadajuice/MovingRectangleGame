package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.controls.MovementController;
import cegepst.engine.entity.ControllableEntity;

import java.awt.*;

public class Player extends ControllableEntity {

    public Player(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        teleport(100, 100);
        setSpeed(4);
    }

    public Footprint layFootprint() {
        return new Footprint(x, y);
    }

    @Override
    public void update() {
        moveAccordingToHandler();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.red);
    }
}
