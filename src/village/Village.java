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
    private Ressources ressources = new Ressources();
    private int day = 1;

    public Village(String name) {
        this.name = name;
        units.add(new Villager());
    }

    public Village(String name, List<Building> buildings, List<Units> units, Ressources ressources, int day) {
        this(name);
        this.buildings = buildings;
        this.units = units;
        this.ressources = ressources;
        this.day = day;
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

    public int getDay() {
        return day;
    }

    public Ressources getRessources() {
        return ressources;
    }


    public void FinishDay(){
        day++;
        // à compléter
    }

    public void displayRessources() {
        int wood = ressources.getWood();
        int stone = ressources.getStone();
        int iron = ressources.getIron();
        int gold = ressources.getGold();
        int food = ressources.getFood();
        System.out.println("Ressources :");
        System.out.printf("Bois : %d | Pierre : %d | Fer : %d | Or : %d | Nourriture : %d%n%n",wood,stone,iron,gold,food);
    }

    public void displayVillagers() {
        System.out.println("Unités :");
        int i = 1;
        for (Units unit : units){
            System.out.printf( "%d - type : %s | pv : %d | dégâts : %d",i, unit.getClass().getSimpleName(), unit.getHp(), unit.getDamage());
            i++;
        }
        System.out.println("\n");
    }

    public void displayBuildings() {
        System.out.println("Bâtiments :");
        int i = 1;
        for (Building building : buildings){
            System.out.printf( "%d - type : %s | niveau : %d",i, building.getClass().getSimpleName(), building.getLevel());
            i++;
        }
    }

    
}
