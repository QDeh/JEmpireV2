package building;

import java.util.List;

import units.*;

public class Mine extends Building {

    public Mine(int level, List<Units> units) {
        super(level, units);
    }

    protected void assignMine(Units unit){
        if (!(unit instanceof Villager) && !(unit instanceof CraftsMan)){
            System.err.println("Vous ne pouvez pas assigner l'unité à la mine");
        }else{
            units.add(unit);
            System.out.println("L'unité à correctement été assignée à la mine");
        }
    }

    protected void unassignMine(Units unit){
        if (!units.contains(unit)){
            System.err.println("L'unité n'est pas assignée");
        }else{
            units.remove(unit);
            System.out.println("L'unité à correctement été désassignée à la mine");
        }
    }
    // faire une fonction pour récupérer les ressources en fonction du niveau du batiment et du nombre d'unités présentes; +1 pour la créer
}
