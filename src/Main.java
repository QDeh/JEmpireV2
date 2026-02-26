import java.util.*;

import building.House;
import units.Units;
import village.*;


public class Main {
    static Village village = new Village("Niort");
    static Scanner scanner = new Scanner(System.in);
    static int choice;
    static boolean quit = false;

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
        while (village.getUnits().size() > 0 && !quit) {
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
        village.displayVillagers();
        village.displayBuildings();
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
                break;
            case 6:
                displayRecruitMenu();
                choice = readInt("Votre choix : ");
                break;
            case 7:
                displayEquipMenu();
                choice = readInt("Votre choix : ");
                break;
            case 8:
                village.FinishDay();
                break;
            case 0:
                quit = true;
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
                //village.buildHouse();
                break;
            case 2:
                //village.buildFarm();
                break;
            case 3:
                //village.buildMine();
                break;
            case 4:
                //village.buildWorkshop();
                break;
            case 5:
                //village.buildBarraks();
                break;
            case 6:
                //village.buildWall();
                break;
            case 0:
                break;
        }
    }

    public void displayUpgradeMenu() {
        System.out.println("=========================== Améliorer un bâtiment ==========================");
        village.displayRessources();
        System.out.println("1 - Améliorer un Atelier");
        System.out.println("2 - Améliorer une Caserne");
        System.out.println("3 - Améliorer une Ferme");
        System.out.println("4 - Améliorer une Maison");
        System.out.println("5 - Améliorer une Mine");
        System.out.println("6 - Améliorer un Mur de défense");
        System.out.println("0 - Quitter\n");
    }

    public void selectUpgradeMenu(){
        switch (choice) {
            case 1:
                //village.upgradeHouse();
                break;
            case 2:
                //village.upgradeFarm();
                break;
            case 3:
                //village.upgradeMine();
                break;
            case 4:
                //village.upgradeWorkshop();
                break;
            case 5:
                //village.upgradeBarraks();
                break;
            case 6:
                //village.upgradeWall();
                break;
            case 0:
                break;
        }
    }

    public void displayAssignMenu() {
        System.out.println("=========================== Asssigner une unité ==========================");
        village.displayVillagers();
        System.out.println("0 - Quitter\n");
    }

    public void selectAssignMenu(){
        village.getUnits().get(choice-1);
    }

    public void displayUnassignMenu() {
        System.out.println("=========================== Libérer une unité ==========================");
        village.displayVillagers();
        System.out.println("0 - Quitter\n");
    }

    public void selectUnassignMenu(){
        village.unassignUnit(village.getUnits().get(choice-1));
    }

    public void displayTrainMenu() {
        System.out.println("=========================== Former une unité ==========================");
        System.out.println("1 - Former un Soldat");
        System.out.println("2 - Former un Chef");
        System.out.println("0 - Quitter\n");
    }

   public void selectTrainMenu(){
        switch (choice) {
            case 1:
                //village.trainSoldier();
                break;
            case 2:
                //village.trainChief();
                break;
            case 0:
                break;
        }
    }

    public void displayRecruitMenu() {
        System.out.println("=========================== Recruter une unité ==========================");
        System.out.println("1 - Recruter un Villageois");
        System.out.println("2 - Recruter un Éclaireur");
        System.out.println("3 - Recruter un Artisan");
        System.out.println("0 - Quitter\n");
    }

    public void selectRecruitMenu(){
        switch (choice) {
            case 1:
                //Village.recruitVillager();
                break;
            case 2:
                //village.recruitScout();
                break;
            case 3:
                //village.recruitCraftsMan();
                break;
            case 0:
                break;
        }
    }

    public void displayEquipMenu() {
        System.out.println("=========================== Équiper un item ==========================");
        // ma version de la classe village n'a pas la liste des items, à faire plus tard
        System.out.println("0 - Quitter\n");
    }
}
