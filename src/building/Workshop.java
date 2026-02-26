package building;

import java.util.List;
import items.*;
import units.*;

public class Workshop extends Building {

    public Workshop(int level, List<Units> units) {
        super(level, units);
    }

    @Override
    public boolean assign(Units unit){
        if (!(unit instanceof CraftsMan)){
            System.err.println("Vous ne pouvez pas assigner l'unité à l'atelier");
            return false;
        }
        boolean result = super.assign(unit);
        if(result) {
            System.out.println("L'unité à correctement été assignée à l'atelier");
        }
        return result;
    }
    // faire une fonction pour donner un bonus en fonction du niveau du batiment; +1
    // pour la créer
}
