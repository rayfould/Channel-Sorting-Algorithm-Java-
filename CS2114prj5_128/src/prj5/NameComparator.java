package prj5;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

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

public class NameComparator
    implements Comparator<MonthData>
{

    @Override
    public int compare(MonthData m1, MonthData m2)
    {
        Collator myCollator = Collator.getInstance(Locale.US);
        myCollator.setStrength(Collator.PRIMARY);
        return myCollator.compare(m1.getChannelName(), m2.getChannelName());
    }

}
