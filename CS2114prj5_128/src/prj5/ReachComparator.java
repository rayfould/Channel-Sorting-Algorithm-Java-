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

public class ReachComparator
    implements Comparator<MonthData>
{

    @Override
    public int compare(MonthData m1, MonthData m2)
    {

        return Double.compare(m2.getReach(), m1.getReach());
    }

}
