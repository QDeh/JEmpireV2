package items;

public class Tools extends Items {

    public Tools() {
        super("Outil", 3, 1);
    }

    public void upgrade() {
        setLevel(getLevel() + 1);
        setModifier(getModifier() + 2);
    }
}
// Tools tool = new Tools("Pickaxe");