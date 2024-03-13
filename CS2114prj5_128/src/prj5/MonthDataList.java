package prj5;

import java.util.Comparator;

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
public class MonthDataList
    extends SinglyLinkedList<MonthData>
{
    // ----------------------------------------------------------
    /**
     * Create a new MonthDataList object.
     */
    public MonthDataList()
    {
        super();
    }


    // ----------------------------------------------------------
    /**
     * merges the months into a single quarter for each channel quarters range
     * from -1 to -4
     * 
     * @param quarter
     *            which of the 4 quarters you are looking for
     * @return a MonthDataList of the quarter data for each channel
     */
    public MonthDataList merge(int quarter)
    {
        SinglyLinkedList<String> names = new SinglyLinkedList<String>();
        MonthDataList merged = new MonthDataList();

        for (int i = 0; i < size(); i++)
        {
            if (!names.contains(this.get(i).getChannelName()))
            {
                boolean add = false;
                names.add(this.get(i).getChannelName());

                MonthData k = new MonthData(
                    quarter,
                    this.get(i).getUsername(),
                    this.get(i).getChannelName(),
                    this.get(i).getCountry(),
                    this.get(i).getMainTopic(),
                    0,
                    0,
                    0,
                    0,
                    0);

                for (int j = 0; j < size(); j++)
                {
                    if ((this.get(j).getChannelName()
                        .equals(this.get(i).getChannelName()))
                        && (qualifies(quarter, this.get(j).getMonth())))
                    {
                        k = addition(k, this.get(j));
                        add = true;
                        if (this.get(j).getMonth() % 3 == 0)
                        {
                            k.setFollowers(this.get(j).getFollowers());

                        }

                    }

                }
                if (add)
                {
                    merged.add(k);
                }
            }
        }
        return merged;
    }


    // ----------------------------------------------------------
    /**
     * returns true if the month belongs to the quarter
     */
    private boolean qualifies(int quarter, int monthData)
    {
        if (quarter == -1
            && (monthData == 1 || monthData == 2 || monthData == 3))
        {
            return true;
        }

        if (quarter == -2
            && (monthData == 4 || monthData == 5 || monthData == 6))
        {
            return true;
        }

        if (quarter == -3
            && (monthData == 7 || monthData == 8 || monthData == 9))
        {
            return true;
        }

        return (quarter == -4
            && (monthData == 10 || monthData == 11 || monthData == 12));

    }


    // ----------------------------------------------------------
    /**
     * adds the data from one month data to the other
     * 
     * @param us
     *            the monthdata to add data to
     * @param them
     *            the monthdata whose data will be added
     * @return MonthData
     */
    private MonthData addition(MonthData us, MonthData them)
    {
        return new MonthData(
            us.getMonth(),
            us.getUsername(),
            us.getChannelName(),
            us.getCountry(),
            us.getMainTopic(),
            us.getLikes() + them.getLikes(),
            us.getPosts() + them.getPosts(),
            them.getFollowers(),
            us.getComments() + them.getComments(),
            us.getViews() + them.getViews());
    }

    // ----------------------------------------------------------


    /**
     * Sorting method, that will take a comparator as an input and sort the
     * given data based on the comparator type.
     * 
     * @param comparator
     *            - the comparator you want to use for sorting
     */
    public void insertionSort(Comparator<MonthData> comparator)
    {
        if (this.getHead() == null || this.getHead().next() == null)
        {
            return;
        }

        Node<MonthData> unsortedPart = getHead().next();
        Node<MonthData> sortedPart = getHead();
        sortedPart.setNext(null);

        while (unsortedPart != null)
        {
            Node<MonthData> nodeToInsert = unsortedPart;
            unsortedPart = unsortedPart.next();
            insertInOrder(nodeToInsert, comparator);
        }
    }


    /**
     * Private helper method, that will be utilized by main insertionSort method
     * in order to sort based on the comparator provided
     * 
     * @param comparator
     *            - the comparator you want to use for sorting
     * @param nodeToInsert
     *            - the node that shall be inserted
     */
    private void insertInOrder(
        Node<MonthData> nodeToInsert,
        Comparator<MonthData> comparator)
    {
        MonthData item = nodeToInsert.getData();
        Node<MonthData> currentNode = this.getHead();
        Node<MonthData> previousNode = null;

        while (currentNode != null
            && comparator.compare(item, currentNode.getData()) > 0)
        {
            previousNode = currentNode;
            currentNode = currentNode.next();
        }

        if (previousNode != null)
        {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else
        {
            nodeToInsert.setNext(this.getHead());
            this.setHead(nodeToInsert);
        }

    }


    // ----------------------------------------------------------
    /**
     * Specific method that allows to directly sort by name
     */
    public void sortByName()
    {
        insertionSort(new NameComparator());
    }


    /**
     * Specific method that allows to directly traditionally sort
     */
    public void sortByTraditional()
    {
        insertionSort(new TradComparator());
    }


    /**
     * Specific method that allows to directly sort by reach
     */
    public void sortByReach()
    {
        insertionSort(new ReachComparator());
    }

}
