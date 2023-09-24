package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Bird bird;

    public static final float SCR_WIDTH = 1280;
    public static final float SCR_HEIGHT = 720;

    OrthographicCamera camera; // пересчитывает размеры для различных экранов

    @Override
    public void create() {
        batch = new SpriteBatch();
        bird = new Bird(200, SCR_HEIGHT / 2, 10, 250, 200);
        camera = new OrthographicCamera();

        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();

        bird.draw(batch);
        bird.fly();

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bird.dispose();
    }
}
