package village;

import building.*;
import units.*;
import ressources.*;
import java.util.List;
import java.util.ArrayList;

public class Village {
    private String name;
    private List<Building> buildings = new ArrayList<>();
    private List<Units> units = new ArrayList<>();
    private List<Ressources> ressources = List.of(Wood wood, Stone stone, Iron iron, Gold gold, Food food);

    
    public Village(String name, List<Building> buildings, List<Units> units, List<Ressources> ressources) {
        this.name = name;
        this.buildings = buildings;
        this.units = units;
        this.ressources = ressources;
    }

    public String getName() {
        return name;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<Units> getUnits() {
        return units;
    }

    public List<Ressources> getRessources() {
        return ressources;
    }
}
