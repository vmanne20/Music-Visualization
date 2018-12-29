/**
 * 
 */
package prj5;

import java.awt.Color;
import java.awt.Graphics2D;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * @author Jason
 * @version <11.22.16>
 */
public class GUIGlyph extends Shape
{
    private Shape     song1_1;
    private Shape     song1_2;
    private Shape     song1_3;
    private Shape     song1_4;
    private Shape     song2_1;
    private Shape     song2_2;
    private Shape     song2_3;
    private Shape     song2_4;
    private TextShape song1;
    private TextShape songArtist1;
    private Shape     song1Bar;
    private Song      song;
    private Window    window;
    private int       xPosition;
    private int       yPosition;
    private boolean   glyphCreated;
    private int [] hobbiesLiked;
    private int [] majorsLiked;
    private int [] regionsLiked;
    private int [] hobbiesHeard;
    private int [] regionsHeard;
    private int [] majorsHeard;
    public static final int MULTIPLIER = 1;


    public GUIGlyph(int xPos, int yPos, Song song1, Window window1, String represenation)
    {
        super(xPos, yPos);

        this.xPosition = xPos;
        this.yPosition = yPos;

        this.song = song1;
        this.window = window1;
        
        hobbiesLiked = song1.getHobbies("liked");
        regionsLiked = song1.getRegions("liked");
        majorsLiked = song1.getMajors("liked");
        hobbiesHeard = song1.getHobbies("heard");
        regionsHeard = song1.getRegions("heard");
        majorsHeard = song1.getMajors("heard");

        glyphCreated = false;
        this.createComponents(represenation);
        glyphCreated = true;
    }


    @Override
    public void draw(Graphics2D graph)
    {
        super.remove();
    }


    public void removeComponents()
    {
        if (glyphCreated != false)
        {
            song1_1.remove();
            song1_2.remove();
            song1_3.remove();
            song1_4.remove();
            song2_1.remove();
            song2_2.remove();
            song2_3.remove();
            song2_4.remove();
            song1.remove();
            songArtist1.remove();
            song1Bar.remove();
        }
    }


    public void createComponents(String str)
    {
        this.removeComponents();

        song1 = new TextShape(0, 0, song.getTitle(), Color.BLACK);
        int song1X = xPosition - song1.getWidth() / 2;
        int song1Y = yPosition;
        song1.moveTo(song1X, song1Y);
        song1.setBackgroundColor(Color.WHITE);
        window.addShape(song1);

        songArtist1 = new TextShape(0, 0, ("by " + song.getArtist()),
            Color.BLACK);
        int songArtist1X = xPosition - songArtist1.getWidth() / 2;
        int songArtist1Y = song1Y + song1.getHeight();
        songArtist1.moveTo(songArtist1X, songArtist1Y);
        songArtist1.setBackgroundColor(Color.WHITE);
        window.addShape(songArtist1);

        int song1BarWidth = 10;
        int song1BarHeight = window.getGraphPanelHeight() / 8;
        int song1BarX = xPosition - song1BarWidth / 2;
        int song1BarY = song1Y + song1.getHeight() * 5 / 2;
        song1Bar = new Shape(song1BarX, song1BarY, song1BarWidth,
            song1BarHeight, Color.BLACK);
        window.addShape(song1Bar);

        ///////////////////
        // LIKES //
        ///////////////////

        int song1_1Width = 0;
        switch (str)
        {
            case "hobby":
            {
                song1_1Width = hobbiesLiked[0] * MULTIPLIER;
                break;
            }
            case "major":
            {
                song1_1Width = majorsLiked[0] * MULTIPLIER;
                break;
            }
            case "region":
            {
                song1_1Width = regionsLiked[0] * MULTIPLIER;
                break;
            }
            default:
            {
                break;
            }
        }

        int song1_1Height = song1BarHeight / 4;
        int song1_1X = song1BarX + song1BarWidth;
        int song1_1Y = song1BarY;
        song1_1 = new Shape(song1_1X, song1_1Y, song1_1Width, song1_1Height,
            Color.MAGENTA);
        window.addShape(song1_1);

        int song1_2Width = 0;
        switch (str)
        {
            case "hobby":
            {
                song1_2Width = hobbiesLiked[1] * MULTIPLIER;
                break;
            }
            case "major":
            {
                song1_2Width = majorsLiked[1] * MULTIPLIER;
                break;
            }
            case "region":
            {
                song1_2Width = regionsLiked[1] * MULTIPLIER;
                break;
            }
            default:
            {
                break;
            }
        }

        int song1_2Height = song1BarHeight / 4;
        int song1_2X = song1BarX + song1BarWidth;
        int song1_2Y = song1BarY + song1_1Height * 1;
        song1_2 = new Shape(song1_2X, song1_2Y, song1_2Width, song1_2Height,
            Color.BLUE);
        window.addShape(song1_2);

        int song1_3Width = 0;
        switch (str)
        {
            case "hobby":
            {
                song1_3Width = hobbiesLiked[2] * MULTIPLIER;
                break;
            }
            case "major":
            {
                song1_3Width = majorsLiked[2] * MULTIPLIER;
                break;
            }
            case "region":
            {
                song1_3Width = regionsLiked[2] * MULTIPLIER;
                break;
            }
            default:
            {
                break;
            }
        }

        int song1_3Height = song1BarHeight / 4;
        int song1_3X = song1BarX + song1BarWidth;
        int song1_3Y = song1BarY + song1_1Height * 2;
        song1_3 = new Shape(song1_3X, song1_3Y, song1_3Width, song1_3Height,
            Color.YELLOW);
        window.addShape(song1_3);

        int song1_4Width = 0;
        switch (str)
        {
            case "hobby":
            {
                song1_4Width = hobbiesLiked[3] * MULTIPLIER;
                break;
            }
            case "major":
            {
                song1_4Width = majorsLiked[3] * MULTIPLIER;
                break;
            }
            case "region":
            {
                song1_4Width = regionsLiked[3] * MULTIPLIER;
                break;
            }
            default:
            {
                break;
            }
        }

        int song1_4Height = song1BarHeight / 4;
        int song1_4X = song1BarX + song1BarWidth;
        int song1_4Y = song1BarY + song1_1Height * 3;
        song1_4 = new Shape(song1_4X, song1_4Y, song1_4Width, song1_4Height,
            Color.GREEN);
        window.addShape(song1_4);

        ///////////////////
        // HEARD//
        ///////////////////

        int song2_1Width = 0;
        switch (str)
        {
            case "hobby":
            {
                song2_1Width = hobbiesHeard[0] * MULTIPLIER;
                break;
            }
            case "major":
            {
                song2_1Width = majorsHeard[0] * MULTIPLIER;
                break;
            }
            case "region":
            {
                song2_1Width = regionsHeard[0] * MULTIPLIER;
                break;
            }
            default:
            {
                break;
            }
        }

        int song2_1Height = song1BarHeight / 4;
        int song2_1X = song1BarX - song2_1Width;
        int song2_1Y = song1BarY;
        song2_1 = new Shape(song2_1X, song2_1Y, song2_1Width, song2_1Height,
            Color.MAGENTA);
        window.addShape(song2_1);

        int song2_2Width = 0;
        switch (str)
        {
            case "hobby":
            {
                song2_2Width = hobbiesHeard[1] * MULTIPLIER;
                break;
            }
            case "major":
            {
                song2_2Width = majorsHeard[1] * MULTIPLIER;
                break;
            }
            case "region":
            {
                song2_2Width = regionsHeard[1] * MULTIPLIER;
                break;
            }
            default:
            {
                break;
            }
        }

        int song2_2Height = song1BarHeight / 4;
        int song2_2X = song1BarX - song2_2Width;
        int song2_2Y = song1BarY + song1_1Height * 1;
        song2_2 = new Shape(song2_2X, song2_2Y, song2_2Width, song2_2Height,
            Color.BLUE);
        window.addShape(song2_2);

        int song2_3Width = 0;
        switch (str)
        {
            case "hobby":
            {
                song2_3Width = hobbiesHeard[2] * MULTIPLIER;
                break;
            }
            case "major":
            {
                song2_3Width = majorsHeard[2] * MULTIPLIER;
                break;
            }
            case "region":
            {
                song2_3Width = regionsHeard[2] * MULTIPLIER;
                break;
            }
            default:
            {
                break;
            }
        }

        int song2_3Height = song1BarHeight / 4;
        int song2_3X = song1BarX - song2_3Width;
        int song2_3Y = song1BarY + song1_1Height * 2;
        song2_3 = new Shape(song2_3X, song2_3Y, song2_3Width, song2_3Height,
            Color.YELLOW);
        window.addShape(song2_3);

        int song2_4Width = 0;
        switch (str)
        {
            case "hobby":
            {
                song2_4Width = hobbiesHeard[3] * MULTIPLIER;
                break;
            }
            case "major":
            {
                song2_4Width = majorsHeard[3] * MULTIPLIER;
                break;
            }
            case "region":
            {
                song2_4Width = regionsHeard[3] * MULTIPLIER;
                break;
            }
            default:
            {
                break;
            }
        }

        int song2_4Height = song1BarHeight / 4;
        int song2_4X = song1BarX - song2_4Width;
        int song2_4Y = song1BarY + song1_1Height * 3;
        song2_4 = new Shape(song2_4X, song2_4Y, song2_4Width, song2_4Height,
            Color.GREEN);
        window.addShape(song2_4);

        System.out.println(majorsHeard[0] + " : " + majorsLiked[0]);
    }

}
