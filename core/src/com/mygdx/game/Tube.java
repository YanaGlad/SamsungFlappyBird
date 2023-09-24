package com.mygdx.game;


import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class Tube {

    Texture img;

    float x, y;

    int speed = 10;

    float width = 200;
    float height = 700;

    float startY;

    float highest = 200;
    float lowest = 350;

    float initialX;

    Random random;

    int distanceBetweenTubes;

    boolean isUpTube;

    public Tube(float x, int distanceBetweenTubes, boolean isUpTube) {
        this.x = x;
        this.isUpTube = isUpTube;
        this.distanceBetweenTubes = distanceBetweenTubes;

        random = new Random();

        y = random.nextInt(300);

        initialX = x;
        if (isUpTube) {
            img = new Texture("tube_flip.png");
        } else {
            img = new Texture("tube.png");
        }

        if (isUpTube) {
            startY = SCR_HEIGHT + highest;
        } else {
            startY = -lowest;
        }
    }

    void draw(Batch batch) {
        batch.draw(img, x, startY - y, width, height);
    }

    void move() {
        x -= speed;
        if (x < -width) {
            x = SCR_WIDTH + distanceBetweenTubes;
            y = random.nextInt(300);
        }
    }

    void dispose() {
        img.dispose();
    }
}
