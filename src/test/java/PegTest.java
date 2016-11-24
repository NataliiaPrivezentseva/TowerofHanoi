import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class PegTest {

    private Peg peg = new Peg();

    @Test
    public void testReturningValueFromTakeDisc() {
        Disc discOne = new Disc(1);
        peg.putDisc(discOne);
        Assert.assertEquals(discOne, peg.takeDisc());
    }

    @Test(expected = NoSuchElementException.class)
    public void testThrowingNoSuchElementExceptionIfNoDiscsForTaking() {
        peg.takeDisc();
    }

    @Test(expected = NoSuchElementException.class)
    public void testPegStateAfterTakingDisc() {
        Disc discOne = new Disc(1);
        peg.putDisc(discOne);
        peg.takeDisc();
        peg.takeDisc();
    }

    @Test
    public void testPegStateAfterPuttingDisc() {
        Disc discOne = new Disc(1);
        peg.putDisc(discOne);
        Assert.assertEquals(discOne, peg.takeDisc());
    }

    @Test(expected = NullPointerException.class)
    public void testThrowingNullPointerExceptionIfNoDiscsForPutting() {
        peg.putDisc(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testThrowingIllegalStateExceptionIfPuttingWrongDiscNumber() {
        Disc discOne = new Disc(1);
        Disc discTwo = new Disc(2);
        peg.putDisc(discOne);
        peg.putDisc(discTwo);
    }

}
