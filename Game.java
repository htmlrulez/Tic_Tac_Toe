import javax.swing.*;



public class Game {

    public static JButton[][] allPlayableButtons;


    public static void start() {

        GameUI.gameFrame.dispose();
        GameUI.gameFrame = GameUI.getFrame();

        GridManager.resetGameArray();
        allPlayableButtons = GameButtons.generateAllButtons();

        JPanel gamePanel = GameUI.getGamePanel();
        GameButtons.generatePlayableButtonsToGrid(gamePanel, allPlayableButtons);

        GameUI.gameFrame.add(gamePanel);
        GameUI.gameFrame.setVisible(true);
    }
}
