package week5;

import java.util.List;

public abstract class Samsung implements Phone {

    public static final int BATTERY_LIFE = 10;
    List<Contact> contacts;
    MessageHistory messageHistory;
    CallHistory callHistory;
    private String color;
    private String material;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Samsung{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}

