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
 * @author Grant Piersall , Rudolf Rissling , Brandon Baumgartner
 * @version Nov 16, 2023
 */

public class MonthData
    implements Comparable<MonthData>
{
    private int month;
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    // ----------------------------------------------------------
    /**
     * Create a new MonthData object.
     * 
     * @param m
     *            month
     * @param u
     *            username
     * @param ch
     *            channelname
     * @param c
     *            country
     * @param mt
     *            maintopic
     * @param l
     *            likes
     * @param p
     *            posts
     * @param f
     *            folowers
     * @param co
     *            comments
     * @param v
     *            views
     */
    public MonthData(
        int m,
        String u,
        String ch,
        String c,
        String mt,
        int l,
        int p,
        int f,
        int co,
        int v)
    {

        month = m;
        username = u;
        channelName = ch;
        country = c;
        mainTopic = mt;
        likes = l;
        posts = p;
        followers = f;
        comments = co;
        views = v;
    }


    // ----------------------------------------------------------
    /**
     * Returns the traditional engagement calculation
     * 
     * @return the traditional engagement value
     */
    public double getTrad()
    {
        if (followers == 0)
        {
            return -1;
        }

        return (((double)(comments + likes) * 100) / followers);
    }


    // ----------------------------------------------------------
    /**
     * Returns the reach engagement calculation
     * 
     * @return the reach engagement value
     */
    public double getReach()
    {
        if (views == 0)
        {
            return -1;
        }
        return (((double)(comments + likes) * 100) / views);
    }


    @Override
    public int compareTo(MonthData them)
    {
        return this.month - them.month;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the month field
     * 
     * @return the MonthData object's month field
     */
    public int getMonth()
    {
        return month;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the username field
     * 
     * @return the MonthData object's username field
     */
    public String getUsername()
    {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the channel name field
     * 
     * @return the MonthData object's channel name field
     */
    public String getChannelName()
    {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the country field
     * 
     * @return the MonthData object's country field
     */
    public String getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the main topic field
     * 
     * @return the MonthData object's main topic field
     */
    public String getMainTopic()
    {
        return mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the likes field
     * 
     * @return the MonthData object's likes field
     */
    public int getLikes()
    {
        return likes;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the posts field
     * 
     * @return the MonthData object's posts field
     */
    public int getPosts()
    {
        return posts;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the followers field
     * 
     * @return the MonthData object's followers field
     */
    public int getFollowers()
    {
        return followers;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the comments field
     * 
     * @return the MonthData object's comments field
     */
    public int getComments()
    {
        return comments;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the views field
     * 
     * @return the MonthData object's views field
     */
    public int getViews()
    {
        return views;
    }


    // ----------------------------------------------------------
    /**
     * sets the follower count
     * 
     * @param f
     *            follower count
     */
    public void setFollowers(int f)
    {
        followers = f;

    }


    // ----------------------------------------------------------
    /**
     * returns string version
     * 
     * @return string version
     */
    @Override
    public String toString()
    {
        return month + "," + username + "," + channelName + "," + country + ","
            + mainTopic + "," + likes + "," + posts + "," + followers + ","
            + comments + "," + views;

    }

}
