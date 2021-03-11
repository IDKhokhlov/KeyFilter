import org.junit.Before;
import org.junit.Test;
import strategy.RegexSplit;
import implemetations.IdsWithoutSpaces;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class KeyWithoutSpacesFilterTest {

    RegexSplit strategy;

    @Before
    public void setUp() {
        strategy = new IdsWithoutSpaces();
    }

    @Test
    public void oneArgumentTest() {
        String string = " ,T1001,, ,";
        String[] array = {
            "  T1002,,,,, , ,, T1001,",
            "  T100,12,,, , ,, T1003,",
            "HELLO WORLD T1001,, ,",
            "T1001",
            ""
        };

        List<String> expected = new ArrayList<>();
        expected.add("  T1002,,,,, , ,, T1001,");
        expected.add("T1001");

        assertEquals(expected, KeyFilter.filterTasks(string, array, strategy));
    }

    @Test
    public void threeArgumentTest() {
        String string = " ,T1001,, ,T1002  ,,,, T1003";
        String[] array = {
            "T1001, T1002,  T1002,,T1003,,, , ,, T1001,",
            "T1000, T1002  T1002,,T1003,,, T1111, ,, T1000,,",
            ""
        };

        List<String> expected = new ArrayList<>();
        expected.add("T1001, T1002,  T1002,,T1003,,, , ,, T1001,");

        assertEquals(expected, KeyFilter.filterTasks(string, array, strategy));
    }

    @Test
    public void noArgumentTest() {
        String string = " ,,, ,, ,";
        String[] array = {
            "  T1002,,,,, , ,, T1001,",
            ""
        };

        List<String> expected = new ArrayList<>();

        assertEquals(expected, KeyFilter.filterTasks(string, array, strategy));
    }

    @Test
    public void nullStringArgumentTest() {
        String string = null;
        String[] array = { "  T1002, T1001," };

        List<String> expected = new ArrayList<>();

        assertEquals(expected, KeyFilter.filterTasks(string, array, strategy));
    }

    @Test
    public void nullArrayArgumentTest() {
        String string = " ,,, ,, ,";
        String[] array = null;

        List<String> expected = new ArrayList<>();

        assertEquals(expected, KeyFilter.filterTasks(string, array, strategy));
    }
}