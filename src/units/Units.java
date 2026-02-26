package units;

import items.*;

public abstract class Units {
    private int hp;
    private int damage;
    protected Items item;

    public Units(int hp, int damage, Items item) {
        this.hp = hp;
        this.damage = damage;
        this.item = item;
    }

    public Units() {
        this(10, 1, null);
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    protected void setHp(int hp) {
        this.hp = hp;
    }

    protected void setDamage(int damage) {
        this.damage = damage;

    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }
}
