/**
Game Of Life
@author Aishani Mohaptra
@author Abishek Siva
*/

import java.io.*;
import java.util.*;


public class Game {
    public static void main(String[] args) {
        File text = new File("/Users/abisheksiva/Desktop/Game-of-Life/test_files/wrap_left_line.txt");
        //File text = new File("/Users/abisheksiva/Desktop/Game-of-Life/test_files/3_line.txt");
        char[][] board = createBoard(text);
        printBoard(board);
        System.out.println();
        char[][] board2 = createBoard2(board);
        //System.out.print(northWest(board, 0 ,0));
        //doCell(board, board2, 5, 4);
        nextIteration(board, board2, board.length, board[0].length);
        printBoard(board2);
        //System.out.println();

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
        //board2[rowIndex][colIndex] = '-'; //if dead in next iteration
        //board2[rowIndex][colIndex] = 'X'; //if alive in next iteration
        //System.out.println();
        int sum = 0;
        sum += north(board, rowIndex, colIndex);
        //System.out.println("north "+ sum);
        sum += northEast(board, rowIndex, colIndex);
        //System.out.println("northeast "+sum);
        sum += east(board, rowIndex, colIndex);
        //System.out.println("east "+sum);
        sum += southEast(board, rowIndex, colIndex);
        //System.out.println("southeast "+sum);
        sum += south(board, rowIndex, colIndex);
        //System.out.println("south "+sum);
        sum += southWest(board, rowIndex, colIndex);
        //System.out.println("southwest "+sum);
        sum += west(board, rowIndex, colIndex);
        //System.out.println("west "+sum);
        sum += northWest(board, rowIndex, colIndex);
        //System.out.println("northwest "+sum);

        //System.out.println(sum);

        if(board[rowIndex][colIndex] == 'X') {
            //everything else dies
            if(sum == 2 | sum == 3) {
                board2[rowIndex][colIndex] = 'X';
            }
        }
        else {
            if(sum == 3) {
                board2[rowIndex][colIndex] = 'X';
            }
        }
    }

    public static int north(char[][] board, int rowIndex, int colIndex) {
        int lastRow = board.length - 1;
        if(rowIndex == 0) {
            if(board[lastRow][colIndex] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            if(board[rowIndex - 1][colIndex] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public static int south(char[][]board, int rowIndex, int colIndex) {
        int lastRow = board.length - 1;
        if(rowIndex == lastRow) {
            if(board[0][colIndex] == 'X') {
                return 1;
            }
            else {
              return 0;
            }
        }
        else {
            if(board[rowIndex + 1][colIndex] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public static int west(char[][] board, int rowIndex, int colIndex) {
        int rightCol = board[0].length - 1;
        if(colIndex == 0) {
            if(board[rowIndex][rightCol] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            if(board[rowIndex][colIndex - 1] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public static int east(char[][] board, int rowIndex, int colIndex) {
        int rightCol = board[0].length - 1;
        if(rightCol == colIndex) {
            if(board[rowIndex][0] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            if(board[rowIndex][colIndex + 1] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public static int northWest(char[][] board, int rowIndex, int colIndex) {
        int lastRow = board.length - 1;
        int lastCol = board[0].length - 1;
        //checks upper left position
        if(rowIndex == 0 & colIndex == 0) {
            if(board[lastRow][lastCol] == 'X') {
                return 1;
            } else {
                return 0;
            }
        }
        else if(rowIndex == 0) {
            if(board[lastRow][colIndex-1] == 'X'){
                return 1;
            }
            else {
                return 0;
            }
        }
        else if(colIndex == 0) {
            if(board[rowIndex-1][lastCol] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
        else if(board[rowIndex - 1][colIndex-1] == 'X') {
            return 1;
        }
        else {
            return 0;
        }
    }


    public static int northEast(char[][] board, int rowIndex, int colIndex) {
        int lastRow = board.length - 1;
        int lastCol = board[0].length - 1;

        if(rowIndex == 0 & colIndex == lastCol) {
            if(board[lastRow][0] == 'X') {
                return 1;
            } else {
                return 0;
            }
        }
        else if(rowIndex == 0) {
            if(board[rowIndex][colIndex + 1] == 'X') {
                return 1;
            } else {
                return 0;
            }
        }
        else if(colIndex == lastCol) {
            if(board[rowIndex - 1][0] == 'X') {
                return 1;
            } else {
                return 0;
            }
        }
        else if(board[rowIndex - 1][colIndex + 1] == 'X') {
            return 1;
        } else {
            return 0;
        }

    }

    public static int southEast(char[][] board, int rowIndex, int colIndex) {
        int lastRow = board.length - 1;
        int lastCol = board[0].length - 1;

        if(rowIndex == lastRow & colIndex == lastCol) {
            if(board[0][0] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
        else if(rowIndex == lastRow) {
            if(board[0][colIndex + 1] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
        else if(colIndex == lastCol) {
            if(board[rowIndex + 1][0] == 'X') {
                return 1;
            }
            else {
                return 0;
            }
        }
        else if(board[rowIndex + 1][colIndex + 1] == 'X') {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int southWest(char[][] board, int rowIndex, int colIndex) {
        int lastRow = board.length - 1;
        int lastCol = board[0].length - 1;

        if(rowIndex == lastRow & colIndex == 0) {
            if(board[0][lastCol] == 'X') {
                return 1;
            } else {
                return 0;
            }
        }
        else if(rowIndex == lastRow) {
            if(board[0][colIndex - 1] == 'X') {
                return 1;
            } else {
                return 0;
            }
        }
        else if(colIndex == 0) {
            if(board[rowIndex + 1][lastCol] == 'X') {
                return 1;
            } else {
                return 0;
            }
        }
        else if(board[rowIndex + 1][colIndex - 1] == 'X') {
            return 1;
        } else {
            return 0;
        }
    }


    }
