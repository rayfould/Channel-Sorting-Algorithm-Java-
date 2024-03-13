package prj5;

import java.io.IOException;

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
 * runner class
 * 
 * @author Grant Piersall , Rudolf Rissling , Brandon Baumgartner
 * @version Nov 16, 2023
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * main method
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException
    {
        boolean showConsole = true;
        boolean showGUI = true;

        InputFileReader filer;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }

        if (showConsole)
        {
            // filer = new InputFileReader("sampletest.csv");

            MonthDataList m = filer.getData();

            MonthDataList q1 = m.merge(-1);

            q1.sortByName();

            for (int i = 0; i < q1.size(); i++)
            {
                System.out.println(q1.get(i).getChannelName());

                System.out.println(
                    "traditional: "
                        + Math.round(q1.get(i).getTrad() * 10.0) / 10.0);

                System.out.println("==========");
            }

            System.out.println("**********");
            System.out.println("**********");

            q1.sortByReach();

            for (int i = 0; i < q1.size(); i++)
            {
                System.out.println(q1.get(i).getChannelName());

                double reach = q1.get(i).getReach();
                if (reach == -1)
                {
                    System.out.println("reach: N/A");
                }
                else
                {
                    System.out.println(
                        "reach: "
                            + Math.round(q1.get(i).getReach() * 10.0) / 10.0);
                }
                System.out.println("==========");
            }

        }
        if (showGUI)
        {
            @SuppressWarnings("unused")
            GUIProjectWindow window = new GUIProjectWindow(filer);
        }

    }
}
