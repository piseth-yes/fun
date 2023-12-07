package Projects;

import java.util.Random;
import java.util.Scanner;

public class Proj2_Battleship {
    public static void main(String[] args) {
        int nrows = 4; 
        int ncols = 4;
        char[][] board = new char[nrows][ncols];
        boolean[][] shipLocation = new boolean[nrows][ncols];
        int shipLength = 2; 

        initializeBoard(board);
        placeShipRandomly(board, shipLocation, shipLength);

        int fireCount = 0;
        boolean shipDestroyed = false;

        Scanner scanner = new Scanner(System.in);

        while (!shipDestroyed) {
            displayBoard(board);

            int row = -1, col = -1; 
            boolean validGuess = false;

            while (!validGuess) {
                System.out.print("Enter a guess (row, col): ");
                String guess = scanner.next();

                if (guess.length() != 2) {
                    System.out.println("Invalid input. Please enter a valid guess (e.g., A0, B1).");
                    continue;
                }

                char colChar = guess.charAt(0);
                char rowChar = guess.charAt(1);

                if (Character.isLetter(colChar) && Character.isDigit(rowChar)) {
                    col = Character.toUpperCase(colChar) - 'A';
                    row = Character.getNumericValue(rowChar);
                    
                    if (isValidGuess(row, col, nrows, ncols) && board[row][col] != 'H' && board[row][col] != 'M') {
                        validGuess = true;
                    } else {
                        System.out.println("Invalid guess. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid guess (e.g., A0, B1).");
                }
            }

            if (shipLocation[row][col]) {
                System.out.println("Hit!");
                board[row][col] = 'H';
                fireCount++;
                if (isShipDestroyed(board)) {
                    shipDestroyed = true;
                }
            } else {
                System.out.println("Miss!");
                board[row][col] = 'M';
            }
        }

        displayBoard(board);
        System.out.println("Congratulations! You destroyed the ship in " + fireCount + " tries.");
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void displayBoard(char[][] board) {
        System.out.println("  A B C D");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void placeShipRandomly(char[][] board, boolean[][] shipLocation, int shipLength) {
        Random random = new Random();
        int nrows = board.length;
        int ncols = board[0].length;
        int orientation = random.nextInt(2);

        if (orientation == 0) { 
            int row = random.nextInt(nrows);
            int col = random.nextInt(ncols - shipLength + 1);

            for (int j = col; j < col + shipLength; j++) {
                shipLocation[row][j] = true;
            }
        } else { 
            int row = random.nextInt(nrows - shipLength + 1);
            int col = random.nextInt(ncols);

            for (int i = row; i < row + shipLength; i++) {
                shipLocation[i][col] = true;
            }
        }
    }

    public static boolean isValidGuess(int row, int col, int nrows, int ncols) {
        return row >= 0 && row < nrows && col >= 0 && col < ncols;
    }

    public static boolean isShipDestroyed(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}