
package prj5;
import student.TestCase;
/**
 * @author vmanne20, jason199, zjames1
 * @version 11/14
 *
 */
public class SongTest extends TestCase {

    private Song s1;
    /**
     * creates Song objects for testing
     */
    public void setUp()
    {
        s1 = new Song("Hello", "Adele", "2015", "Pop");
    }
    
    /**
     * test getTitle()
     */
    public void testGetTitle()
    {
        assertEquals("Hello", s1.getTitle());
    }
    
    /**
     * test getArtist()
     */
    public void testGetArtist()
    {
        assertEquals("Adele", s1.getArtist());
    }
    
    /**
     * test getDate()
     */
    public void testGetDate()
    {
        assertEquals("2015", s1.getDate());
    }
    
    /**
     * test getGenre()
     */
    public void testGetGenre()
    {
        assertEquals("Pop", s1.getGenre());
    }
    
    /**
     * test equals()
     */
    public void testEquals()
    {
        Song s2 = null;
        Object s3 = new Object();
        Song s4 = new Song("Hello", "Adele", "2015", "Pop");
        Song s5 = new Song("Hello", "Adele", "2015", "Rock");
        Song s6 = new Song("Bye", "Adele", "2015", "Pop");
        Song s7 = new Song("Hello", "Nobody", "2015", "Pop");
        Song s8 = new Song("Hello", "Adele", "2014", "Pop");
        
        assertTrue(s1.equals(s1));
        assertFalse(s1.equals(s2));
        assertFalse(s1.equals(s3));
        assertTrue(s1.equals(s4));
        assertFalse(s1.equals(s5));
        assertFalse(s1.equals(s6));
        assertFalse(s1.equals(s7));
        assertFalse(s1.equals(s8));
    }
    
    /**
     * tests toString()
     */
    public void testToString()
    {
        assertEquals("Hello", s1.toString());
    }
    
    /**
     * tests getMajors()
     */
    public void testGetMajors()
    {
        s1.heard[0] = 2;
        s1.heard[1] = 3;
        s1.heard[2] = 7;
        s1.heard[3] = 0;
        
        s1.notHeard[0] = 8;
        s1.notHeard[1] = 7;
        s1.notHeard[2] = 13;
        s1.notHeard[3] = 0;
        
        int[] heard1 = {20, 30, 35, 0};
        String str = "heard";
        int[] heard2 = s1.getMajors(str);
        
        assertEquals(heard1[0], heard2[0]);
        assertEquals(heard1[1], heard2[1]);
        assertEquals(heard1[2], heard2[2]);
        assertEquals(heard1[3], heard2[3]);
        
        s1.liked[0] = 0;
        s1.liked[1] = 1;
        s1.liked[2] = 8;
        s1.liked[3] = 9;
        
        s1.notLiked[0] = 0;
        s1.notLiked[1] = 9;
        s1.notLiked[2] = 12;
        s1.notLiked[3] = 16;
        
        int[] liked1 = {0, 10, 40, 36};
        str = "liked";
        int[] liked2 = s1.getMajors(str);
        
        assertEquals(liked1[0], liked2[0]);
        assertEquals(liked1[1], liked2[1]);
        assertEquals(liked1[2], liked2[2]);
        assertEquals(liked1[3], liked2[3]);
        
        str = "hi";
        int[] arr = {0, 0, 0, 0};
        int[] arr2 = s1.getMajors(str);
        assertEquals(arr[0], arr2[0]);
        assertEquals(arr[1], arr2[1]);
        assertEquals(arr[2], arr2[2]);
        assertEquals(arr[3], arr2[3]);
    }
    
    
    /**
     * tests getRegions()
     */
    public void testGetRegions()
    {
        s1.heard[4] = 2;
        s1.heard[5] = 3;
        s1.heard[6] = 7;
        s1.heard[7] = 0;
        
        s1.notHeard[4] = 8;
        s1.notHeard[5] = 7;
        s1.notHeard[6] = 13;
        s1.notHeard[7] = 0;
        
        int[] heard1 = {20, 30, 35, 0};
        String str = "heard";
        int[] heard2 = s1.getRegions(str);
        
        assertEquals(heard1[0], heard2[0]);
        assertEquals(heard1[1], heard2[1]);
        assertEquals(heard1[2], heard2[2]);
        assertEquals(heard1[3], heard2[3]);
        
        s1.liked[4] = 0;
        s1.liked[5] = 1;
        s1.liked[6] = 8;
        s1.liked[7] = 9;
        
        s1.notLiked[4] = 0;
        s1.notLiked[5] = 9;
        s1.notLiked[6] = 12;
        s1.notLiked[7] = 16;
        
        int[] liked1 = {0, 10, 40, 36};
        str = "liked";
        int[] liked2 = s1.getRegions(str);
        
        assertEquals(liked1[0], liked2[0]);
        assertEquals(liked1[1], liked2[1]);
        assertEquals(liked1[2], liked2[2]);
        assertEquals(liked1[3], liked2[3]);
        
        str = "hi";
        int[] arr = {0, 0, 0, 0};
        int[] arr2 = s1.getRegions(str);
        assertEquals(arr[0], arr2[0]);
        assertEquals(arr[1], arr2[1]);
        assertEquals(arr[2], arr2[2]);
        assertEquals(arr[3], arr2[3]);
    }
    
    
    /**
     * tests getHobbies()
     */
    public void testGetHobbies()
    {
        s1.heard[8] = 2;
        s1.heard[9] = 3;
        s1.heard[10] = 7;
        s1.heard[11] = 0;
        
        s1.notHeard[8] = 8;
        s1.notHeard[9] = 7;
        s1.notHeard[10] = 13;
        s1.notHeard[11] = 0;
        
        int[] heard1 = {20, 30, 35, 0};
        String str = "heard";
        int[] heard2 = s1.getHobbies(str);
        
        assertEquals(heard1[0], heard2[0]);
        assertEquals(heard1[1], heard2[1]);
        assertEquals(heard1[2], heard2[2]);
        assertEquals(heard1[3], heard2[3]);
        
        s1.liked[8] = 0;
        s1.liked[9] = 1;
        s1.liked[10] = 8;
        s1.liked[11] = 9;
        
        s1.notLiked[8] = 0;
        s1.notLiked[9] = 9;
        s1.notLiked[10] = 12;
        s1.notLiked[11] = 16;
        
        int[] liked1 = {0, 10, 40, 36};
        str = "liked";
        int[] liked2 = s1.getHobbies(str);
        
        assertEquals(liked1[0], liked2[0]);
        assertEquals(liked1[1], liked2[1]);
        assertEquals(liked1[2], liked2[2]);
        assertEquals(liked1[3], liked2[3]);
        
        str = "hi";
        int[] arr = {0, 0, 0, 0};
        int[] arr2 = s1.getHobbies(str);
        assertEquals(arr[0], arr2[0]);
        assertEquals(arr[1], arr2[1]);
        assertEquals(arr[2], arr2[2]);
        assertEquals(arr[3], arr2[3]);
    }
    
    
    
}
