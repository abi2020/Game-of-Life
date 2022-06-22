import java.io.*;
import java.util.*;


public class Game {
    public static void main(String[] args) {
        System.out.println("your mom");
        File text = new File("/Users/aishanim/Desktop/Game-of-Life/small.txt");

        try {
            Scanner sc = new Scanner(text);
            int rows = Integer.parseInt(sc.nextLine());
            int cols = Integer.parseInt(sc.nextLine());
            char[][] board = new char[rows][cols];

            for(char[] i : board) {
                Arrays.fill(i, '-');
            }

            while(sc.hasNextLine()) {
                String curr = sc.nextLine();
                int currRow = Integer.parseInt(curr.split(" ")[0]) - 1;
                int currCol = Integer.parseInt(curr.split(" ")[1]) - 1;
                board[currRow][currCol] = 'X';
                System.out.println(currRow + " " + currCol);
            }
            sc.close();

            for(char[] i : board) {
                for(char j : i) {
                    System.out.print(j + " ");
                }
                System.out.println(" ");
            }
        }


        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
