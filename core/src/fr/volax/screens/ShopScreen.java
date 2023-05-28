package fr.volax.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import fr.volax.VolaxGame;
import fr.volax.data.Player;

public class ShopScreen implements Screen {
    final VolaxGame game;
    private Player player;
    private OrthographicCamera camera;


    public ShopScreen(VolaxGame game, Player player) {
        this.game = game;
        this.player = player;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.width, game.height);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
