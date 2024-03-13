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
 * @author Grant Piersall , Rudolf Rissling , Brandon Baumgartner
 * @version Nov 16, 2023
 */
public class MonthDataListTest
    extends TestCase
{

    private MonthDataList test;

    /**
     * sets up the fields
     */
    public void setUp()

    {
        test = new MonthDataList();
        test.add(
            new MonthData(
                8,
                "jim",
                "jimyyyyyy2",
                "US",
                "action",
                9,
                9,
                9,
                9,
                9));
        test.add(
            new MonthData(1, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(2, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(3, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(4, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(5, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(6, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(
                10,
                "jim",
                "jimyyyyyy2",
                "US",
                "action",
                9,
                9,
                9,
                9,
                9));
        test.add(
            new MonthData(7, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(
                1,
                "jim",
                "jimyyyyyy2",
                "US",
                "action",
                9,
                9,
                9,
                9,
                9));
        test.add(
            new MonthData(8, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(9, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(10, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(
                1,
                "jim",
                "jimyyyyyy2",
                "US",
                "action",
                9,
                9,
                9,
                9,
                9));
        test.add(
            new MonthData(11, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(12, "dan", "dan2", "US", "action", 1, 2, 3, 4, 5));
        test.add(
            new MonthData(
                1,
                "jim",
                "jimyyyyyy2",
                "US",
                "action",
                9,
                9,
                9,
                9,
                9));

    }


    // ----------------------------------------------------------
    /**
     * tests if the merge method properly merges monthdata into 4 quarters
     */
    public void testMerge()
    {
        MonthDataList b = new MonthDataList();
        b = test.merge(-1);
        assertEquals(
            "{-1,jim,jimyyyyyy2,US,action,27,27,9,27,27, "
                + "-1,dan,dan2,US,action,3,6,3,12,15}",
            b.toString());

        b = test.merge(-2);
        assertEquals("{-2,dan,dan2,US,action,3,6,3,12,15}", b.toString());

        b = test.merge(-3);
        assertEquals(
            "{-3,jim,jimyyyyyy2,US,action,9,9,9,9,9, "
                + "-3,dan,dan2,US,action,3,6,3,12,15}",
            b.toString());

        b = test.merge(-4);
        assertEquals(
            "{-4,jim,jimyyyyyy2,US,action,9,9,9,9,9, "
                + "-4,dan,dan2,US,action,3,6,3,12,15}",
            b.toString());

    }


    // ----------------------------------------------------------
    /**
     * Test method that thoroughly tests the sorting algorithm by creating new
     * instances of monthData, compiling them into a list and then running the
     * list through various comparartors.
     */
    public void testSort()
    {
        MonthData highTradMedReach = new MonthData(
            1,
            "user1",
            "ArtAllDay",
            "Country1",
            "Topic1",
            500,
            10,
            100,
            50,
            1000);
        // Traditional: 550%, Reach: 50%
        MonthData medTradHighReach = new MonthData(
            2,
            "user2",
            "australian_wildlife",
            "Country2",
            "Topic2",
            300,
            10,
            270,
            30,
            300);
        // Traditional: 120%, Reach: 110%
        MonthData lowTradLowReach = new MonthData(
            3,
            "user3",
            "JustBeatz",
            "Country3",
            "Topic3",
            100,
            10,
            500,
            20,
            2000);
        // Traditional: 25%, Reach: 5%
        MonthData medTradMedReach = new MonthData(
            4,
            "user4",
            "wizardHighSchool",
            "Country4",
            "Topic4",
            200,
            10,
            200,
            20,
            300);
        // Traditional: 110%, Reach: 75%

        MonthDataList dataList = new MonthDataList();
        // test empty
        dataList.insertionSort(new TradComparator());
        assertTrue(dataList.isEmpty());

        dataList.add(highTradMedReach);
        // test with one value
        dataList.insertionSort(new TradComparator());
        assertEquals(dataList.size(), 1);
        assertEquals(highTradMedReach, dataList.get(0));

        // populate the list
        dataList.add(medTradMedReach);
        dataList.add(lowTradLowReach);
        dataList.add(medTradHighReach);

        // test tradComparator
        dataList.insertionSort(new TradComparator());
        assertEquals(dataList.size(), 4);

        assertEquals(highTradMedReach, dataList.get(0));
        assertEquals(medTradHighReach, dataList.get(1));
        assertEquals(medTradMedReach, dataList.get(2));
        assertEquals(lowTradLowReach, dataList.get(3));

        // test reachComparator
        dataList.insertionSort(new ReachComparator());
        assertEquals(dataList.size(), 4);

        assertEquals(medTradHighReach, dataList.get(0));
        assertEquals(medTradMedReach, dataList.get(1));
        assertEquals(highTradMedReach, dataList.get(2));
        assertEquals(lowTradLowReach, dataList.get(3));

        // test nameComparator
        dataList.insertionSort(new NameComparator());
        assertEquals(dataList.size(), 4);

        assertEquals(highTradMedReach, dataList.get(0));
        assertEquals(medTradHighReach, dataList.get(1));
        assertEquals(lowTradLowReach, dataList.get(2));
        assertEquals(medTradMedReach, dataList.get(3));

        // test the helper methods

        highTradMedReach = new MonthData(
            1,
            "user1",
            "ArtAllDay",
            "Country1",
            "Topic1",
            500,
            10,
            100,
            50,
            1000);
        // Traditional: 550%, Reach: 50%
        medTradHighReach = new MonthData(
            2,
            "user2",
            "australian_wildlife",
            "Country2",
            "Topic2",
            300,
            10,
            270,
            30,
            300);
        // Traditional: 120%, Reach: 110%
        lowTradLowReach = new MonthData(
            3,
            "user3",
            "JustBeatz",
            "Country3",
            "Topic3",
            100,
            10,
            500,
            20,
            2000);
        // Traditional: 25%, Reach: 5%
        medTradMedReach = new MonthData(
            4,
            "user4",
            "wizardHighSchool",
            "Country4",
            "Topic4",
            200,
            10,
            200,
            20,
            300);
        // Traditional: 110%, Reach: 75%

        dataList = new MonthDataList();
        // test empty
        dataList.sortByTraditional();
        assertTrue(dataList.isEmpty());

        dataList.add(highTradMedReach);
        // test with one value
        dataList.sortByTraditional();
        assertEquals(dataList.size(), 1);
        assertEquals(highTradMedReach, dataList.get(0));

        // populate the list
        dataList.add(medTradMedReach);
        dataList.add(lowTradLowReach);
        dataList.add(medTradHighReach);

        // test tradComparator
        dataList.sortByTraditional();
        assertEquals(dataList.size(), 4);

        assertEquals(highTradMedReach, dataList.get(0));
        assertEquals(medTradHighReach, dataList.get(1));
        assertEquals(medTradMedReach, dataList.get(2));
        assertEquals(lowTradLowReach, dataList.get(3));

        // test reachComparator
        dataList.sortByReach();
        assertEquals(dataList.size(), 4);

        assertEquals(medTradHighReach, dataList.get(0));
        assertEquals(medTradMedReach, dataList.get(1));
        assertEquals(highTradMedReach, dataList.get(2));
        assertEquals(lowTradLowReach, dataList.get(3));

        // test nameComparator
        dataList.sortByName();
        assertEquals(dataList.size(), 4);

        assertEquals(highTradMedReach, dataList.get(0));
        assertEquals(medTradHighReach, dataList.get(1));
        assertEquals(lowTradLowReach, dataList.get(2));
        assertEquals(medTradMedReach, dataList.get(3));

    }

}
