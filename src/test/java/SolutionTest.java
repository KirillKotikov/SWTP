import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void getResultTestHuman() {
        Assert.assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "Human", "info.json"));
        Assert.assertEquals(10, Solution.getResult("SSPPPSSPSSSPSSSP", "Human", "info.json"));
        Assert.assertEquals(14, Solution.getResult("SSPPPSSPSSSSSSPP", "Human", "info.json"));
    }

    @Test
    public void getResultTestSwamper() {
        Assert.assertEquals(15, Solution.getResult("STWSWTPPTPTTPWPP", "Swamper", "info.json"));
        Assert.assertEquals(15, Solution.getResult("TTPPPTTPTTTPTTTP", "Swamper", "info.json"));
        Assert.assertEquals(18, Solution.getResult("TTPPPTTPTTTTTTPP", "Swamper", "info.json"));
    }

    @Test
    public void getResultTestWoodman() {
        Assert.assertEquals(12, Solution.getResult("STWSWTPPTPTTPWPP", "Woodman", "info.json"));
        Assert.assertEquals(13, Solution.getResult("SSPPPSSPSSSPSSSP", "Woodman", "info.json"));
        Assert.assertEquals(14, Solution.getResult("SSPPPSSPSSSSSSPP", "Woodman", "info.json"));

    }
}
