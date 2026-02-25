package building;

import java.util.List;

import units.*;

public class Wall extends Building {

    public Wall(int level, List<Units> units) {
        super(level, units);
    }

    protected void assignWall(Units unit){
        if (!(unit instanceof Soldier)){
            System.err.println("Vous ne pouvez pas assigner l'unité au mur");
        }else{
            units.add(unit);
            System.out.println("L'unité à correctement été assignée au mur");
        }
    }

    protected void unassignWall(Units unit){
        if (!units.contains(unit)){
            System.err.println("L'unité n'est pas assignée");
        }else{
            units.remove(unit);
            System.out.println("L'unité à correctement été désassignée au mur");
        }
    }
    // faire une fonction pour donner un bonus en fonction du niveau du batiment; +1 pour la créer
}
