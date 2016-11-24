import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class TowersTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingTowerWithNegativeHeight() {
        Towers.createTower(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingTowerWithoutDiscs() {
        Towers.createTower(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testCreatedTowerHeightIsNotBiggerThanNeed() {
        List<Peg> threePegs = Towers.createTower(3);
        int i = 1;
        while (i <= 4) {
            threePegs.get(0).takeDisc();
            i++;
        }
    }

    @Test
    public void testCreatedTowerHeightIsNotSmallerThanNeed() {
        List<Peg> threePegs = Towers.createTower(3);
        int i = 1;
        while (i <= 3) {
            Assert.assertEquals(i, threePegs.get(0).takeDisc().getDiscNumber());
            i++;
        }
    }

    @Test
    public void testTowerCreatedOnFirstPeg() {
        List<Peg> threePegs = Towers.createTower(3);
        Assert.assertEquals(1, threePegs.get(0).takeDisc().getDiscNumber());
    }

    @Test
    public void testNoTowerCreatedOnSecondPeg() {
        List<Peg> threePegs = Towers.createTower(3);
        threePegs.get(1).putDisc(new Disc(1));
    }

    @Test
    public void testNoTowerOnCreatedThirdPeg() {
        List<Peg> threePegs = Towers.createTower(3);
        threePegs.get(2).putDisc(new Disc(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMovingTowerToSamePlace() {
        List<Peg> threePegs = Towers.createTower(3);
        Towers.moveTower(threePegs, 3, threePegs.get(0), threePegs.get(0), threePegs.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMovingTowerWhenTmpPegEqualsFromPeg() {
        List<Peg> threePegs = Towers.createTower(3);
        Towers.moveTower(threePegs, 3, threePegs.get(0), threePegs.get(2), threePegs.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMovingTowerWhenTmpPegEqualsToPeg() {
        List<Peg> threePegs = Towers.createTower(3);
        Towers.moveTower(threePegs, 3, threePegs.get(0), threePegs.get(1), threePegs.get(1));
    }

    @Test
    public void testTowerIsMovedToAppropriatePeg() {
        List<Peg> threePegs = Towers.createTower(3);
        Towers.moveTower(threePegs, 3, threePegs.get(0), threePegs.get(2), threePegs.get(1));
        Assert.assertEquals(1, threePegs.get(2).takeDisc().getDiscNumber());
    }

    @Test
    public void testTowerIsMovedFromPreviousPeg() {
        List<Peg> threePegs = Towers.createTower(3);
        Towers.moveTower(threePegs, 3, threePegs.get(0), threePegs.get(2), threePegs.get(1));
        threePegs.get(0).putDisc(new Disc(1));
    }

    @Test
    public void testTowerIsNotOnTmpPeg() {
        List<Peg> threePegs = Towers.createTower(3);
        Towers.moveTower(threePegs, 3, threePegs.get(0), threePegs.get(2), threePegs.get(1));
        threePegs.get(1).putDisc(new Disc(1));
    }
}
