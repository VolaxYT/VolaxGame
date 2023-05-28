package fr.volax;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.volax.data.Player;
import fr.volax.screens.MainMenuScreen;

public class VolaxGame extends Game {
    public int width, height;
    public SpriteBatch batch;
    public BitmapFont fontMainMenu;
    public BitmapFont fontGame;

    public VolaxGame(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void create() {
        batch = new SpriteBatch();
        fontMainMenu = new BitmapFont();
        fontGame = new BitmapFont();
        fontMainMenu.getData().setScale(3);
        fontGame.getData().setScale(2);
        this.setScreen(new MainMenuScreen(this, new Player()));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        fontMainMenu.dispose();
    }
}
