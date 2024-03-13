package prj5;

import java.util.Arrays;
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
 * implementation of Singly linked list test class with tests taken from lab 9
 * 
 * @author Grant Piersall , Rudolf Rissling , Brandon Baumgartner
 * @version Sep 29, 2023
 */
public class SinglyLinkedListTest
    extends TestCase
{
    private SinglyLinkedList<String> list1;
    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    private String nullObject;

    /**
     * sets up the fields
     */
    public void setUp()
    {
        list1 = new SinglyLinkedList<String>();
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new SinglyLinkedList<String>();

        for (int i = 0; i < 100; i++)
        {
            bigListA.add("sport" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++)
        {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;
    }


    /**
     * Gets the object at the given position param index where the object is
     * located The object at the given position throws IndexOutOfBoundsException
     * if there is not a node at the given index
     */
    public void testget()
    {
        list1.add("apple");
        assertEquals("apple", list1.get(0));
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");
        assertEquals("kiwi", list1.get(3));
        assertEquals("mango", list1.get(2));

        assertEquals("banana", list1.getHead().next().getData());

        list1.remove("banana");
        list1.remove("mango");
        list1.remove("kiwi");
        assertEquals("apple", list1.get(0));

        list1.remove("banana");
        list1.remove("mango");
        list1.remove("kiwi");
        Exception thrown = null;
        try
        {
            list1.get(330);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try
        {
            list1.get(4);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

    }


    /**
     * Gets the number of elements in the list return the number of elements
     */
    public void testsize()
    {
        assertEquals(0, list1.size());
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");

        assertEquals(4, list1.size());
        list1.remove("apple");
        list1.remove("banana");
        list1.remove("mango");
        list1.remove("kiwi");
        assertEquals(0, list1.size());
    }


    /**
     * Adds the object to the position in the list param index where to add the
     * object param obj the object to add throws IndexOutOfBoundsException if
     * index is less than zero or greater than size throws
     * IllegalArgumentException if obj is null
     */
    public void testadd()
    {

        list1.add(0, "apple");
        list1.add(1, "banana");
        list1.add(2, "mango");
        list1.add(1, "kiwi");
        list1.add(0, "bot");

        /*
         * bot apple kiwi bana mago
         */
        assertEquals(5, list1.size());
        assertEquals("bot", list1.get(0));
        assertEquals("apple", list1.get(1));
        assertEquals("kiwi", list1.get(2));
        assertEquals("banana", list1.get(3));
        assertEquals("mango", list1.get(4));

        // list1.add(2, null);

        Exception thrown = null;
        try
        {
            list1.add(330, "lol");
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try
        {
            list1.add(-330, "lol");
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try
        {
            list1.add(0, null);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Adds the object to the end of the list. param obj the object to add
     * throws IllegalArgumentException if obj is null
     */
    public void testadd2()
    {
        list1.add("apple");
        assertEquals("apple", list1.get(0));
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");
        assertEquals("kiwi", list1.get(3));
        assertEquals("mango", list1.get(2));

        Exception thrown = null;
        try
        {
            list1.add(null);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Checks if the array is empty return if the array is empty
     */
    public void testisEmpty()
    {
        assertTrue(list1.isEmpty());
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");
        assertFalse(list1.isEmpty());
        list1.remove("apple");
        list1.remove("banana");
        list1.remove("mango");
        list1.remove("kiwi");
        assertTrue(list1.isEmpty());
    }


    /**
     * Removes the first instance of the given object from the list param obj
     * the object to remove return true if successful
     */
    public void testremove()
    {
        list1.add("t");
        assertFalse(list1.remove("g"));
        assertTrue(list1.remove("t"));

        assertFalse(list1.remove("kiwi"));
        list1.add("kiwi");
        assertTrue(list1.remove("kiwi"));
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        assertTrue(list1.remove("apple"));
        list1.add("kiwi");
        assertFalse(list1.remove("apple"));
        list1.add("mango");
        list1.remove("mango");
        assertEquals("kiwi", list1.get(1));
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");
        assertTrue(list1.remove("kiwi"));
        assertTrue(list1.remove("kiwi"));
        assertFalse(list1.remove("kiwi"));
        assertFalse(list1.remove(null));

    }


    /**
     * Removes the object at the given position param index the position of the
     * object return true if the removal was successful throws
     * IndexOutOfBoundsException if there is not an element at the index
     */
    public void testremove2()
    {

        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");
        list1.add("a");
        list1.add("b");
        list1.add("c");

        assertEquals(7, list1.size());

        Exception thrown = null;
        try
        {
            list1.remove(7);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        assertFalse(list1.remove(null));
        assertTrue(list1.remove(0));
        assertEquals("banana", list1.get(0));

        assertTrue(list1.remove(1));
        assertEquals("kiwi", list1.get(1));

        assertTrue(list1.remove(4));
        assertEquals("banana", list1.get(0));
        assertEquals("kiwi", list1.get(1));

        assertTrue(list1.remove(3));
        assertTrue(list1.remove(2));
        assertTrue(list1.remove(1));
        assertTrue(list1.remove(0));

        assertTrue(list1.isEmpty());

        thrown = null;
        try
        {
            list1.remove(-1);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");
        list1.add("a");
        list1.add("b");
        list1.add("c");

        thrown = null;
        try
        {
            list1.remove(88888);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }


    /**
     * Checks if the list contains the given object obj the object to check for
     * true if it contains the object
     */
    public void testcontains()
    {
        list1.add("apple");

        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");
        assertTrue(list1.contains("kiwi"));
        assertTrue(list1.contains("banana"));
        assertTrue(list1.contains("apple"));
        assertFalse(list1.contains("god"));
    }


    /**
     * Removes all of the elements from the list
     *
     * @postcondition size = 0 and all of the nodes are removed
     */
    public void testclear()
    {
        list1.add("apple");

        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");
        assertFalse(list1.isEmpty());
        list1.clear();
        assertTrue(list1.isEmpty());
        list1.clear();
        assertTrue(list1.isEmpty());

    }


    /**
     * Gets the last time the given object is in the list obj the object to look
     * for the last position of it. -1 If it is not in the list
     */
    public void testlastIndexOf()
    {
        list1.add("ggggg");
        list1.add("apple");

        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");
        list1.add("apple");
        assertEquals(0, list1.lastIndexOf("ggggg"));
        assertEquals(2, list1.lastIndexOf("banana"));
        assertEquals(5, list1.lastIndexOf("apple"));
        assertEquals(-1, list1.lastIndexOf("god"));

    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     * a string representing the list
     */
    public void testtoString()
    {
        assertEquals("{}", list1.toString());
        list1.add("a");
        list1.add("b");
        list1.add("c");
        assertEquals("{a, b, c}", list1.toString());

    }


    /**
     * Tests the equals method on an empty list
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEqualsEmptyList()
    {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEqualsSmallList()
    {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEqualsBigList()
    {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--)
        {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++)
        {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++)
        {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++)
        {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty()
    {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents()
    {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }

}
