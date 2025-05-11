import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class main {
    static JFrame myFrame = new JFrame();
    static JPanel myPanel = new JPanel();
    static JFrame winFrame = new JFrame();
    static JButton xWinButton = new JButton("X WINS - \\ Game Over");
    static JButton oWinButton = new JButton("O WINS - \\ Game Over");
    static JButton tieButton = new JButton("GAME IS TIE - \\ Play Again?");

    public static void main(String[] args) {

        startGame();
    }

    private static void startGame() {

        myFrame = new JFrame("Tic Tac Toe");
        myFrame.setSize(800, 600);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 3));
        JButton[] allButtons = new JButton[9];

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton(" ");
            allButtons[i] = button;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (button.getText().equals(" ")) {
                        button.setText("X");

                        if (winCondition(allButtons, "X")) {
                            xWinFrame(winFrame, xWinButton);
                            return;
                        }

                        if (matchIsDraw(allButtons)) {
                            gameIsTieWindow(winFrame, oWinButton);
                            return;
                        }

                        invokeDumbAI(allButtons);

                        if (winCondition(allButtons, "O")) {
                            oWinFrame(winFrame, tieButton);
                            return;
                        }
                    }
                }
            });
            myPanel.add(button);
        }
        myFrame.getContentPane().removeAll();
        myFrame.add(myPanel);
        myFrame.setVisible(true);
    }

    private static void invokeDumbAI(JButton[] listOfButtons) {
        Random randNumber = new Random();
        boolean running = true;

        while (running) {
            int randomIndex = randNumber.nextInt(9);
            JButton selectedButton = listOfButtons[randomIndex];

            if (selectedButton.getText().equals(" ") || selectedButton.getText().isEmpty()) {
                selectedButton.setText("O");
                running = false;
            }
        }
    }

    private static Boolean winCondition(JButton[] lisOfButtons, String playingSymbol) {

        int[][] winPositions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] pos : winPositions) {
            if (lisOfButtons[pos[0]].getText().equals(playingSymbol) &&
                    lisOfButtons[pos[1]].getText().equals(playingSymbol) &&
                    lisOfButtons[pos[2]].getText().equals(playingSymbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean matchIsDraw(JButton[] allButtons){
        for (JButton button : allButtons) {
            if (button.getText().equals(" ")) {
                return false;
            }
        }
        return true;
    }

    private static void xWinFrame(JFrame winFrame, JButton xWinButton) {
        winFrame.setSize(800, 600);
        winFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        winFrame.add(xWinButton);
        winFrame.setVisible(true);

        xWinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.myFrame.dispose();
                main.startGame();
            }
        });
    }

    private static void oWinFrame(JFrame winFrame, JButton oWinButton) {
        winFrame.setSize(800, 600);
        winFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        winFrame.add(oWinButton);
        winFrame.setVisible(true);

        oWinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.myFrame.dispose();
                main.startGame();
            }
        });
    }

    private static void gameIsTieWindow(JFrame winFrame, JButton tieButton) {
        winFrame.setSize(800, 600);
        winFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        winFrame.add(tieButton);
        winFrame.setVisible(true);

        tieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.myFrame.dispose();
                main.startGame();
            }
        });
    }


}


