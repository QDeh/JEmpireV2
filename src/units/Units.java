package units;

public abstract class Units {
    private int hp;
    private int damage;
    private boolean hasItem = false;

    public Units(){
        this(10, 1);
    }
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
