
public class Laptop {
    private String name;
    private int screenSize;
    private int memory;
    private int storage;
    private String os;
    private String colour;

    public Laptop(String name, int screenSize, int memory, int storage, String os, String colour) {
        this.name = name;
        this.screenSize = screenSize;
        this.memory = memory;
        this.storage = storage;
        this.os = os;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, диагональ экрана: %d, RAM: %dGb, ОЗУ: %dGb, ОС: %s, Цвет: %s", name, screenSize,
                 memory, storage, os, colour);
    }
    
    public String getColour() {
        return colour;
    }

    public int getMemory() {
        return memory;
    }

    public String getName() {
        return name;
    }

    public String getOs() {
        return os;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getStorage() {
        return storage;
    } 
}
