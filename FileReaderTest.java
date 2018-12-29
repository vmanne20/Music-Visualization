package prj5;

import java.io.FileNotFoundException;

import student.TestCase;
/**
 * 
 * @author Vamsi Manne
 * @version 11/15
 */
public class FileReaderTest extends TestCase {

    private FileReader reader;
    /**
     * creates FileReader object
     */
    public void setUp()
    {
        reader = new FileReader();
    }
    
    /**
     * test survey file
     * @throws FileNotFoundException - when file is not found
     */
    public void testSurveyFile() throws FileNotFoundException
    {
        
        SongList<Song> list = reader.readSongFile("SongList.csv"); 
        reader.readSurveyFile("MusicSurveyData.csv");
        
        list.sortByTitle();
        
        int[] heardArr = {0, 14, 8, 15, 52, 56, 3,
            0, 13, 9, 25, 27};
        assertEquals(heardArr[0], list.get(0).heard[0]);
        assertEquals(heardArr[1], list.get(0).heard[1]);
        assertEquals(heardArr[2], list.get(0).heard[2]);
        assertEquals(heardArr[3], list.get(0).heard[3]);
        assertEquals(heardArr[4], list.get(0).heard[4]);
        assertEquals(heardArr[5], list.get(0).heard[5]);

        
        int[] notHeardArr = {0, 19, 20, 16, 92, 99, 5,
            9, 18, 15, 47, 50};
        assertEquals(notHeardArr[0], list.get(0).notHeard[0]);
        assertEquals(notHeardArr[1], list.get(0).notHeard[1]);
        assertEquals(notHeardArr[2], list.get(0).notHeard[2]);
        assertEquals(notHeardArr[3], list.get(0).notHeard[3]);
        assertEquals(notHeardArr[4], list.get(0).notHeard[4]);

        
        int[] likedArr = {0, 15, 7, 16, 44, 59, 3,
            0, 12, 9, 23, 28};
        assertEquals(likedArr[0], list.get(0).liked[0]);
        assertEquals(likedArr[1], list.get(0).liked[1]);
        assertEquals(likedArr[2], list.get(0).liked[2]);
        assertEquals(likedArr[3], list.get(0).liked[3]);
        assertEquals(likedArr[4], list.get(0).liked[4]);
        
        //edge cases
        assertEquals(0, list.get(58).heard[0]);
        assertEquals(82, list.get(58).heard[5]);
        

        
    }
}
