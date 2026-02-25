package units;

public abstract class Units {
    private int hp = 10;
    private int damage = 1;
    private boolean hasItem = false;

    public Units(int hp, int damage) {
        this.hp = hp;
        this.damage = damage;
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

    public boolean getHasItem() {
        return hasItem;
    }

    protected void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }
    
   
}
