package prj5;

import cs2.*;
import java.awt.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Grant Piersall (ghpiersall)
// -- Rudolf Rissling (rudolfr)
// -- Brandon Baumgartner (bbaum11)

/**
 * Project window class that displays the data on the screen
 * 
 * @author Grant Piersall , Rudolf Rissling , Brandon Baumgartner
 * @version Nov 25, 2023
 */
public class GUIProjectWindow
{
    // ~ Fields ................................................................
    private InputFileReader input;
    private Window window;

    private MonthDataList display;
    private String sortType;
    private String currentTimePeriod = "None";
    private String currentEngagementType = "Traditional Engagement Rate";
    private String currentSortType = "Sorting by Channel Name";

    /**
     * The default bar width
     */
    public static final int BAR_WIDTH = 30;
    /**
     * An array of strings containing each string
     */
    public static final String[] MONTHS =
        { "January", "February", "March", "April", "May", "June", "July",
            "August", "Sepember", "October", "November", "December" };

    /**
     * An array of colors containing each color
     */
    public static final Color[] COLORS =
        new Color[] { Color.RED, Color.GREEN, Color.ORANGE, Color.BLUE, };
    /**
     * A string array containing the four quarters
     */
    public static final String[] QUARTERS =
        { "First", "Second", "Third", "Fourth" };

    // ----------------------------------------------------------

    // ~ Constructors ..........................................................
    /**
     * Create a new ProjectWindow object.
     * 
     * @param newInput
     *            is the file input reader who's data will be used
     */
    public GUIProjectWindow(InputFileReader newInput)
    {

        Button quitButton;
        Button channelSort;
        Button engagementSort;
        Button tradEngagement;
        Button reachEngagement;

        input = newInput;
        window = new Window("Social Media Vis: ghpiersall, rudolfr, bbaum11");

        // adding the buttons on the top of the window
        channelSort = new Button("Sort by Channel Name");
        channelSort.onClick(this, "clickedChannel");
        window.addButton(channelSort, WindowSide.NORTH);

        engagementSort = new Button("Sort by Engagement Rate");
        engagementSort.onClick(this, "clickedEngage");
        window.addButton(engagementSort, WindowSide.NORTH);

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        // adding the engagement type buttons on the left side of the window
        tradEngagement = new Button("Traditional Engagement Rate");
        tradEngagement.onClick(this, "tradEngage");
        window.addButton(tradEngagement, WindowSide.WEST);

        reachEngagement = new Button("Reach Engagement Rate");
        reachEngagement.onClick(this, "reachEngage");
        window.addButton(reachEngagement, WindowSide.WEST);

        // sort type will be by channel by default
        sortType = "channel";

        // adding the month buttons on the bottom of the window
        for (int i = 0; i < MONTHS.length; i++)
        {
            Button monthButton = new Button(MONTHS[i]);
            monthButton.onClick(this, "clickedMonth");
            window.addButton(monthButton, WindowSide.SOUTH);
        }

        // adding the group by quarter buttons
        Button quarterOne = new Button("First Quarter(Jan-March)");
        quarterOne.onClick(this, "clickedQuarter");
        window.addButton(quarterOne, WindowSide.SOUTH);

        Button quarterTwo = new Button("Second Quarter (Apr-June)");
        quarterTwo.onClick(this, "clickedQuarter");
        window.addButton(quarterTwo, WindowSide.SOUTH);

        Button quarterThree = new Button("Third Quarter (July-Sep)");
        quarterThree.onClick(this, "clickedQuarter");
        window.addButton(quarterThree, WindowSide.SOUTH);

        Button quarterFour = new Button("Fourth Quarter (Oct-Dec)");
        quarterFour.onClick(this, "clickedQuarter");
        window.addButton(quarterFour, WindowSide.SOUTH);

        // setting the height of the window
        window.setSize(window.getWidth(), window.getWidth() / 2);

        // default text that shows up when running the program
        TextShape firstText = new TextShape(
            0,
            0,
            "Please choose a time period to display its data");
        firstText
            .setX((window.getGraphPanelWidth() - firstText.getWidth()) / 2);
        firstText
            .setY((window.getGraphPanelHeight() - firstText.getHeight()) / 2);
        window.addShape(firstText);
        updateInfo();
    }
    // ~Public Methods ........................................................


    /**
     * Exits out of the window
     * 
     * @param button
     *            is the quit button
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    // ----------------------------------------------------------
    /**
     * Switches the sorting type to be by channel
     * 
     * @param button
     *            is the clicked button
     */
    public void clickedChannel(Button button)
    {
        sortType = "channel";
        if (display == null)
        {
            return;
        }
        currentSortType = "Sorting by Channel Name";
        updateInfo();
        refresh();

    }


    // ----------------------------------------------------------
    /**
     * Changes the sorting type to be by engagement
     * 
     * @param button
     *            is the clicked button
     */
    public void clickedEngage(Button button)
    {
        sortType = "engagement";
        if (display == null)
        {
            return;
        }
        currentSortType = "Sorting by Engagement Rate";
        updateInfo();
        refresh();
    }


    // ----------------------------------------------------------
    /**
     * Switches the engagement type to traditional
     * 
     * @param button
     *            is the clicked button
     */
    public void tradEngage(Button button)
    {
        if (display == null)
        {
            return;
        }
        currentEngagementType = "Traditional Engagement Rate";
        updateInfo();
        refresh();
    }


    /**
     * Switches the engagement type to reach
     * 
     * @param button
     *            is the clicked button
     */
    public void reachEngage(Button button)
    {
        if (display == null)
        {
            return;
        }
        currentEngagementType = "Reach Engagement Rate";
        updateInfo();
        refresh();
    }


    // ----------------------------------------------------------
    /**
     * Updates the text in the top left corner of the window
     */
    public void updateInfo()
    {
        int x = 20;
        int y = 20;
        int space = 20;

        TextShape periodInfo = new TextShape(x, y, currentTimePeriod);
        TextShape engagementInfo =
            new TextShape(x, y + space, currentEngagementType);
        TextShape sortTypeInfo =
            new TextShape(x, y + (2 * space), currentSortType);
        if (periodInfo != null)
        {
            window.removeShape(periodInfo);
        }
        if (engagementInfo != null)
        {
            window.removeShape(engagementInfo);
        }
        if (sortTypeInfo != null)
        {
            window.removeShape(sortTypeInfo);
        }
        window.addShape(periodInfo);
        window.addShape(engagementInfo);
        window.addShape(sortTypeInfo);
    }


    /**
     * Displays the information in the display field
     */
    private void refresh()
    {

        int space = 120;
        int totalBarWidth = BAR_WIDTH + space;
        int combinedWidth = display.size() * totalBarWidth - space;
        int initX = (window.getGraphPanelWidth() - combinedWidth) / 2;
        window.removeAllShapes();

        if (display.isEmpty())
        {
            TextShape emptyTime =
                new TextShape(0, 0, "No data for this time period");
            emptyTime
                .setX((window.getGraphPanelWidth() - emptyTime.getWidth()) / 2);
            emptyTime.setY(
                (window.getGraphPanelHeight() - emptyTime.getHeight()) / 2);
            window.addShape(emptyTime);
            return;
        }

        if (sortType.equals("channel"))
        {
            display.sortByName();
        }
        else if (currentEngagementType.equals("Traditional Engagement Rate"))
        {
            display.sortByTraditional();
        }
        else
        {
            display.sortByReach();
        }

        double scale = findScale();

        for (int i = 0; i < display.size(); i++)
        {
            double rate;

            Shape data;
            if (currentEngagementType.equals("Traditional Engagement Rate"))
            {
                rate = display.get(i).getTrad();
            }
            else
            {
                rate = display.get(i).getReach();
            }

            String rateString = String.format("%.1f", rate);

            if (rate == -1)
            {
                rateString = "N/A";
                rate = 0;
            }

            int x = initX + (i * totalBarWidth);
            int y = (window.getGraphPanelHeight() - 50);    // + 50);

            data = new Shape(
                x,
                y - (int)(rate * scale),
                BAR_WIDTH,
                (int)(rate * scale));
            Color color = COLORS[i % COLORS.length];
            data.setBackgroundColor(color);
            data.setForegroundColor(color);

            TextShape name =
                new TextShape(x, y, display.get(i).getChannelName());
            name.setX(x + (BAR_WIDTH / 2) - (name.getWidth() / 2));

            TextShape num = new TextShape(x, y + 15, rateString);
            num.setX(x + (BAR_WIDTH / 2) - (name.getWidth() / 2));

            window.addShape(name);
            window.addShape(num);

            window.addShape(data);

        }
        updateInfo();
    }


    /**
     * Finds a number to multiply the bar height by to make it scale properly
     * 
     * @return is the proper number to multiply the bars by
     */
    private double findScale()
    {
        double largestValue = 0;
        for (int i = 0; i < display.size(); i++)
        {
            if (currentEngagementType.equals("Traditional Engagement Rate"))
            {
                if (display.get(i).getTrad() > largestValue)
                {
                    largestValue = display.get(i).getTrad();
                }
            }
            else
            {
                if (display.get(i).getReach() > largestValue)
                {
                    largestValue = display.get(i).getReach();
                }
            }
        }
        return (window.getGraphPanelHeight() - 80) / largestValue;
    }


    // ----------------------------------------------------------
    /**
     * Changes the time period to the clicked month
     * 
     * @param button
     *            is the clicked button
     */
    public void clickedMonth(Button button)
    {
        window.removeAllShapes();
        String month = button.getTitle();
        display = new MonthDataList();
        for (int i = 0; i < input.getData().size(); i++)
        {
            if (MONTHS[input.getData().get(i).getMonth() - 1].equals(month))
            {
                display.add(input.getData().get(i));
            }
        }
        currentTimePeriod = month;
        updateInfo();
        refresh();
    }


    // ----------------------------------------------------------
    /**
     * Changes the time period to the clicked quarter
     * 
     * @param button
     *            is the clicked button
     */
    public void clickedQuarter(Button button)
    {
        window.removeAllShapes();
        String[] titleWords = button.getTitle().split("\\s+");
        String quarter = titleWords[0];
        int quarterNumber = 0;
        for (int i = 0; i < QUARTERS.length; i++)
        {
            if (QUARTERS[i].equals(quarter))
            {
                quarterNumber = (i + 1) * -1;
            }
        }
        display = input.getData().merge(quarterNumber);
        currentTimePeriod = quarter + " Quarter";
        updateInfo();
        refresh();
    }

}
