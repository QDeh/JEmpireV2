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
    private Ressources ressources = new Ressources();
    private int day = 1;
    private List<Items> items = new ArrayList<>();


    public Village(String name) {
        this.name = name;
        buildings.add(new building.House(1, new ArrayList<>(List.of(new Villager()))));
    }

    public Village(String name, List<Building> buildings, Ressources ressources, List<Items> items,int day) {
        this(name);
        this.buildings = buildings;
        this.ressources = ressources;
        this.day = day;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPopulation() {
        return getUnits().size();
    }
    public int getPopulationMax() {
        int population = 0;
        for (Building building : buildings) {
            if(building instanceof House) {
                House house = (House) building;
                population += house.getLevel();
            }
        }
        return population;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public int getDay() {
        return day;
    }

    public List<Units> getUnits() {
        List<Units> allUnits = new ArrayList<>();
        for (Building building : buildings) {
            allUnits.addAll(building.getUnits());
        }
        return allUnits;
    }

    public void unassignUnit(Units unit) {
        // getBuildings().stream()
        //     .filter(building -> building.getUnits().contains(unit))
        //     .findFirst().ifPresent(building -> {
        //     building.unassign(unit);

        //     getBuildings().stream()
        //     .filter(newHouse -> newHouse instanceof House)
        //     .filter(newHouse -> newHouse.getUnits().size() < newHouse.getLevel())
        //     .findFirst().ifPresent(newHouse -> newHouse.assign(unit));
        // });
        Building building = null;
        for (Building b : getBuildings()) {
            if (b.getUnits().contains(unit)) {
                building = b;
                break;
            }
        }
        if (building != null) {
            building.unassign(unit);

            boolean assigned = false;
            for (Building newHouse : getBuildings()) {
                if (newHouse instanceof House) {
                    if(newHouse.getUnits().size() < newHouse.getLevel()) {
                        assigned = true;
                        newHouse.assign(unit);
                        break;
                    }
                }
            }
            if (!assigned) {
                System.err.println("Aucun logement disponible pour réassigner l'unité");
            }
        } else {
            System.err.println("L'unité n'est assignée à aucun bâtiment");
        }
    }

    public Ressources getRessources() {
        return ressources;
    }

    public void FinishDay() {
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
        System.out.printf("Bois : %d | Pierre : %d | Fer : %d | Or : %d | Nourriture : %d%n%n", wood, stone, iron, gold,
                food);
    }

    public void displayVillagers() {
        System.out.println("Unités :");
        int i = 1;
        for (Units unit : getUnits()) {
            System.out.printf("%d - type : %s | pv : %d | dégâts : %d", i, unit.getClass().getSimpleName(),
                    unit.getHp(), unit.getDamage());
            i++;
        }
        System.out.println("\n");
    }

    public void displayBuildings() {
        System.out.println("Bâtiments :");
        int i = 1;
        for (Building building : buildings) {
            System.out.printf("%d - type : %s | niveau : %d", i, building.getClass().getSimpleName(),
                    building.getLevel());
            i++;
        }
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
        for (Units unit : getUnits()) {
            if (unit.getItem() != null) {
                System.out.println(
                        "- " + unit.getItem().getName() + " (Modificateur: " + unit.getItem().getModifier() + ")");
            }
        }
    }

    // public Weapon epee = createWeapon("Sword", 5, 1);
    // public Tools pioche = createTool("Pickaxe", 3, 1);

}
