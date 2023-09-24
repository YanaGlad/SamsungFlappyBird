package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {

    float x, y;
    float birdWith, birdHeight;
    int speed;
    boolean jump = true;

    Texture img;

    float jumpHeight;

    public Bird(float x, float y, int speed, float birdWith, float birdHeight) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.birdWith = birdWith;
        this.birdHeight = birdHeight;

        img = new Texture("bird.png");
    }

    void onClick() {
        jump = true;
        jumpHeight = 200f + y;
    }

    void fly() {
        if (y >= jumpHeight) {
            jump = false;
        }

        if (jump) {
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
