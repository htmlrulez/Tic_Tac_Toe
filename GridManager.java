import javax.swing.*;
import java.util.Arrays;
import java.util.Random;



public class GridManager {

    public static int[][] gameArray;

    public GridManager() {
        gameArray = new int[Main.gameRow][Main.gameColumn];
    }




    public static void fillGameArray() {
        for (int[] number : gameArray) {
            Arrays.fill(number, 0);
        }
    }

    public static void resetGameArray(){
        gameArray = new int[Main.gameRow][Main.gameColumn];
        GridManager.fillGameArray();
    }

    public static void updateXMove(int row, int column) {
        gameArray[row][column] = 1;
    }

    public static boolean playerWins(int playerNumber) {
        boolean gameOver = false;

        for (int i = 0; i < Main.gameRow; i++) {
            boolean xWins = true;

            for (int j = 0; j < Main.gameColumn; j++) {

                if (gameArray[i][j] != playerNumber) {
                    xWins = false;
                    break;
                }
            }
            if (xWins) {
                gameOver = true;
            }
        }

        for (int i = 0; i < Main.gameColumn; i++) {
            boolean xWins = true;

            for (int j = 0; j < Main.gameRow; j++) {
                if (gameArray[j][i] != playerNumber) {
                    xWins = false;
                    break;
                }
            }
            if (xWins) {
                gameOver = true;
            }
        }

        for (int i = 0; i < Main.gameRow; i++) {
            boolean xWins = true;
            int counter = 0;

            for (int j = 0; j < Main.gameColumn; j++) {
                if (gameArray[counter][counter] != playerNumber) {
                    xWins = false;
                    break;
                }
                counter++;
            }
            if (xWins) {
                gameOver = true;
            }
        }

        for (int i = 0; i < Main.gameRow; i++) {
            boolean xWins = true;
            int counter = 0;
            int counter2 = Main.gameRow - 1;

            for (int j = 0; j < Main.gameColumn; j++) {
                if (gameArray[counter][counter2] != playerNumber) {
                    xWins = false;
                    break;
                }
                counter++;
                counter2--;
            }
            if (xWins) {
                gameOver = true;
            }
        }
        return gameOver;
    }

    public static boolean gameIsTie(JButton[][] buttons){
        for (int row = 0; row < Main.gameRow; row++) {
            for (int column = 0; column < Main.gameColumn; column++) {

                if (buttons[row][column].getText().equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] invokeDumbAI() {
        Random randNumber = new Random();
        boolean running = true;

        while (running) {
            int aiRow = randNumber.nextInt(Main.gameRow);
            int aiColumn = randNumber.nextInt(Main.gameColumn);

            if (gameArray[aiRow][aiColumn] == 0) {
                gameArray[aiRow][aiColumn] = 2;

                JButton button = Game.allPlayableButtons[aiRow][aiColumn];
                button.setText("O");
                running = false;
            }
        }
        return gameArray;
    }

}