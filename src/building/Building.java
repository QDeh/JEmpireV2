package building;

public abstract class Building {
    int level = 1;

    public Building(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public int checkLevel(){
        if (level >= 10){
            System.out.println("Niveau maximum atteint !");
            level = 10;
        }
        return level;
    }
}
