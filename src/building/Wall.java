package building;

import java.util.List;

import units.*;

public class Wall extends Building {

    public Wall(int level, List<Units> units) {
        super(level, units);
    }

    @Override
    public boolean assign(Units unit){
        if (!(unit instanceof Soldier)){
            System.err.println("Vous ne pouvez pas assigner l'unité au mur");
            return false;
        }
        boolean result = super.assign(unit);
        if(result) {
            System.out.println("L'unité à correctement été assignée au mur");
        }
        return result;
    }
    // faire une fonction pour donner un bonus en fonction du niveau du batiment; +1 pour la créer
}
