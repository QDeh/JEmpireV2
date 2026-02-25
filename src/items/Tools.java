package items;

import units.Villager;
import units.CraftsMan;

public class Tools extends Items {

    public Tools(String name, int modifier, int level) {
        super(name, modifier, level);
    }

    public void upgrade() {
        setLevel(getLevel() + 1);
        setModifier(getModifier() + 2);
    }
}
// Tools tool = new Tools("Pickaxe");