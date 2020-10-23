package cegepst;

import cegepst.engine.Buffer;

import java.awt.*;
import java.util.Random;

public class Footprint {

    private int x;
    private int y;
    private int width = 5;
    private int height = 5;

    public Footprint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Buffer buffer) {
        Color color = new Color(getRandomValue(),
                getRandomValue(), getRandomValue());
        buffer.drawRectangle(x, y, width, height, color);
    }

    private int getRandomValue() {
        return (new Random()).nextInt(256);
    }
}
