package cegepst.engine.entity;

import cegepst.InputHandler;

public abstract class ControllableEntity extends MovableEntity {

    private InputHandler inputHandler;

    public ControllableEntity(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void moveAccordingToHandler() {
        if (!inputHandler.isMoving()) {
            return;
        }
        if (inputHandler.isUpPressed()) {
            moveUp();
        } else if (inputHandler.isDownPressed()) {
            moveDown();
        } else if (inputHandler.isRightPressed()) {
            moveRight();
        } else if (inputHandler.isLeftPressed()) {
            moveLeft();
        }
    }
}
