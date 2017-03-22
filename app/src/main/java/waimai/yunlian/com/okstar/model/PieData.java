package waimai.yunlian.com.okstar.model;

/**
 * Created by Stran on 2016/12/25.
 */

public class PieData {
    private String name;
    private int value;
    private int percentage;
    private float color;
    private float angle;

    public PieData(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public float getColor() {
        return color;
    }

    public void setColor(float color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "PieData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", percentage=" + percentage +
                ", color=" + color +
                ", angle=" + angle +
                '}';
    }
}
