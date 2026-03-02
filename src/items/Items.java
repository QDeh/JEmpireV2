package items;

public class Items {
    private String name;
    private int modifier = 0;
    private int level = 1;

    public Items(String name, int modifier, int level) {
        this.name = name;
        this.modifier = modifier;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getModifier() {
        return modifier;
    }

    protected void setModifier(int modifier) {
        this.modifier = modifier;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }
}
