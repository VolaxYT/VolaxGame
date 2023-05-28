package fr.volax.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import fr.volax.VolaxGame;
import fr.volax.data.Player;

import java.util.Iterator;

public class GameScreen implements Screen {
    final VolaxGame game;

    Texture dropImage;
    Texture bucketImage;
    private OrthographicCamera camera;
    private Viewport viewport;
    Rectangle bucket;
    Array<Rectangle> raindrops;
    long lastDropTime;
    private Player player;

    public GameScreen(VolaxGame game, Player player) {
        this.game = game;
        this.player = player;

        dropImage = new Texture(Gdx.files.internal("droplet.png"));
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.width, game.height);
        viewport = new FitViewport(game.width, game.height, camera);

        bucket = new Rectangle();
        bucket.x = game.width / 2 - 64 / 2;
        bucket.y = 20;

        bucket.width = 64;
        bucket.height = 64;

        raindrops = new Array<Rectangle>();
        spawnRaindrop();
        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.None);
    }

    @Override
    public void show() {

    }

    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, game.width - 64);
        raindrop.y = game.height;
        raindrop.width = 64;
        raindrop.height = 64;
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.fontGame.draw(game.batch, "Tears Collected: " + player.getTears(), 0, game.height);
        game.batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
        for (Rectangle raindrop : raindrops) {
            game.batch.draw(dropImage, raindrop.x, raindrop.y);
        }
        game.batch.end();

        /*
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            bucket.x = touchPos.x - 64 / 2;
        }*/

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            bucket.x -= player.getSpeed() * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            bucket.x += player.getSpeed() * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            game.setScreen(new MainMenuScreen(game, player));
            dispose();
        }

        if (bucket.x < 0)
            bucket.x = 0;
        if (bucket.x > game.width - 64)
            bucket.x = game.width - 64;

        if (TimeUtils.nanoTime() - lastDropTime > 1/player.getTearsPerSecond() * Math.pow(10,9))
            spawnRaindrop();

        Iterator<Rectangle> iter = raindrops.iterator();
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            raindrop.y -= 400 * Gdx.graphics.getDeltaTime();
            if (raindrop.y + 64 < 0)
                iter.remove();
            if (raindrop.overlaps(bucket) && raindrop.y - 20 >= bucket.y) {
                player.setTears(player.getTears() + 1);
                iter.remove();
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
        dropImage.dispose();
        bucketImage.dispose();
    }
}
