package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {

    int x, y;
    int birdWith, birdHeight;
    int speed = 5;
    boolean up = true;

    Texture img;

    public Bird(int x, int y, int speed, int birdWith, int birdHeight) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.birdWith = birdWith;
        this.birdHeight = birdHeight;

        img = new Texture("bird.png");
    }

    void fly() {
        if (y >= MyGdxGame.SCR_HEIGHT) {
            up = false;
        }
        if (y <= 0) {
            up = true;
        }

        if (up) {
            y += speed;
        } else {
            y -= speed;
        }
    }

    void draw(Batch batch) {
        batch.draw(img, x, y, birdWith, birdHeight);
    }

    void dispose() {
        img.dispose();
    }
}
