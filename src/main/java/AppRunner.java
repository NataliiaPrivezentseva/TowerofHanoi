import java.util.List;

public class AppRunner {

    public static void main(String[] args) {
        Input usersInput = new Input();
        int towerHeight = usersInput.getTowerHeightFromUser();

        List<Peg> threePegs = Towers.createTower(towerHeight);
        Towers.printTowerState(threePegs);
        Towers.moveTower(threePegs, towerHeight, threePegs.get(0), threePegs.get(2), threePegs.get(1));
    }
}
