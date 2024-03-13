package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
 * class that reads files, partially based on the project 4 playlistreader
 * 
 * @author Grant Piersall , Rudolf Rissling , Brandon Baumgartner
 * @version Nov 16, 2023
 */
public class InputFileReader
{
    private MonthDataList data;

    // ----------------------------------------------------------
    /**
     * Create a new InputFileReader object.
     * 
     * @param file
     * @throws FileNotFoundException
     */
    public InputFileReader(String file)
        throws FileNotFoundException
    {
        readFile(file);
    }


    // ----------------------------------------------------------
    /**
     * reads files and adds them to data
     * 
     * @param filename
     * @throws FileNotFoundException
     */
    public void readFile(String filename)
        throws FileNotFoundException
    {
        data = new MonthDataList();

        File newFile = new File(filename);
        @SuppressWarnings("resource")
        Scanner inStream = new Scanner(newFile);

        inStream.nextLine();// skip header

        while (inStream.hasNextLine())
        {

            String line = inStream.nextLine();
            String[] values = line.split(",");

            int month = monthInt(values[0]);
            String username = values[1];
            String channel = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);

            if (month != 666)
            {
                MonthData m = new MonthData(
                    month,
                    username,
                    channel,
                    country,
                    mainTopic,
                    likes,
                    posts,
                    followers,
                    comments,
                    views);

                data.add(m);

            }

        }
        inStream.close();
    }


    /**
     * Returns the integer representation of a string if there is one
     * 
     * @param str
     *            is the string that will be looked at
     * @return is the integer representation of the string, and 0 if there is
     *             none
     */
    private int toInt(String str)
    {

        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    /**
     * Converts a string to an integer representing a month
     * 
     * @param month
     *            is the string that may contain the month
     * @return is the number 1-12 representing the month, and 666 if the string
     *             is not month
     */
    private int monthInt(String month)
    {
        int mo = 666;
        switch (month)
        {
            case "January":
                mo = 1;
                break;
            case "February":
                mo = 2;
                break;
            case "March":
                mo = 3;
                break;
            case ("April"):
                mo = 4;
                break;
            case "May":
                mo = 5;
                break;
            case "June":
                mo = 6;
                break;
            case "July":
                mo = 7;
                break;
            case "August":
                mo = 8;
                break;
            case "September":
                mo = 9;
                break;
            case "October":
                mo = 10;
                break;
            case "November":
                mo = 11;
                break;
            case "December":
                mo = 12;
                break;
            default:
                break;
        }
        return mo;
    }


    // ----------------------------------------------------------
    /**
     * gets data
     * 
     * @return data
     */
    public MonthDataList getData()
    {
        return data;
    }
}
