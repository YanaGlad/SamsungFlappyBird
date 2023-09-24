package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture bird;

	public static final float SCR_WIDTH = 1280;
	public static final float SCR_HEIGHT = 720;

	OrthographicCamera camera; // пересчитывает размеры для различных экранов

	int x, y;
	int birdWith, birdHeight;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bird = new Texture("bird.png");
		camera = new OrthographicCamera();

		x = 0;
		y = 0;

		birdWith = 250;
		birdHeight = 200;

		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();

		batch.draw(bird, x, y, birdWith, birdHeight);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bird.dispose();
	}
}
