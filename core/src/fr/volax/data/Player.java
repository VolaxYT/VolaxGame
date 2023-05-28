package fr.volax.data;

public class Player {
    private int tears;
    private float tearsPerSecond;
    private int speed;

    public Player() {
        this.tears = 0;
        this.tearsPerSecond = 1f;
        this.speed = 500;
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
}
