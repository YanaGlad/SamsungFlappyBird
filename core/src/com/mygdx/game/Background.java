package com.mygdx.game;

import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Background {
    Texture background;
    float backgroundX;
    float backgroundX2;

    float speed = 15;

    Background() {
        backgroundX = 0;
        backgroundX2 = SCR_WIDTH;
        background = new Texture("background.png");
    }

    void draw(Batch batch) {
        batch.draw(background, backgroundX, 0, SCR_WIDTH + speed, SCR_HEIGHT);
        batch.draw(background, backgroundX2, 0, SCR_WIDTH + speed, SCR_HEIGHT);

        backgroundX -= speed;
        backgroundX2 -= speed;

        if (backgroundX < -SCR_WIDTH) {
            backgroundX = SCR_WIDTH;
        }
        if (backgroundX2 < -SCR_WIDTH) {
            backgroundX2 = SCR_WIDTH;
        }
    }
}
