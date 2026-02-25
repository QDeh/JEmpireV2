package ressources;

public abstract class Ressources {
    private int wood = 0;
    private int stone = 0;
    private int iron = 0;
    private int gold = 0;
    private int food = 100;
    

    public Ressources(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
