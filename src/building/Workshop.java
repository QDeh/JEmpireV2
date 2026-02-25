package building;

import java.util.List;

import units.*;

public class Workshop extends Building {

    public Workshop(int level, List<Units> units) {
        super(level, units);
    }

    protected void assignWorkshop(Units unit){
        if (!(unit instanceof CraftsMan)){
            System.err.println("Vous ne pouvez pas assigner l'unité à l'atelier");
        }else{
            units.add(unit);
            System.out.println("L'unité à correctement été assignée à l'atelier'");
        }
    }

    protected void unassignWorkshop(Units unit){
        if (!units.contains(unit)){
            System.err.println("L'unité n'est pas assignée");
        }else{
            units.remove(unit);
            System.out.println("L'unité à correctement été désassignée à l'atelier'");
        }
    }
    // faire une fonction pour donner un bonus en fonction du niveau du batiment; +1 pour la créer
}
