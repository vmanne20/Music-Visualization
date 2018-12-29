/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Jason Thomas James Zhang
 * @version <11.13.16>
 */
public class GUIWindow
{
    private SongList<Song> list;

    private GUIGlyph[] glyphArray;

    private Window window;

    private Button prev;

    private Button sortArtist;

    private Button sortTitle;

    private Button sortYear;

    private Button sortGenre;

    private Button next;

    private Button repHobby;

    private Button repMajor;

    private Button repRegion;

    private Button quit;

    private SongList<Song>.SongListIterator songIter;
    
    private String representation;
    
    private int numberGlyphs;
    // previousCall true if next button was last pushed between that and
    // previous and false if previous was last called
    private boolean previousCall;

    public GUIWindow(SongList<Song> paramList)
    {
        window = new Window();
        window.setSize(1000, 600);
        this.list = paramList;

        glyphArray = new GUIGlyph[9];

        songIter = list.iterator();

        // JPanel topPanel = new JPanel(new GridLayout(1,5,10,10));

        representation = "hobby";
        this.generateButtons();
        prev.disable();
        previousCall = true;
        this.generateLegend("hobby");
        this.generateGlyphs(true);

    }

    public void generateGlyphs(boolean next)
    {

        // next means true when moving forward false when moving backwards
        if (next)
        {
            if (!previousCall)
            {
                // moves the iterator to the correct position
                while (numberGlyphs > 0)
                {
                    songIter.next();
                    numberGlyphs--;
                }
            }

            numberGlyphs = 0;
            while (numberGlyphs < 9 && songIter.hasNext())
            {
                // 150, 450, 750
                // 20, 170, 320
                int xPos = 150 + (numberGlyphs % 3) * 300;
                int yPos = 20 + (numberGlyphs / 3) * 150;
                glyphArray[numberGlyphs] = new GUIGlyph(xPos, yPos,
                        songIter.next(), window, representation);
                window.addShape(glyphArray[numberGlyphs]);
                numberGlyphs++;
            }
        }
        else
        {
            if (previousCall)
            {
                // moves the iterator back the number of glyphs on the screen
                while (numberGlyphs > 0)
                {
                    songIter.previous();
                    numberGlyphs--;
                }
            }

            numberGlyphs = 0;
            while (numberGlyphs < 9 && songIter.hasPrevious())
            {
                // 150, 450, 750
                // 20, 170, 320
                int xPos = 750 - (numberGlyphs % 3) * 300;
                int yPos = 320 - (numberGlyphs / 3) * 150;
                glyphArray[numberGlyphs] = new GUIGlyph(xPos, yPos,
                        songIter.previous(), window, representation);
                window.addShape(glyphArray[numberGlyphs]);
                numberGlyphs++;
            }
        }
        previousCall = next;
    }

    public void removeGlyphs() // does not work because other shapes are
    // composite and therefore are not necessarily a part of the array pointer
    // UPDATE: Now works!!!
    {
        for (GUIGlyph g : glyphArray)
        {
            g.removeComponents();
        }
        window.repaint();
    }

    public void generateLegend(String str)
    {
        int legendWidth = (int) (window.getGraphPanelWidth() * 1.25 / 10);
        int legendHeight = window.getGraphPanelHeight() / 2;
        int legendX = window.getGraphPanelWidth() - legendWidth - 10;
        int legendY = window.getGraphPanelHeight() - legendHeight - 10;
        Shape legend = new Shape(legendX, legendY, legendWidth, legendHeight,
                Color.BLACK);
        legend.setBackgroundColor(Color.WHITE);
        window.addShape(legend);

        TextShape title = new TextShape(0, 0, "[default text]", Color.BLACK);
        switch (str)
            {
            case "hobby":
                {
                    title.setText("Hobby Legend");
                    break;
                }
            case "major":
                {
                    title.setText("Major Legend");
                    break;
                }
            case "region":
                {
                    title.setText("Region Legend");
                    break;
                }
            default:
                break;
            }

        int titleX = legend.getX() + (legendWidth - title.getWidth()) / 2;
        int titleY = legendY + title.getHeight() / 2;
        int trueY = titleY;
        title.moveTo(titleX, titleY);
        title.setBackgroundColor(Color.WHITE);
        window.addShape(title);
        window.moveToFront(title);

        TextShape item1 = new TextShape(0, 0, "[default text]", Color.MAGENTA);
        switch (str)
            {
            case "hobby":
                {
                    item1.setText("Read");
                    break;
                }
            case "major":
                {
                    item1.setText("Comp Sci");
                    break;
                }
            case "region":
                {
                    item1.setText("Northeast US");
                    break;
                }
            default:
                break;
            }
        int item1X = legend.getX() + (legendWidth - item1.getWidth()) / 2;
        trueY += title.getHeight();
        int item1Y = trueY;
        item1.moveTo(item1X, item1Y);
        item1.setBackgroundColor(Color.WHITE);
        window.addShape(item1);
        window.moveToFront(item1);

        TextShape item2 = new TextShape(0, 0, "[default text]", Color.BLUE);
        switch (str)
            {
            case "hobby":
                {
                    item2.setText("Art");
                    break;
                }
            case "major":
                {
                    item2.setText("Other Eng");
                    break;
                }
            case "region":
                {
                    item2.setText("Southeast US");
                    break;
                }
            default:
                break;
            }
        int item2X = legend.getX() + (legendWidth - item2.getWidth()) / 2;
        trueY += title.getHeight();
        int item2Y = trueY;
        item2.moveTo(item2X, item2Y);
        item2.setBackgroundColor(Color.WHITE);
        window.addShape(item2);
        window.moveToFront(item2);

        TextShape item3 = new TextShape(0, 0, "[default text]", Color.YELLOW);
        switch (str)
            {
            case "hobby":
                {
                    item3.setText("Sports");
                    break;
                }
            case "major":
                {
                    item3.setText("Math/CMDA");
                    break;
                }
            case "region":
                {
                    item3.setText("the rest of US");
                    break;
                }
            default:
                break;
            }
        int item3X = legend.getX() + (legendWidth - item3.getWidth()) / 2;
        trueY += title.getHeight();
        int item3Y = trueY;
        item3.moveTo(item3X, item3Y);
        item3.setBackgroundColor(Color.WHITE);
        window.addShape(item3);
        window.moveToFront(item3);

        TextShape item4 = new TextShape(0, 0, "[default text]", Color.GREEN);
        switch (str)
            {
            case "hobby":
                {
                    item4.setText("Music");
                    break;
                }
            case "major":
                {
                    item4.setText("Other");
                    break;
                }
            case "region":
                {
                    item4.setText("outside the US");
                    break;
                }
            default:
                break;
            }
        int item4X = legend.getX() + (legendWidth - item4.getWidth()) / 2;
        trueY += title.getHeight();
        int item4Y = trueY;
        item4.moveTo(item4X, item4Y);
        item4.setBackgroundColor(Color.WHITE);
        window.addShape(item4);
        window.moveToFront(item4);

        TextShape songtitle = new TextShape(0, 0, "Song Title", Color.BLACK);
        int stitleX = legend.getX() + (legendWidth - songtitle.getWidth()) / 2;
        int stitleY = legendY + (legendHeight * 6 / 10);
        songtitle.moveTo(stitleX, stitleY);
        songtitle.setBackgroundColor(Color.WHITE);
        window.addShape(songtitle);
        window.moveToFront(songtitle);

        int blackBarWidth = 5;
        int blackBarHeight = legendHeight / 5;
        int blackBarX = legend.getX() + (legendWidth - blackBarWidth) / 2;
        int blackBarY = legendY + (legendHeight * 7 / 10);
        Shape blackBar = new Shape(blackBarX, blackBarY, blackBarWidth,
                blackBarHeight, Color.BLACK);
        window.addShape(blackBar);
        window.moveToFront(blackBar);

        TextShape heard = new TextShape(0, 0, "Heard", Color.BLACK);
        int heardX = blackBarX - heard.getWidth() - 10;
        int heardY = blackBarY + (blackBarHeight / 2 - heard.getHeight() / 2);
        heard.moveTo(heardX, heardY);
        heard.setBackgroundColor(Color.WHITE);
        window.addShape(heard);
        window.moveToFront(heard);

        TextShape likes = new TextShape(0, 0, "Likes", Color.BLACK);
        int likesX = blackBarX + blackBarWidth + 10;
        int likesY = blackBarY + (blackBarHeight / 2 - likes.getHeight() / 2);
        likes.moveTo(likesX, likesY);
        likes.setBackgroundColor(Color.WHITE);
        window.addShape(likes);
        window.moveToFront(likes);
    }

    public void generateButtons()
    {
        prev = new Button("\u2190" + " Prev");
        prev.onClick(this, "clickedPrevious");
        window.addButton(prev, WindowSide.NORTH);

        sortArtist = new Button("Sort by Artist Name");
        sortArtist.onClick(this, "clickedSort");
        window.addButton(sortArtist, WindowSide.NORTH);

        sortTitle = new Button("Sort by Song Title");
        sortTitle.onClick(this, "clickedSort");
        window.addButton(sortTitle, WindowSide.NORTH);

        sortYear = new Button("Sort by Release Year");
        sortYear.onClick(this, "clickedSort");
        window.addButton(sortYear, WindowSide.NORTH);

        sortGenre = new Button("Sort by Genre");
        sortGenre.onClick(this, "clickedSort");
        window.addButton(sortGenre, WindowSide.NORTH);

        next = new Button("Next " + "\u2192");
        next.onClick(this, "clickedNext");
        window.addButton(next, WindowSide.NORTH);

        repHobby = new Button("Represent Hobby");
        repHobby.onClick(this, "clickedRepresent");
        window.addButton(repHobby, WindowSide.SOUTH);

        repMajor = new Button("Represent Major");
        repMajor.onClick(this, "clickedRepresent");
        window.addButton(repMajor, WindowSide.SOUTH);

        repRegion = new Button("Represent Region");
        repRegion.onClick(this, "clickedRepresent");
        window.addButton(repRegion, WindowSide.SOUTH);

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.SOUTH);
    }

    public void clickedPrevious(Button source)
    {
        removeGlyphs();
        generateGlyphs(false);
        next.enable();
        if (!songIter.hasPrevious())
        {
            prev.disable();
        }
    }

    public void clickedNext(Button source)
    {
        removeGlyphs();
        generateGlyphs(true);
        prev.enable();
        if (!songIter.hasNext())
        {
            next.disable();
        }
    }

    public void clickedSort(Button source)
    {
        if (source.getTitle().equals("Sort by Artist Name"))
        {
            if (!songIter.hasNext())
            {// this case list has a null tail node and it's removed
                songIter.previous();
            }
            list.sortByArtist();
            songIter = list.iterator();
            this.removeGlyphs();
            this.generateGlyphs(true);
            prev.disable();
            next.enable();
            window.repaint();
        }
        else if (source.getTitle().equals("Sort by Song Title"))
        {
            if (!songIter.hasNext())
            {// this case list has a null tail node and it's removed
                songIter.previous();
            }
            list.sortByTitle();
            songIter = list.iterator();
            this.removeGlyphs();
            this.generateGlyphs(true);
            prev.disable();
            next.enable();
            window.repaint();
        }
        else if (source.getTitle().equals("Sort by Release Year"))
        {
            if (!songIter.hasNext())
            {// this case list has a null tail node and it's removed
                songIter.previous();
            }
            list.sortByDate();
            songIter = list.iterator();
            this.removeGlyphs();
            this.generateGlyphs(true);
            prev.disable();
            next.enable();
            window.repaint();
        }
        else
        {
            if (!songIter.hasNext())
            {// this case list has a null tail node and it's removed
                songIter.previous();
            }
            list.sortByGenre();
            songIter = list.iterator();
            this.removeGlyphs();
            this.generateGlyphs(true);
            prev.disable();
            next.enable();
            window.repaint();
        }
    }

    public void clickedRepresent(Button source)
    {
        if (source.getTitle().equals("Represent Hobby"))
        {
            representation = "hobby";
            window.removeAllShapes();
            for (int i = 0; i < numberGlyphs; i++)
            {
                glyphArray[i].createComponents(representation);
            }
            generateLegend(representation);
            window.repaint();
        }
        else if (source.getTitle().equals("Represent Major"))
        {
            representation = "major";
            window.removeAllShapes();
            for (int i = 0; i < numberGlyphs; i++)
            {
                glyphArray[i].createComponents(representation);
            }
            generateLegend(representation);
            window.repaint();
        }
        else
        {
            representation = "region";
            window.removeAllShapes();
            for (int i = 0; i < numberGlyphs; i++)
            {
                glyphArray[i].createComponents(representation);
            }
            generateLegend(representation);
            window.repaint();
        }
    }

    public void clickedQuit(Button source)
    {

        System.exit(0);
    }

}
