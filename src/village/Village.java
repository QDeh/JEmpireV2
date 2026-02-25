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

    
    public Village(String name, List<Building> buildings, List<Units> units) {
        this.name = name;
        this.buildings = buildings;
        this.units = units;
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

}
