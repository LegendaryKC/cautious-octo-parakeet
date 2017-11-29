import java.util.Scanner;
/**
 * Description of the Class
 *
 * @author Krish Chaturvedi
 * @created November 25, 2017
 */
public class PrintObject
{
    public String [][] imageGrid;
    public String x;
    GridImage imagePix;
    int i = 0;
    int k = 0;
    Scanner reader = new Scanner(System.in);  // Reading from System.in
    public void main(){
        imagePix = new GridImage();
        imageGrid = imagePix.loadGrid();
        for (i = 0; i <= 20; i++){
            for (k=0; k <=20; k++){
                if(i == 0){
                    imageGrid[i][k] = Integer.toString(k%10);
                }
                if(k == 0){
                    imageGrid[i][k] = Integer.toString(i);
                }
                if (imageGrid[i][k]== null){
                    imageGrid[i][k] = "-";
                }
            }
        }
        printBoard();
    }

    public void printBoard(){
        for (i = 0; i <= 20; i++){
            for (k=0; k <=20; k++){
                System.out.print(imageGrid[i][k]);
            }
            System.out.println();
        }
        System.out.println("Stop? (y/n)");
        char isdone = reader.next().charAt(0);
        if(isdone == 'y'){
            reader.close();
        }
        else{
            getInput();
        }
    }

    public void getInput(){
        int x = 0;
        int y = 0;
        try{
            System.out.println("Enter x-coordinate: ");
            x = reader.nextInt();
        }catch(Exception e) {
            System.out.println("Please enter a number between 1 - 20");
        }
        try{
            System.out.println("Enter y-coordinate: ");
            y = reader.nextInt();
        } catch(Exception e) {
            System.out.println("Please enter a number between 1 - 20");
        }
        erase(x, y);
        printBoard();
    }

    public void erase(int a, int b){
        try{
            if(imageGrid[a][b] == "@"){
                imageGrid[a][b] = "-";
                erase(a + 1, b);
                erase(a - 1, b);
                erase(a, b + 1);
                erase(a, b - 1);
            }
        }
        catch(ArrayIndexOutOfBoundsException exception){
            System.out.print("");
        }
    }
}
