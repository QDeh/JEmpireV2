package village;

import building.*;
import items.*;
import units.*;
import ressources.*;
import java.util.List;
import java.util.ArrayList;

public class Village {
    private String name;
    private List<Building> buildings = new ArrayList<>();
    private List<Units> units = new ArrayList<>();
    private List<Items> items = new ArrayList<>();

    public Village(String name, List<Building> buildings, List<Units> units, List<Items> items) {
        this.name = name;
        this.buildings = buildings;
        this.units = units;
        this.items = items;
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

    public List<Items> getItems() {
        return items;
    }

    public Weapon createWeapon(String name, int modifier, int level) {
        Weapon newWeapon = new Weapon(name, modifier, level);
        System.out.println("Arme forgée : " + newWeapon.getName() + " (Dégâts: " + newWeapon.getModifier() + ")");
        return newWeapon;
    }

    public Tools createTool(String name, int modifier, int level) {
        Tools newTool = new Tools(name, modifier, level);
        System.out.println("Outil fabriqué : " + newTool.getName() + " (Modificateur: " + newTool.getModifier() + ")");
        return newTool;
    }

    public void listItems() {
        System.out.println("Liste des armes et outils disponibles dans le village :");
        for (Units unit : units) {
            if (unit.getItem() != null) {
                System.out.println("- " + unit.getItem().getName() + " (Modificateur: " + unit.getItem().getModifier() + ")");
            }
        }
    }
    public Weapon epee = createWeapon("Sword", 5, 1);
    public Tools pioche = createTool("Pickaxe", 3, 1);
    
}
