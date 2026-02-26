package units;

import items.Tools;

public class Villager extends Units {

    public Villager(int hp, int damage, Tools tool) {
        super(hp, damage, tool);
    }

    public void equipTool(Tools tool) {
        if (tool != null) {
            this.item = tool;
        } else {
            System.out.println( "Erreur : Impossible d'équiper un outil car il y en a déja un d'équipé ou il n'y en a pas de disponible .");
        }
    }
    public Villager(){
        super();
    }
    // Fonction pour construire des bâtiments et récolter des ressources
    
}
