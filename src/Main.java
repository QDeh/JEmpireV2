import java.util.*;

import units.Units;
import village.*;


public class Main {
    private static Village village = new Village("Niort");
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static boolean again = true;

    public static int readInt() {
        return readInt("Entrez un nombre");
    }

    public static int readInt(String prompt) throws NumberFormatException {
        System.out.print(prompt);
        String input = scanner.nextLine();
        int result = Integer.parseInt(input);
        return result;
    }
    public static void main(String[] args) {
        while (village.getUnits().size() > 0 && again) {
            Main game = new Main();
            game.displayMainMenu();
            choice = readInt("Votre choix : ");
            game.selectMainMenu();
        }
        scanner.close();
        System.out.printf("Vous avez perdu, %s à subsisté %d jours",village.getName(), village.getDay());
    }



    public void displayMainMenu() {
        System.out.println("============================================================================");
        System.out.printf("                  JEmpire | Village : %s | Jour : %d                %n",village.getName(), village.getDay());
        System.out.println("============================================================================");
        System.out.println("================================== DÉTAILS =================================");
        village.displayRessources();
        village.displayUnits();
        village.displayBuildings();
        village.displayItems();
        System.out.println("\n");
        System.out.println("=================================== MENU ===================================\n");
        System.out.println("1 - Construire un bâtiment");
        System.out.println("2 - Améliorer un bâtiment");
        System.out.println("3 - Asssigner une unité");
        System.out.println("4 - Libérer une unité");
        System.out.println("5 - Former une unité");
        System.out.println("6 - Recruter une unité");
        System.out.println("7 - Équiper un item");
        System.out.println("8 - Passer au jour suivant");
        System.out.println("0 - Quitter\n");
    }

    public void selectMainMenu(){
        switch (choice) {
            case 1:
                displayBuildMenu();
                choice = readInt("Votre choix : ");
                selectBuildMenu();
                break;
            case 2:
                displayUpgradeMenu();
                choice = readInt("Votre choix : ");
                selectUpgradeMenu();
                break;
            case 3:
                displayAssignMenu();
                choice = readInt("Votre choix : ");
                break;
            case 4:
                displayUnassignMenu();
                choice = readInt("Votre choix : ");
                
                if (choice == 0) {
                    return;
                }
                Units unit = village.getUnits().get(choice-1);
                System.out.println("Unité désassignée : " + unit);


                break;
            case 5:
                displayTrainMenu();
                choice = readInt("Votre choix : ");
                selectTrainMenu();
                break;
            case 6:
                displayRecruitMenu();
                choice = readInt("Votre choix : ");
                selectRecruitMenu();
                break;
            case 7:
                displayEquipMenu();
                choice = readInt("Votre choix : ");
                break;
            case 8:
                village.FinishDay();
                break;
            case 0:
                again = false;
                System.out.println("Au revoir !");
                break;
        }
    }

    public void displayBuildMenu() {
        System.out.println("=========================== Construire un bâtiment ==========================");
        village.displayRessources();
        System.out.println("1 - Construire une Maison");
        System.out.println("2 - Construire une Ferme");
        System.out.println("3 - Construire une Mine");
        System.out.println("4 - Construire un Atelier");
        System.out.println("5 - Construire une Caserne");
        System.out.println("6 - Construire un Mur de défense");
        System.out.println("0 - Quitter\n");
    }

    public void selectBuildMenu(){
        switch (choice) {
            case 1:
                village.createBuilding("house");
                break;
            case 2:
                village.createBuilding("farm");
                break;
            case 3:
                village.createBuilding("mine");
                break;
            case 4:
                village.createBuilding("workshop");
                break;
            case 5:
                village.createBuilding("barraks");
                break;
            case 6:
                village.createBuilding("wall");
                break;
            case 0:
                break;
        }
    }

    public void displayUpgradeMenu() {
        System.out.println("=========================== Améliorer un bâtiment ==========================");
        village.displayRessources();
        village.displayBuildings();
        System.out.println("0 - Quitter\n");
    }

    public void selectUpgradeMenu(){
            village.getBuildings().get(choice-1).upgradeBuilding();
        }

    public void displayAssignMenu() {
        System.out.println("=========================== Asssigner une unité ==========================");
        village.displayUnits();
        System.out.println("0 - Quitter\n");
    }

    public void selectAssignMenu(){
        village.getUnits().get(choice-1);
    }

    public void displayUnassignMenu() {
        System.out.println("=========================== Libérer une unité ==========================");
        village.displayUnits();
        System.out.println("0 - Quitter\n");
    }

    public void selectUnassignMenu(){
        village.unassignUnit(village.getUnits().get(choice-1));
    }

    public void displayTrainMenu() {
        System.out.println("=========================== Former une unité ==========================");
        System.out.println("1 - Former un Soldat");
        System.out.println("2 - Former un Éclaireur");
        System.out.println("3 - Former un Chef");
        System.out.println("0 - Quitter\n");
    }

   public void selectTrainMenu(){
        switch (choice) {
            case 1:
                village.createUnit("soldier");
                break;
            case 2:
                village.createUnit("scout");
                break;
            case 3:
                village.createUnit("chief");
                break;
            case 0:
                break;
        }
    }

    public void displayRecruitMenu() {
        System.out.println("=========================== Recruter une unité ==========================");
        System.out.println("1 - Recruter un Villageois");
        System.out.println("2 - Recruter un Artisan");
        System.out.println("0 - Quitter\n");
    }

    public void selectRecruitMenu(){
        switch (choice) {
            case 1:
                village.createUnit("villager");
                break;
            case 2:
                village.createUnit("craftsman");
                break;
            case 0:
                break;
        }
    }

    public void displayEquipMenu() {
        System.out.println("=========================== Équiper un item ==========================");
        village.displayItems();
        System.out.println("0 - Quitter\n");
    }

    public void selectItem() {
        //village.unassignUnit(village.getUnits().get(choice - 1));
    }
}
