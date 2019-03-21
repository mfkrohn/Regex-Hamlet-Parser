import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String leonString = "Yo my name is Leon";
        String hamletString = "Yo my name is Hamlet";

        String actual = hamletParser.changeHamletToLeon(hamletString);

        Assert.assertEquals(leonString,actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String tariqString = "Yo my name is Tariq";
        String hamletString = "Yo my name is Hoartio";

        String actual = hamletParser.changeHoratioToTariq(tariqString);

        Assert.assertEquals(tariqString,actual);
    }

    @Test
    public void testFindHoratio() {
        String horatioString = "Yo my name is Horatio";
        String noHartioString = "BLah sjsiuhidnkj iauhsdid iuabisdu";
        Assert.assertTrue(hamletParser.findHoratio(horatioString));
        Assert.assertFalse(hamletParser.findHoratio(noHartioString));

    }

    @Test
    public void testFindHamlet() {
        String hamletString = "Yo my name is Hamlet";
        String noHamletString = "iuhid dibdij dibdibfiqwef udbisbsdiw edueydus isdusu hi";
        Assert.assertTrue(hamletParser.findHamlet(hamletString));
        Assert.assertFalse(hamletParser.findHamlet(noHamletString));
    }

    @Test
    public void doTheThingTest(){
        hamletParser.doTheThing();
    }

}