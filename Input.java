/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * @author vmanne20, jason199, zjames1
 * @version 11/12
 *
 */
public class Input {

    /**
     * The main method for testing the output of percentages
     * of people with a specific representation who heard/liked a song.
     * First, the song and survey files are read using the FileReader 
     * methods: readSongFile() and readSurveyFile().
     * getHobbies() method from Song class is called to obtain these
     * percentages.
     * 
     * @param args - input that contains two file names, that 
     * of song file and survey file
     * @throws FileNotFoundException when file is not found
     */
    public static void main(String[] args) 
            throws FileNotFoundException
    {
        FileReader reader = new FileReader();
        SongList<Song> list = null;
        if (args.length == 2)
        {
            list = reader.readSongFile(args[1]); 
            reader.readSurveyFile(args[0]);
        }
        else
        {
            list = reader.readSongFile("SongList2016F.csv"); 
            reader.readSurveyFile("MusicSurveyData2016F.csv");
        }
        int[] percents = null;
        list.sortByGenre();
        for (int i = 0; i < list.size(); i++)
        {
            //int i = 0;
            System.out.println("Song Title: " + list.get(i).getTitle());
            System.out.println("Song Artist: " + list.get(i).getArtist());
            System.out.println("Song Genre: " + list.get(i).getGenre());
            System.out.println("Song Year: " + list.get(i).getDate());

            System.out.println("Heard");
            percents = list.get(i).getHobbies("heard");
            System.out.println("reading:" + percents[0] + " art:" + percents[1] 
                    + " sports:" + percents[2] + " music:" + percents[3]);

            System.out.println("Likes");
            percents = list.get(i).getHobbies("liked");
            System.out.println("reading:" + percents[0] + " art:" + percents[1] 
                    + " sports:" + percents[2] + " music:" + percents[3]);
            System.out.println();
        }

        list.sortByTitle();
        for (int i = 0; i < list.size(); i++)
        {
            //int i = 0;
            System.out.println("Song Title: " + list.get(i).getTitle());
            System.out.println("Song Artist: " + list.get(i).getArtist());
            System.out.println("Song Genre: " + list.get(i).getGenre());
            System.out.println("Song Year: " + list.get(i).getDate());

            System.out.println("Heard");
            percents = list.get(i).getHobbies("heard");
            System.out.println("reading:" + percents[0] + " art:" + percents[1] 
                    + " sports:" + percents[2] + " music:" + percents[3]);

            System.out.println("Likes");
            percents = list.get(i).getHobbies("liked");
            System.out.println("reading:" + percents[0] + " art:" + percents[1] 
                    + " sports:" + percents[2] + " music:" + percents[3]);
            System.out.println();
        }
        /*System.out.println("heard 0: " + list.get(0).n[0]);
        System.out.println("heard 1: " + list.get(0).liked[1]);
        System.out.println("heard 2: " + list.get(0).liked[2]);
        System.out.println("heard 3: " + list.get(0).liked[3]);
        System.out.println("heard 3: " + list.get(0).liked[4]);
        System.out.println("heard 3: " + list.get(0).liked[5]);
        System.out.println("heard 3: " + list.get(0).liked[6]);
        System.out.println("heard 3: " + list.get(0).liked[7]);
        System.out.println("heard 3: " + list.get(0).liked[8]);
        System.out.println("heard 3: " + list.get(0).liked[9]);
        System.out.println("heard 3: " + list.get(0).liked[10]);
        System.out.println("heard 3: " + list.get(0).liked[11]);*/
    }


}
