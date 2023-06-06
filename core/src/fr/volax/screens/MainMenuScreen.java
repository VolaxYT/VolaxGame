package fr.volax.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import fr.volax.VolaxGame;
import fr.volax.data.Player;
import fr.volax.utils.TextUtil;

public class MainMenuScreen implements Screen {
    final VolaxGame game;
    OrthographicCamera camera;
    Texture logo;
    private Player player;

    public MainMenuScreen(VolaxGame game, Player player) {
        this.game = game;
        this.player = player;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.width, game.height);

        logo = new Texture(Gdx.files.internal("logo.png"));
        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        TextUtil.drawAlignedText(game.batch, game.fontMainMenu, "Press space to start !", game.width / 2, game.height / 3);
        TextUtil.drawAlignedText(game.batch, game.fontMainMenu, "Press B to open the shop !", game.width / 2, game.height / 3 - 80);
        game.batch.draw(logo, game.width / 9.5f, game.height / 2, 1000, 333);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.setScreen(new GameScreen(game, player));
            dispose();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
            game.setScreen(new ShopScreen(game, player));
            dispose();
        }
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
