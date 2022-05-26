import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void getResultTestHuman() {
        Assert.assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "Human"));
        Assert.assertEquals(10, Solution.getResult("SSPPPSSPSSSPSSSP", "Human"));
        Assert.assertEquals(14, Solution.getResult("SSPPPSSPSSSSSSPP", "Human"));
    }

    @Test
    public void getResultTestSwamper() {
        Assert.assertEquals(15, Solution.getResult("STWSWTPPTPTTPWPP", "Swamper"));
        Assert.assertEquals(15, Solution.getResult("TTPPPTTPTTTPTTTP", "Swamper"));
        Assert.assertEquals(18, Solution.getResult("TTPPPTTPTTTTTTPP", "Swamper"));
    }

    @Test
    public void getResultTestWoodman() {
        Assert.assertEquals(12, Solution.getResult("STWSWTPPTPTTPWPP", "Woodman"));
        Assert.assertEquals(13, Solution.getResult("SSPPPSSPSSSPSSSP", "Woodman"));
        Assert.assertEquals(14, Solution.getResult("SSPPPSSPSSSSSSPP", "Woodman"));

    }
}
