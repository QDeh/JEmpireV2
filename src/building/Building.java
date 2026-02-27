package building;

import java.util.ArrayList;
import java.util.List;
import units.*;
import village.Village;

public abstract class Building {
    private int level = 1;
    private List<Units> units = new ArrayList<>(); 

    public Building(int level, List<Units> units) {
        this.level = level;
        this.units = units;
    }

    public int getLevel() {
        return level;
    }

    public List<Units> getUnits() {
        return units;
    }

    public int checkLevel(){
        if (level >= 10){
            System.out.println("Niveau maximum atteint !");
            level = 10;
        }
        return level;
    }

    public boolean assign(Units unit) {
        if (units.contains(unit)) {
            System.err.println("L'unité est déjà assignée à ce bâtiment");
            return false;
        } else if(units.size() >= getLevel()) {
            System.err.println("Le bâtiment est déjà plein");
            return false;
        } else {
            units.add(unit);
            return true;
        }
    }

    public void unassign(Units unit) {
        if (!units.contains(unit)) {
            System.err.println("L'unité n'est pas assignée à ce bâtiment");
        } else {
            units.remove(unit);
        }
    }

}
