package units;

public class Soldier extends Units {
    boolean hasChief = false;

    public void setHasChief(boolean hasChief) {
        this.hasChief = hasChief;
    }

    public boolean getHasChief() {
        return hasChief;
    }

    public Soldier() {
        this(20, 2);
    }

    protected Soldier(int hp, int damage) {
        super(hp, damage);
    }

    public boolean hasChief(Chief chief) {
        hasChief = true;
        return hasChief;
    }

    public void boostChief(Chief chief) {
        if (hasChief) {
            this.setHp(getHp() + 5);
            this.setDamage(getDamage() + 1);
        }
    }
}
