package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Bird bird;

    public static float SCR_WIDTH = 1280;
    public static float SCR_HEIGHT = 720;

    OrthographicCamera camera; // пересчитывает размеры для различных экранов

    @Override
    public void create() {
        batch = new SpriteBatch();
        bird = new Bird(0, 0, 5, 250, 200);

        SCR_WIDTH = Gdx.graphics.getWidth();
        SCR_HEIGHT = Gdx.graphics.getHeight();
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();

        bird.draw(batch);
        bird.fly();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bird.dispose();
    }
}
