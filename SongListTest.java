/**
 * 
 */
package prj5;



import java.util.Iterator;
import java.util.NoSuchElementException;

import student.TestCase;
/**
 * @author vmanne20, jason199, zjames1
 * @version 11/14
 *
 */
public class SongListTest extends TestCase {

    private SongList<Song> list;
    private Song song1;
    private Song song2;
    private Song song3;
    private Iterator<Song> iter;
    /**
     * creates Song objects in list for testing
     */
    public void setUp()
    {
        song1 = new Song("Hello", "Adele", "2015", "Pop");
        song2 = new Song("Dream On", "Aerosmith", "1980", "Rock");
        song3 = new Song("Lose Yourself", "Eminem", "2002", "Rap");
        
        list = new SongList<Song>();
        
        iter = list.iterator();
    }
    
    /**
     * tests size()
     */
    public void testSize()
    {
        assertEquals(0, list.size());
        
        assertTrue(list.add(song1));
        list.add(song2);
        assertEquals(2, list.size());

    }
   
   
    
    public void testAddIterator()
    {
        list.add(song1);
        list.add(song2);
        list.add(song3);
        iter = list.iterator();
        assertEquals(3, list.size());
        
        assertTrue(iter.hasNext());
        assertEquals(song1, list.get(0));
        assertEquals(song1, iter.next());
        assertEquals(song2, iter.next());
        assertEquals(song3, iter.next());
        assertFalse(iter.hasNext());
        Exception exception = null;
        try
        {
            iter.next();
        }
        catch (NoSuchElementException e)
        {
            exception = e;
        }
        assertTrue( exception instanceof NoSuchElementException);
    }
    
   
    
    public void testIsEmptyIterator()
    {
        assertEquals(0, list.size());
        assertFalse(iter.hasNext());
        
        assertFalse(iter.hasNext());
        
        Exception exception = null;
        try
        {
            iter.next();
        }
        catch (NoSuchElementException e)
        {
            exception = e;
        }
        assertTrue( exception instanceof NoSuchElementException);
    }
    
    public void testRemoveIterator()
    {
        list.add(song1);
        list.add(song2);
        list.add(song3);
        iter = list.iterator();
        assertEquals(3, list.size());
        
        assertTrue(iter.hasNext());
        Exception exception =  null;
        try
        {
            iter.remove();
        }
        catch (IllegalStateException e)
        {
            exception = e;
        }
        assertTrue( exception instanceof IllegalStateException);
        assertEquals(3, list.size());
        
        assertEquals(song1, iter.next());
        //assertEquals(song2, iter.next());
        iter.remove();
        assertEquals(2, list.size());
        
        try
        {
            iter.remove();
        }
        catch (IllegalStateException e)
        {
            exception = e;
        }
        assertTrue( exception instanceof IllegalStateException);
        
        assertEquals(song2, iter.next());
        //assertEquals(song2, iter.next());
        iter.remove();
        assertEquals(1, list.size());
        
        assertEquals(song3, iter.next());
        //assertEquals(song2, iter.next());
        iter.remove();
        assertEquals(0, list.size());
        
        try
        {
            iter.remove();
        }
        catch (IllegalStateException e)
        {
            exception = e;
        }
        assertTrue( exception instanceof IllegalStateException);
        
    }
    
   
    /**
     * tests size()
     */
    public void testGet()
    {
        Exception exception = null;
        try
        {
            list.get(0);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertTrue( exception instanceof IndexOutOfBoundsException);
        
        try
        {
            list.get(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertTrue( exception instanceof IndexOutOfBoundsException);
        
        list.add(song1);
        list.add(song2);
        list.add(song3);
        assertEquals(song1, list.get(0));
        assertEquals(song2, list.get(1));
        assertEquals(song3, list.get(2));
        
        try
        {
            list.get(3);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertTrue( exception instanceof IndexOutOfBoundsException);
    }
    
    /**
     * tests add()
     */
    public void testAdd()
    {
        Exception exception = null;
        try
        {
            list.add(null);
        }
        catch (IllegalArgumentException e)
        {
            exception = e;
        }
        assertTrue( exception instanceof IllegalArgumentException);
        assertEquals(0, list.size());
        
        assertTrue(list.add(song1));
        assertEquals(song1, list.get(0));
        assertEquals(1, list.size());
        
        assertTrue(list.add(song2));
        assertTrue(list.add(song3));
        assertEquals(song1, list.get(0));
        assertEquals(song2, list.get(1));
        assertEquals(3, list.size());
    }
    
    /**
     * tests sortByGenre()
    */
   
    public void testSortByTitle()
    {
        assertEquals(0, list.size());
        list.sortByTitle();
        Song song4 = new Song("Zoo", 
                "Eminem", "2002", "Zolo");
        
        
        list.add(song1);
        list.add(song2);
        list.sortByTitle();
        assertEquals(song2, list.get(0));
        assertEquals(song1, list.get(1));
        
        list.add(song4);
        list.add(song3);
        assertEquals(4, list.size());
        assertEquals(song2, list.get(0));
        assertEquals(song1, list.get(1)); 
        assertEquals(song4, list.get(2));
        assertEquals(song3, list.get(3));
        
        
        list.sortByTitle();
        assertEquals(song2, list.get(0));
        assertEquals(song1, list.get(1)); 
        assertEquals(song3, list.get(2));
        assertEquals(song4, list.get(3));
        
    }
    
    /**
     * tests sortByGenre()
     */
    public void testSortByGenre()
    {
        assertEquals(0, list.size());
        list.sortByGenre();
        Song song4 = new Song("Zoo", 
                "Eminem", "2002", "Zolo");
        
        
        list.add(song2);
        list.add(song1);
        list.sortByGenre();
        assertEquals(song1, list.get(0));
        assertEquals(song2, list.get(1));
        
        list.add(song4);
        list.add(song3);
        assertEquals(4, list.size());
        assertEquals(song1, list.get(0));
        assertEquals(song2, list.get(1)); 
        assertEquals(song4, list.get(2));
        assertEquals(song3, list.get(3));
        
        
        list.sortByGenre();
        assertEquals(song1, list.get(0));
        assertEquals(song3, list.get(1)); 
        assertEquals(song2, list.get(2));
        assertEquals(song4, list.get(3));
        
    }
    
    public void testSortByArtist()
    {
        assertEquals(0, list.size());
        list.sortByGenre();
        Song song4 = new Song("Zoo", 
                "A", "2002", "Zolo");
        
        list.add(song2);
        list.add(song1);
        list.sortByArtist();
        assertEquals(song1, list.get(0));
        assertEquals(song2, list.get(1));
        
        list.add(song3);
        list.add(song4);
        assertEquals(song3, list.get(2));
        assertEquals(song4, list.get(3));
        
        list.sortByArtist();
        assertEquals(song4, list.get(0));
        assertEquals(song1, list.get(1));
        assertEquals(song2, list.get(2));
        assertEquals(song3, list.get(3));
    }
    
    public void testSortByDate()
    {
        assertEquals(0, list.size());
        list.sortByGenre();
        Song song4 = new Song("Zoo", 
                "Eminem", "2000", "Zolo");
        
        list.add(song1);
        list.add(song2);
        list.sortByDate();
        assertEquals(song2, list.get(0));
        assertEquals(song1, list.get(1));
        
        list.add(song3);
        list.add(song4);
        assertEquals(song3, list.get(2));
        assertEquals(song4, list.get(3));
        
        list.sortByDate();
        assertEquals(song2, list.get(0));
        assertEquals(song4, list.get(1));
        assertEquals(song3, list.get(2));
        assertEquals(song1, list.get(3));
    }
    
    public void testToString()
    {
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
        
        list.add(song1);
        list.add(song2);
        assertEquals("[Hello, Dream On]", list.toString());
        
        list.sortByTitle();
        assertEquals("[Dream On, Hello]", list.toString());
        
        list.add(song3);
        assertEquals("[Dream On, Hello, Lose Yourself]", 
                list.toString());
    }
    
    
}
