package building;

import java.util.List;
import units.*;

public class Barraks extends Building {

    public Barraks(int level, List<Units> units) {
        super(level, units);
    }

    protected void assignBarraks(Units unit){
        if (!(unit instanceof Soldier)){
            System.err.println("Vous ne pouvez pas assigner l'unité à la caserne");
        }else{
            units.add(unit);
            System.out.println("L'unité à correctement été assignée à la Caserne");
        }
    }

    protected void unassignBarraks(Units unit){
        if (!units.contains(unit)){
            System.err.println("L'unité n'est pas assignée");
        }else{
            units.remove(unit);
            System.out.println("L'unité à correctement été désassignée à la caserne");
        }
    }
    // faire une fonction pour récupérer les ressources en fonction du niveau du batiment et du nombre d'unités présentes; +1 pour la créer
}
