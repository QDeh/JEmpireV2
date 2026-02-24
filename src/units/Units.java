package units;

public abstract class Units {
    int hp = 10;
    int damage = 1;
    
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

   
}
