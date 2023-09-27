package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Bird bird;

    Texture gameOver;

    Background background;

    boolean isGameOver = false;

    Tube[] downTubes;
    Tube[] upTubes;

    public static float SCR_WIDTH = 1280;
    public static float SCR_HEIGHT = 720;

    int distanceBetweenTubes = 800;

    Sound hitSound;

    private int tubeCount = 4;

    @Override
    public void create() {
        batch = new SpriteBatch();

        bird = new Bird(200, SCR_HEIGHT / 2, 10, 250, 200);

        initTubes();

        SCR_WIDTH = Gdx.graphics.getWidth();
        SCR_HEIGHT = Gdx.graphics.getHeight();

        gameOver = new Texture("gameover.png");
        background = new Background();

        hitSound = Gdx.audio.newSound(Gdx.files.internal("hit.mp3"));
    }

    void initTubes() {
        downTubes = new Tube[tubeCount];
        for (int i = 0; i < downTubes.length; i++) {
            downTubes[i] = new Tube(SCR_WIDTH + distanceBetweenTubes * (i + 1), distanceBetweenTubes, false);
        }

        upTubes = new Tube[tubeCount];
        for (int i = 0; i < upTubes.length; i++) {
            upTubes[i] = new Tube(SCR_WIDTH + distanceBetweenTubes * (i + 1), distanceBetweenTubes, true);
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();

        background.draw(batch);

        if (!isGameOver) {
            bird.draw(batch);
            bird.fly();
            if (Gdx.input.justTouched()) {
                bird.onClick();
            }
            for (int i = 0; i < tubeCount; i++) {
                downTubes[i].draw(batch);
                upTubes[i].draw(batch);
                downTubes[i].move();
                upTubes[i].move();
                if (upTubes[i].hit(bird) || downTubes[i].hit(bird)) {
                    isGameOver = true;
                    hitSound.play();
                }
            }
        }

        if (isGameOver) {
            batch.draw(gameOver, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            if (Gdx.input.justTouched()) {
                isGameOver = false;
                bird.y = SCR_HEIGHT / 2;
                initTubes();
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bird.dispose();
        gameOver.dispose();
        for (int i = 0; i < downTubes.length; i++) {
            downTubes[i].dispose();
        }
        for (int i = 0; i < upTubes.length; i++) {
            upTubes[i].dispose();
        }
    }
}
