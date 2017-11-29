import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * Description of the Class
 *
 * @author Krish Chaturvedi
 * @created November 25, 2017
 */
class GridImage{
    /**
     * Description of the Field
     */
    private final static String BLANK = " ";
    private static final int MAXROW = 20;
    private static final int MAXCOL = 20;
    private int myMaxRow;
    private int myMaxCol;
    private String [][] myGrid;

    public GridImage(){
        myGrid = new String [MAXROW + 1][MAXCOL + 1];
        myMaxRow = myGrid.length - 1;
        myMaxCol = myGrid[0].length - 1;
    }

    
     /*
     * Loads the images from digital.txt
     */
    public String[][] loadGrid(){

        int x;
        int y;
        String line = "";
        Scanner in;
        try{
            in = new Scanner(new File("digital.txt"));

            for (int row = 1; row <= 55; row++){
                line = in.nextLine();
                if (row == 1){
                }
                else {
                    String [] fileLine = line.split(" ");
                    x = Integer.parseInt(fileLine[0]);
                    y = Integer.parseInt(fileLine[1]);
                    myGrid[x][y]="@";
                }

            }
        }catch(IOException i){
            System.out.println("Error: " + i.getMessage());
        }
        return myGrid;
    }


    public void printGrid(String[][] maze){
        Scanner console = new Scanner(System.in);

        for (int row = 1; row <= myMaxRow; row++){
            for (int col = 1; col <= myMaxCol; col++){
                System.out.print("" + maze[row][col]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Hit enter to see if there are more solutions.");
        String anything = console.nextLine();
    }
}