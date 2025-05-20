import javax.swing.*;
import java.awt.*;



public class GameUI {

    public static JFrame gameFrame = GameUI.getFrame();
    private static final int gameWidth = 800;
    private static final int gameHeight = 600;


    public static JFrame getFrame() {
        JFrame frame = new JFrame();
        frame.setSize(GameUI.gameWidth, GameUI.gameHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }

    public static JPanel getGamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(Main.gameRow, Main.gameColumn));
        return panel;
    }

    public static void xWinFrame() {
        JFrame winFrame = GameUI.getFrame();
        JButton xWinButton = GameButtons.generateButton("X WINS - Game Over!");
        winFrame.add(xWinButton);
        winFrame.setVisible(true);

        gameEndButtonListener xWinListener = new gameEndButtonListener();
        xWinButton.addActionListener(xWinListener);
    }

    public static void oWinFrame() {
        JFrame winFrame = GameUI.getFrame();
        JButton oWinButton = GameButtons.generateButton("O WINS - Game Over!");
        winFrame.add(oWinButton);
        winFrame.setVisible(true);

        gameEndButtonListener oWinListener = new gameEndButtonListener();
        oWinButton.addActionListener(oWinListener);
    }

    public static void gameIsTie() {
        JFrame tieFrame = GameUI.getFrame();
        JButton tieButton = GameButtons.generateButton("GAME IS TIE - Game Over!");
        tieFrame.add(tieButton);
        tieFrame.setVisible(true);

        gameEndButtonListener tieListener = new gameEndButtonListener();
        tieButton.addActionListener(tieListener);
    }

}