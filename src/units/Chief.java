package units;
import java.util.List;

public class Chief extends Soldier {
    
    public Chief(int hp, int damage) {
        super(30, 5,null);
       
    }
    public void isChief(List<Soldier> soldiers) {
        for (Soldier soldier : soldiers) {
                soldier.setHasChief(true);
        }
    }
}
