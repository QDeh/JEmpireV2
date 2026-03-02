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
            assignHouse(unit);
        } else {
            System.err.println("L'unité n'est assignée à aucun bâtiment");
        }
    }

    public void assignHouse(Units unit){
        boolean assigned = false;
        for (Building newHouse : getBuildings()) {
            if (newHouse instanceof House) {
                if (newHouse.getUnits().size() < newHouse.getLevel()) {
                    assigned = true;
                    newHouse.assign(unit);
                    break;
                }
            }
        }
        if (!assigned) {
            System.err.println("Aucun logement disponible");
        }
    }

    public Ressources getRessources() {
        return ressources;
    }

    public void FinishDay() {
        day++;
        for (Building building : buildings){
            switch (building.getClass().getSimpleName()) {
                case "Farm":
                    //ressources.setFood(ressources.getFood()+3*building.getLevel());
                    //ressources.setWood(ressources.getWood()+5*building.getLevel());
                    break;
                case "Mine":
                    //ressources.setStone(ressources.getStone() + 5 * building.getLevel());
                    //ressources.setGold(ressources.getGold() + 2 * building.getLevel());
                    break;
                case "Workshop":
                    items.add(new Tools());
                    break;
                default:
                    break;
            }
        }
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

    public void displayUnits() {
        System.out.println("Unités :");
        int i = 1;
        for (Units unit : getUnits()) {
            System.out.printf("%d - type : %s \t| pv : %d \t| dégâts : %d%n", i, unit.getClass().getSimpleName(),
                    unit.getHp(), unit.getDamage());
            i++;
        }
        System.out.println("\n");
    }

    public void displayBuildings() {
        System.out.println("Bâtiments :");
        int i = 1;
        for (Building building : buildings) {
            System.out.printf("%d - type : %s \t| niveau : %d%n", i, building.getClass().getSimpleName(),
                    building.getLevel());
            i++;
        }
        System.out.println("\n");
    }

    public void displayItems(){
        System.out.println("Items :");
        int i = 1;
        for (Items item : items) {
            System.out.printf("%d - name : %s \t| modifier : %d \t| niveau : %d%n", i, item.getName(), item.getModifier(), item.getLevel());
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
        Tools newTool = new Tools();
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

    public void createBuilding(String type){
        switch (type.toLowerCase()) {
            case "house":
                buildings.add(new House(1,new ArrayList<Units>()));
                break;
            case "farm":
                buildings.add(new Farm(1, new ArrayList<Units>()));
                break;
            case "mine":
                buildings.add(new Mine(1, new ArrayList<Units>()));
                break;
            case "workshop":
                buildings.add(new Workshop(1, new ArrayList<Units>()));
                break;
            case "barraks":
                buildings.add(new Barraks(1, new ArrayList<Units>()));
                break;
            case "wall":
                if (getBuildings().stream().anyMatch(b -> b instanceof Wall)) {
                    System.err.println("Il y a déjà un mur");
                    return;
                }
                buildings.add(new Wall(1, new ArrayList<Units>()));
                break;
            default:
                System.err.println("Type inconnu");
                return;
        }
    }

    public void createUnit(String type){
        switch (type.toLowerCase()) {
            case "soldier":
                assignHouse(new Soldier());
                break;
            case "scout":
                assignHouse(new Scout());
                break;
            case "chief":
                if (getUnits().stream().anyMatch(c -> c instanceof Chief)) {
                    System.err.println("Il y a déjà un chef");
                    return;
                }
                assignHouse(new Chief());
                break;
            case "villager":
                assignHouse(new Villager());
                break;
            case "craftsman":
                assignHouse(new CraftsMan());
                break;
            default:
                System.err.println("Type inconnu");
                return;
        }
    }

    // public Weapon epee = createWeapon("Sword", 5, 1);
    // public Tools pioche = createTool("Pickaxe", 3, 1);

}
