package building;

import java.util.List;
import units.*;

public class Barraks extends Building {

    public Barraks(int level, List<Units> units) {
        super(level, units);
    }

    @Override
    public boolean assign(Units unit){
        if (!(unit instanceof Soldier)){
            System.err.println("Vous ne pouvez pas assigner l'unité à la caserne");
            return false;
        }
        boolean result = super.assign(unit);
        if(result) {
            System.out.println("L'unité à correctement été assignée à la caserne");
        }
        return result;
    }
    // faire une fonction pour récupérer les ressources en fonction du niveau du batiment et du nombre d'unités présentes; +1 pour la créer
}
