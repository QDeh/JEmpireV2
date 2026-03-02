package units;

import items.Tools;

public class Scout extends Soldier {

    public Scout() {
        super(15, 1, null);
    }
    // Fonction pour explorer hors du village et ramener des ressources

    public void equipTool(Tools tool) {
        if (tool != null) {
            this.item = tool;
        } else {
            System.out.println(
                    "Erreur : Impossible d'équiper un outil car il y en a déja un d'équipé ou il n'y en a pas de disponible .");
        }
    }
}
