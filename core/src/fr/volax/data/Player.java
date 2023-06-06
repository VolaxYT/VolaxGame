package fr.volax.data;

public class Player {
    private int tears;
    private float tearsPerSecond;
    private int speed;
    private float priceSpeed, priceTearsPerSecond;

    public Player() {
        this.tears = 0;
        this.tearsPerSecond = 1f;
        this.speed = 500;
        this.priceSpeed = 10;
        this.priceTearsPerSecond = 100;
    }


    public int getTears() {
        return tears;
    }

    public void setTears(int tears) {
        this.tears = tears;
    }

    public float getTearsPerSecond() {
        return tearsPerSecond;
    }

    public void setTearsPerSecond(int tearsPerSecond) {
        this.tearsPerSecond = tearsPerSecond;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTearsPerSecond(float tearsPerSecond) {
        this.tearsPerSecond = tearsPerSecond;
    }

    public float getPriceSpeed() {
        return priceSpeed;
    }

    public void setPriceSpeed(float priceSpeed) {
        this.priceSpeed = priceSpeed;
    }

    public float getPriceTearsPerSecond() {
        return priceTearsPerSecond;
    }

    public void setPriceTearsPerSecond(float priceTearsPerSecond) {
        this.priceTearsPerSecond = priceTearsPerSecond;
    }
}
