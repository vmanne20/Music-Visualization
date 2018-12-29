package prj5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author vmanne20, jason199, zjames1
 * @version 11/14
 *
 */
public class FileReader {

    private SongList<Song> list;
    /**
     * constructs FileReader object that contains
     * a SongList object to contain songs read from
     * song file
     */
    public FileReader()
    {
        list = new SongList<Song>();
    }

    /**
     * Reads all of the songs into a list from the file
     * specified in the argument 
     * 
     * @param songsFile - file containing songs
     * @return SongList<Song> - list containing songs parsed
     * from file
     * @throws FileNotFoundException - throws when file is not found
     */
    public SongList<Song> readSongFile(String songsFile) 
            throws FileNotFoundException
    {
        Scanner file = new Scanner(new File(songsFile));
      

        file.nextLine();
        while (file.hasNextLine())
        {
            String str = file.nextLine();
            String[] songTraits = str.split(",");
            Song tempSong = new Song(songTraits[0], songTraits[1], 
                    songTraits[2], songTraits[3]);
            list.add(tempSong);
        }

        file.close();
        return list;
    }

    /**
     * Counts the number of heards and likes, as well as the
     * total counts, by updating
     * the respective arrays for each Song object in the list.
     * 
     * @param surveyFile - file containing each person's survey 
     * record
     * @throws FileNotFoundException - when file is not found
     */
    public void readSurveyFile(String surveyFile) throws FileNotFoundException
    {
        int count = 5;

        //counts heards and likes for each song
        for (int i = 0; i < list.size(); i++)
        {

            Scanner file = new Scanner(new File(surveyFile));

            file.nextLine();
            //reads through each person's data
            int c = 1;
            while (file.hasNextLine())
            {
                String str = file.nextLine();
                String[] person = str.split("\\,", -1);
                String major = person[2];
                String region = person[3];
                String hobby = person[4];
                if (c == 24)
                {
                    System.out.println(person[5]);
                }
                //System.out.println("C: " + c + " --- " + "MAJOR: " + major + " REGION: " + region);
                //if student attributes are not blank, count them
                if (major.length() > 1 && region.length() > 1 && 
                        hobby.length() > 1 && 
                        !(i == 0 && person[count].length() < 2))
                {
                    //System.out.println("NO BLANKS");
                    //represented by major
                    switch (major)
                    {
                        //1st major
                        case ("Computer Science"): 
                            checkCS(person, count, i);
                            break;

                        //2nd major
                        case ("Other Engineering"): 
                            checkOtherEng(person, count, i); 
                            break;

                        //3rd major
                        case ("Math or CMDA"): 
                            checkMathCMDA(person, count, i);
                            
                            break;

                        //4th major
                        case ("Other"): checkOther(person, count, i);
                            
                            break;

                        default: break;
                    }








                    //represented by region
                    switch (region)
                    {
                        //1st region
                        case ("Northeast"): 
                            checkNortheast(person, count, i);
                            
                            break;

                        //2nd region
                        case ("Southeast"): 
                            checkSoutheast(person, count, i);
                            
                            break;

                        //3rd region
                        case ("United States (other than "
                                + "Southeast or Northwest)"): 
                            checkUS(person, count, i);
                            
                            break;

                                //4th region
                        case ("Outside of United States"): 
                            checkOutsideUS(person, count, i);
                            
                            break;


                        default: break;
                    }






                    //represented by hobby
                    switch (hobby)
                    {
                        //1st hobby
                        case ("reading"): 
                            checkReading(person, count, i);
                            
                            break;

                        //2nd hobby
                        case ("art"): 
                            checkArt(person, count, i);
                            
                            break;

                        //3rd hobby
                        case ("sports"): 
                            checkSports(person, count, i);
                            
                            break;

                        //4th hobby
                        case ("music"): 
                            checkMusic(person, count, i);
                            
                            break;

                        default: break;
                    }




                } // end of if statement



                c++;
            } //end of while loop

            count += 2;
            file.close();
        } //end of for loop

    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for CS majors. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkCS(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[4]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[4]++;
        }
        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[4]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[4]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for Engineering majors. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkOtherEng(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[1]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[1]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[1]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[1]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for Math/CMDA majors. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkMathCMDA(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[2]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[2]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[2]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[2]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for other majors. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkOther(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[3]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[3]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[3]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[3]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for NE region. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkNortheast(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[4]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[4]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[4]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[4]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for SE region. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkSoutheast(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[5]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[5]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[5]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[5]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for anywhere in US. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkUS(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[6]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[6]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[6]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[6]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for outside US. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkOutsideUS(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[7]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[7]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[7]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[7]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for reading. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkReading(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[8]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[8]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[8]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[8]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for art. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkArt(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[9]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[9]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[9]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[9]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for sports. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkSports(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[10]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[10]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[10]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[10]++;
        }
    }
    
    /**
     * updates heard, notHeard, liked, and notLiked 
     * arrays if yes or no is found for each heard
     * or liked response for music. Also checks if 
     * the count is within range of the split array to 
     * prevent IndexOutOfBoundsException
     * 
     * @param person - array that contains each response
     * @param count - current count through array
     * @param i - song number
     */
    public void checkMusic(String[] person, int count, int i)
    {
        if (person[count].equals("Yes"))
        {
            list.get(i).heard[11]++;
        }
        else if (person[count].equals("No"))
        {
            list.get(i).notHeard[11]++;
        }

        if (person[count + 1].equals("Yes"))
        {
            list.get(i).liked[11]++;
        }
        else if (person[count + 1].equals("No"))
        {
            list.get(i).notLiked[11]++;
        }
    }
    
    

}
