package prj5;

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
 * implementation of Singly linked list class copied from lab 9
 * 
 * @author Grant Piersall , Rudolf Rissling , Brandon Baumgartner
 * @version Nov 16, 2023
 * @param <E>
 */
public class SinglyLinkedList<E>
{

    private Node<E> head;

    // the size of the linked list
    private int size;

    /**
     * Creates a new LinkedList object
     */
    public SinglyLinkedList()
    {
        setHead(null);
        size = 0;

    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size()
    {
        return size;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj)
    {
        // check if the object is null
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size()))
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        size++;

        if (getHead() == null)
        {

            setHead(new Node<E>(obj));

            return;
        }

        if (index == 0)
        {
            Node<E> nextNext = getHead();
            setHead(new Node<E>(obj));
            getHead().next = nextNext;
            return;
        }
        Node<E> current = getHead();

        for (int i = 0; i < index - 1; i++)
        {

            current = current.next;

        }

        Node<E> nextNext = current.next;

        current.next = new Node<E>(obj);
        current.next.next = nextNext;

    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(E obj)
    {
        // check if the object is null
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = getHead();

        // empty stack case
        if (isEmpty())
        {
            setHead(new Node<E>(obj));
        }

        // other cases
        else
        {
            while (current.next != null)
            {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean remove(E obj)
    {
        if (getHead() == null)
        {
            return false;
        }
        if (obj == null)
        {

            return false;
        }
        Node<E> current = getHead();

        // account for matching head
        if (obj.equals(getHead().data))
        {
            setHead(getHead().next);
            size--;
            return true;
        }

        while ((current.next != null))
        {
            if ((obj.equals(current.next.data)))
            {

                current.setNext(current.next.next);

                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public boolean remove(int index)
    {
        // if the index is invalid
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        size--;

        Node<E> current = getHead();
        if (index == 0)
        {

            setHead(getHead().next);
            return true;

        }

        for (int i = 0; i < index - 1; i++)
        {

            current = current.next;

        }

        current.next = current.next.next;

        return true;

    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public E get(int index)
    {
        Node<E> current = getHead();
        int currentIndex = 0;
        E data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null)
        {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj)
    {
        Node<E> current = getHead();
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear()
    {

        setHead(null);
        size = 0;

    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(E obj)
    {
        int lastIndex = -1;
        Node<E> current = getHead();
        int currentIndex = 0;
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString()
    {
        String result = "{";

        Node<E> current = getHead();
        while (current != null)
        {
            result += "" + current.data;
            current = current.next;
            if (current != null)
            {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list contains A, B,
     * C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray()
    {

        Object[] array = new Object[this.size()];

        Node<E> current = getHead();
        int count = 0;
        while (current != null)
        {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents in the exact same
     * order
     *
     * @return a boolean of whether two lists have the same contents, item per
     *             item and in the same order
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() == obj.getClass())
        {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<E> other = ((SinglyLinkedList<E>)obj);
            if (other.size() == this.size())
            {
                Node<E> current = getHead();
                Node<E> otherCurrent = other.getHead();
                while (current != null)
                {
                    if (!current.getData().equals(otherCurrent.getData()))
                    {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of head.
     * 
     * @return The value of head for this object.
     */
    public Node<E> getHead()
    {
        return head;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of head for this object.
     * 
     * @param head
     *            The new value for head.
     */
    public void setHead(Node<E> head)
    {
        this.head = head;
    }

    // -------------------------------------------------------------------------
    /**
     * node class
     * 
     * @param <T>
     * @author Grant Piersall
     * @version Nov 15, 2023
     */
    public static class Node<T>
    {

        private T data;

        private Node<T> next;

        // ----------------------------------------------------------
        /**
         * Create a new Node object.
         * 
         * @param data
         *            data to store
         */
        public Node(T data)
        {
            this.data = data;
        }


        /**
         * Sets next
         * 
         * @param node
         *            the next node
         */
        public void setNext(Node<T> node)
        {
            next = node;
        }


        /**
         * gets next
         *
         * @return next
         */
        public Node<T> next()
        {
            return next;
        }


        /**
         * gets data
         *
         * @return data
         */
        public T getData()
        {
            return data;
        }
    }

}
