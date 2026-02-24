package ressources;

public abstract class Ressources {
    private int quantity;

    public Ressources(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayRessources(Wood wood, Stone stone, Iron iron, Gold gold, Food food){
        System.out.printf("Bois : %d | Pierre : %d | Fer : %d | Or : %d | Nourriture : %d", wood, stone, iron, gold, food);
    }    
    
    // je ne suis pas sur de l'endroit ou mettre le displayRessources
}
