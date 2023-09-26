package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Bird bird;

    Tube[] downTubes;
    Tube[] upTubes;

    public static final float SCR_WIDTH = 1280;
    public static final float SCR_HEIGHT = 720;

    OrthographicCamera camera; // пересчитывает размеры для различных экранов

    int distanceBetweenTubes = 800;

    @Override
    public void create() {
        batch = new SpriteBatch();

        bird = new Bird(200, SCR_HEIGHT / 2, 10, 250, 200);

        downTubes = new Tube[3];
        for (int i = 0; i < downTubes.length; i++) {
            downTubes[i] = new Tube(SCR_WIDTH + distanceBetweenTubes * (i + 1), distanceBetweenTubes, false);
        }

        upTubes = new Tube[3];
        for (int i = 0; i < upTubes.length; i++) {
            upTubes[i] = new Tube(SCR_WIDTH + distanceBetweenTubes * (i + 1), distanceBetweenTubes, true);
        }

        camera = new OrthographicCamera();

        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();

        for (Tube tube : downTubes) {
            tube.draw(batch);
            tube.move();
            if(tube.hit(bird)) {
                System.out.println("down hit");
            }
        }

        for (Tube tube : upTubes) {
            tube.draw(batch);
            tube.move();
            if(tube.hit(bird)) {
                System.out.println("up hit");
            }
        }

        bird.draw(batch);
        bird.fly();

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }
        camera.update();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bird.dispose();
        for (int i = 0; i < downTubes.length; i++) {
            downTubes[i].dispose();
        }
        for (int i = 0; i < upTubes.length; i++) {
            upTubes[i].dispose();
        }
    }
}
