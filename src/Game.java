import java.io.*;
import java.util.*;


public class Game {
    public static void main(String[] args) {
        File text = new File("/Users/aishanim/Desktop/Game-of-Life/small.txt");
        char[][] board = createBoard(text);
        //printBoard(board);
        char[][] board2 = createBoard2(board);
        nextIteration(board, board2, board.length, board[0].length);

    }

    public static char[][] createBoard(File fp) {

        try {
            Scanner sc = new Scanner(fp);
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
            }
            sc.close();
            return board;
        }


        catch(FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static char[][] createBoard2(char[][] input) {
        char[][] newBoard = new char[input.length][input[0].length];
        for(char[] i : newBoard) {
            Arrays.fill(i, '-');
        }
        return newBoard;
    }

    public static void printBoard(char[][] board) {
        for(char[] i : board) {
            for(char j : i) {
                System.out.print(j + " ");
            }
            System.out.println(" ");
        }

    }

    public static char[][] nextIteration(char[][] board, char[][] board2, int rows, int cols) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                doCell(board, board2, i, j);
            }
        }
        return null;
    }

    public static void doCell(char[][] board, char[][] board2, int rowIndex, int colIndex) {
        System.out.print(rowIndex + " " + colIndex + "\n");

        board2[rowIndex][colIndex] = '-'; //if dead in next iteration
        board2[rowIndex][colIndex] = 'X'; //if alive in next iteration

    }
}
