package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Grant Piersall (ghpiersall)
// -- Rudolf Rissling (rudolfr)
// -- Brandon Baumgartner (bbaum11)
// -------------------------------------------------------------------------
/**
 * test class
 * 
 * @author Grant Piersall , Rudolf Rissling , Brandon Baumgartner
 * @version Nov 16, 2023
 */
public class MonthDataTest
    extends TestCase
{

    private MonthData test;

    /**
     * sets up the fields
     */
    public void setUp()
    {
        test = new MonthData(
            1,
            "bob",
            "bob's burgers",
            "US",
            "food",
            10,
            20,
            30,
            40,
            50);

    }


    // ----------------------------------------------------------
    /**
     * Tests the getter methods of this class.
     */
    public void testGetters()
    {
        assertEquals((double)1000 / 6, test.getTrad(), 0.0001);
        assertEquals(100, test.getReach(), 0.0001);
        assertEquals(1, test.getMonth());
        assertEquals("bob", test.getUsername());
        assertEquals("bob's burgers", test.getChannelName());
        assertEquals("US", test.getCountry());
        assertEquals("food", test.getMainTopic());
        assertEquals(10, test.getLikes());
        assertEquals(20, test.getPosts());
        assertEquals(30, test.getFollowers());
        assertEquals(40, test.getComments());
        assertEquals(50, test.getViews());

        MonthData test2 = new MonthData(
            1,
            "bob",
            "bob's burgers",
            "US",
            "food",
            0,
            0,
            0,
            0,
            0);
        assertEquals(-1, test2.getTrad(), 0.0001);
        assertEquals(-1, test2.getReach(), 0.0001);

    }


    // ----------------------------------------------------------
    /**
     * Tests the compareTo() method
     */
    public void testCompareTo()
    {
        MonthData sameMonth = new MonthData(1, "", "", "", "", 0, 0, 0, 0, 0);
        assertEquals(test.compareTo(sameMonth), 0);

        MonthData differentMonth =
            new MonthData(2, "", "", "", "", 0, 0, 0, 0, 0);
        assertEquals(test.compareTo(differentMonth), -1);
    }
}
