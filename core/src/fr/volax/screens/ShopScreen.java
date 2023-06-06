package fr.volax.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import fr.volax.VolaxGame;
import fr.volax.data.Player;
import fr.volax.utils.TextUtil;

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
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        TextUtil.drawAlignedText(game.batch, game.fontMainMenu, "Shop", game.width / 2, game.height / 1.05f);
        TextUtil.drawAlignedText(game.batch, game.fontMainMenu, "Tears: " + player.getTears(), game.width / 2, game.height / 1.05f - 50);
        TextUtil.drawAlignedText(game.batch, game.fontMainMenu, "Press 1 | + 10 speed | " + Math.round(player.getPriceSpeed()) + " tears", game.width / 2, game.height / 3);
        TextUtil.drawAlignedText(game.batch, game.fontMainMenu, "Press 2 | + 1 tear par second | " + Math.round(player.getPriceTearsPerSecond()) + " tears", game.width / 2, game.height / 3 - 80);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            game.setScreen(new MainMenuScreen(game, player));
            dispose();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1) && Math.round(player.getPriceSpeed()) <= player.getTears()){
            System.out.println("achat 1");
            player.setTears(player.getTears() - Math.round(player.getPriceSpeed()));
            player.setSpeed(player.getSpeed() + 10);
            player.setPriceSpeed(player.getPriceSpeed() * 1.06f);
            dispose();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2) && Math.round(player.getPriceTearsPerSecond()) <= player.getTears()){
            System.out.println("achat 2");
            player.setTears(player.getTears() - Math.round(player.getPriceTearsPerSecond()));
            player.setTearsPerSecond(player.getTearsPerSecond() + 1);
            player.setPriceTearsPerSecond(player.getPriceTearsPerSecond() * 1.06f);
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
