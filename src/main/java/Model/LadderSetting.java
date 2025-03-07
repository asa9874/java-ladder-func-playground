package Model;

public class LadderSetting
{
    private final int width;
    private final int height;

    public LadderSetting(int width, int height) {
        this.width = width-1;
        this.height = height;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
