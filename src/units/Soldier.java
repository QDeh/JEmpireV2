package units;

import items.Weapon;

public class Soldier extends Units {
    boolean hasChief = false;

    public Soldier() {
        this(20, 2, null);
    }

    protected Soldier(int hp, int damage, Weapon weapon) {
        super(hp, damage, weapon);
    }

    public void setHasChief(boolean hasChief) {
        this.hasChief = hasChief;
    }

    public boolean getHasChief() {
        return hasChief;
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

    public void equipWeapon(Weapon weapon) {
        if (weapon != null) {
            this.item = weapon;
            System.out.println("Arme équipée : " + weapon.getName() + ". Dégâts augmentés de " + weapon.getModifier() + ".");
        }else {
            System.out.println(
                    "Erreur : Impossible d'équiper une arme car il n'y en a pas de disponible.");
        }
        if (item != null) {
            this.setDamage(getDamage() + item.getModifier());

        } else {
            System.out.println(
                    "Erreur : Impossible d'équiper une arme car il y en a déja une d'équipé.");
        }
    }
}
