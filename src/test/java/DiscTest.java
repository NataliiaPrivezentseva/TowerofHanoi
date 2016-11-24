import org.junit.Assert;
import org.junit.Test;

public class DiscTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingDiscWithNumberZero(){
        new Disc(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingDiscWithNegativeNumber(){
        new Disc(-2);
    }

    @Test
    public void testCreatingDiscWithAppropriateNumber(){
        Disc disc = new Disc(5);
        Assert.assertEquals(5, disc.getDiscNumber());
    }
}
