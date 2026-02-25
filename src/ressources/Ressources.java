package ressources;

public abstract class Ressources {
    private int wood = 0;
    private int stone = 0;
    private int iron = 0;
    private int gold = 0;
    private int food = 100;
    

    public Ressources(int wood, int stone, int iron, int gold, int food) {
        this.wood = wood;
        this.stone = stone;
        this.iron = iron;
        this.gold = gold;
        this.food = food;
    }

}
