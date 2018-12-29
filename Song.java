/**
 * 
 */
package prj5;

/**
 * @author vmanne20, jason199, zjames1
 * @version 11/12
 *
 */
public class Song {

    private String title;
    private String artist;
    private String genre;
    private String date;
    /**
     * Array that holds counts for people who
     * have heard the song. Each type of representation 
     * holds a spot in the array (12 total). For example, the 
     * count for people who are majoring in CS is stored in the 
     * first index.  
     */
    public int[] heard;
    /**
     * Array that holds counts for people who
     * have liked the song. Each type of representation 
     * holds a spot in the array (12 total). For example, the 
     * count for people who are majoring in CS is stored in the 
     * first index.  
     */
    public int[] liked;
    /**
     * Array that counts the number of people who have responded no 
     * for heard
     */
    public int[] notHeard;
    /**
     * Array that counts the number of people who have responded no 
     * for liked
     */
    public int[] notLiked;
    private static final int LENGTH = 12;
    /**
     * Constructs a Song object with a title, artist name,
     * year, and genre. 
     * 
     * @param title - name of song
     * @param artist - name of creator
     * @param date - year released
     * @param genre - type of music
     */
    public Song(String title, String artist, String date, String genre)
    {
        this.title = title;
        this.artist = artist;
        this.date = date;
        this.genre = genre;
        heard = new int[LENGTH];
        liked = new int[LENGTH];
        notHeard = new int[LENGTH];
        notLiked = new int[LENGTH];
    }

    /**
     * Gets the title of the song.
     * 
     * @return String - title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the artist of the song.
     * 
     * @return String - artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Gets the genre of the song.
     * 
     * @return String - genre
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Gets the year released
     * 
     * @return String - date
     */
    public String getDate()
    {
        return date;
    } 

    /**
     * Determines if two Song objects are 
     * equal to each other by comparing their
     * class, title, artist, genre, and date.
     * 
     * @return boolean - true if the above conditions
     * are met.
     * @param obj - Song object to be compared
     */
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

        if (obj.getClass() == this.getClass())
        {
            Song s1 = (Song) obj;
            return s1.getTitle().equals(this.getTitle()) 
                    && s1.getArtist().equals(this.getArtist())
                    && s1.getGenre().equals(this.getGenre())
                    && s1.getDate().equals(this.getDate());
        }
        return false;
    }

    /**
     * Returns the title of the song 
     * in string format.
     * 
     * @return String - first title
     */
    public String toString()
    {
        return getTitle();
    }
    
    
    
    
    /**
     * Returns an int array of percentages of students
     * with a specific major who heard/liked a 
     * song. Calculates the percentages for either
     * heard or liked if the string passed to the method
     * equals "heard" or "liked". Only calculates the 
     * percentages if the repCount element value is not 0, 
     * because you cannot divide by 0.
     * 
     * @param str - string specifiying heard or liked
     * @return int[] - array of percentages for each
     * major
     */
    public int[] getMajors(String str)
    {
        int[] temp = new int[4];

        for (int i = 0; i < temp.length; i++)
        {

            if (str.equals("heard"))
            {
                int heardTotal = heard[i] + notHeard[i];
                //System.out.println(heardTotal);
                if (heardTotal != 0)
                {
                    double val = ((double) heard[i] / 
                            heardTotal) * 100.0;
                    temp[i] = (int) val;
                    //System.out.println("t: " + temp[i]);
                }
            }

            else if (str.equals("liked"))
            {
                int likedTotal = liked[i] + notLiked[i];
                if (likedTotal != 0)
                {
                    double val = ((double) liked[i] / 
                            likedTotal) * 100.0;
                    temp[i] = (int) val;
                }
            }
            else
            {
                temp[i] = 0;
            }
        }

        return temp;
    }
    
    
    
    
    
    /**
     * Returns an int array of percentages of students
     * with a specific regions who heard/liked a 
     * song. Calculates the percentages for either
     * heard or liked if the string passed to the method
     * equals "heard" or "liked". Only calculates the 
     * percentages if the repCount element value is not 0, 
     * because you cannot divide by 0.
     * 
     * @param str - string specifiying heard or liked
     * @return int[] - array of percentages for each
     * region
     */
    public int[] getRegions(String str)
    {
        int[] temp = new int[4];

        for (int i = 0; i < temp.length; i++)
        {

            if (str.equals("heard"))
            {
                int heardTotal = heard[i + 4] + notHeard[i + 4];
                //System.out.println(heardTotal);
                if (heardTotal != 0)
                {
                    double val = ((double) heard[i + 4] / 
                            heardTotal) * 100.0;
                    temp[i] = (int) val;
                    //System.out.println("t: " + temp[i]);
                }
            }

            else if (str.equals("liked"))
            {
                int likedTotal = liked[i + 4] + notLiked[i + 4];
                if (likedTotal != 0)
                {
                    double val = ((double) liked[i + 4] / 
                            likedTotal) * 100.0;
                    temp[i] = (int) val;
                }
            }
            else
            {
                temp[i] = 0;
            }
        }

        return temp;
    }

    
    
    
    
    /**
     * Returns an int array of percentages of students
     * with a specific hobby who heard/liked a 
     * song. Calculates the percentages for either
     * heard or liked if the string passed to the method
     * equals "heard" or "liked". Only calculates the 
     * percentages if the repCount element value is not 0, 
     * because you cannot divide by 0.
     * 
     * @param str - string specifiying heard or liked
     * @return int[] - array of percentages for each
     * hobby
     */
    public int[] getHobbies(String str)
    {
        int[] temp = new int[4];

        for (int i = 0; i < temp.length; i++)
        {

            if (str.equals("heard"))
            {
                int heardTotal = heard[i + 8] + notHeard[i + 8];
                //System.out.println(heardTotal);
                if (heardTotal != 0)
                {
                    double val = ((double) heard[i + 8] / 
                            heardTotal) * 100.0;
                    temp[i] = (int) val;
                    //System.out.println("t: " + temp[i]);
                }
            }

            else if (str.equals("liked"))
            {
                int likedTotal = liked[i + 8] + notLiked[i + 8];
                if (likedTotal != 0)
                {
                    double val = ((double) liked[i + 8] / 
                            likedTotal) * 100.0;
                    temp[i] = (int) val;
                }
            }
            else
                
            {
                temp[i] = 0;
            }
        }

        return temp;
    }

    


}
