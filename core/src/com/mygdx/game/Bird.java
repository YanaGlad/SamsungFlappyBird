package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {

    float x, y;
    float birdWith, birdHeight;
    int speed;
    boolean jump = true;

    Texture[] frames;

    int frame = 0;

    float jumpHeight;

    public Bird(float x, float y, int speed, float birdWith, float birdHeight) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.birdWith = birdWith;
        this.birdHeight = birdHeight;

        frames = new Texture[]{
                new Texture("bird.png"),
                new Texture("bird.png"),
                new Texture("bird.png"),
                new Texture("bird_2.png"),
                new Texture("bird_2.png"),
                new Texture("bird_2.png")
        };
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
        batch.draw(frames[frame], x, y, birdWith, birdHeight);

        if (frame++ == frames.length - 1) frame = 0;
    }

    void dispose() {
        for (int i = 0; i < frames.length; i++) {
            frames[i].dispose();
        }
    }
}
