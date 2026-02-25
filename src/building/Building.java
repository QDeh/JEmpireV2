package building;

import java.util.ArrayList;
import java.util.List;
import units.*;
import village.Village;

public abstract class Building {
    int level = 1;
    List<Units> units = new ArrayList<>(); 

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

}
