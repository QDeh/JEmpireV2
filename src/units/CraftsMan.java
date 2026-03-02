package units;

import items.Tools;
public class CraftsMan extends Units {

    public CraftsMan() {
        super();
    }

    
     public void equipTool(Tools tool) {
        if (tool != null) {
            this.item = tool;
        } else {
            System.out.println( "Erreur : Impossible d'équiper un outil car il y en a déja un d'équipé ou il n'y en a pas de disponible .");
        }
    }
}