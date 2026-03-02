package ressources;

public class Ressources {
    private int wood;
    private int stone;
    private int iron;
    private int gold;
    private int food;

    public Ressources() {
        this(0, 0, 0, 0, 100);
    }

    public Ressources(int wood, int stone, int iron, int gold, int food) {
        this.wood = wood;
        this.stone = stone;
        this.iron = iron;
        this.gold = gold;
        this.food = food;
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getIron() {
        return iron;
    }

    public int getGold() {
        return gold;
    }

    public int getFood() {
        return food;
    }

    protected void setWood(int wood) {
        this.wood = wood;
    }

    protected void setStone(int stone) {
        this.stone = stone;
    }

    protected void setIron(int iron) {
        this.iron = iron;
    }

    protected void setGold(int gold) {
        this.gold = gold;
    }

    protected void setFood(int food) {
        this.food = food;
    }

    public void addFood(int amount) {
        this.food += amount;
    }

    public void addWood(int amount) {
        this.wood += amount;
    }

    public void addStone(int amount) {
        this.stone += amount;
    }

    public void addIron(int amount) {
        this.iron += amount;
    }

    public void addGold(int amount) {
        this.gold += amount;
    }
    
}
