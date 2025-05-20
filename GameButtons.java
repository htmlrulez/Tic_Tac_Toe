import javax.swing.*;



public class GameButtons {

    private static String sign;


    public static JButton generateButton(String sign) {
        return new JButton(sign);
    }

    public static JButton[][] generateAllButtons() {
        JButton[][] allPlayableButtons = new JButton[Main.gameRow][Main.gameColumn];

        for (int row = 0; row < Main.gameRow; row++) {
            for (int column = 0; column < Main.gameColumn; column++) {
                JButton button = generateButton(" ");

                allPlayableButtons[row][column] = button;
            }
        }
        return allPlayableButtons;
    }

    public static void generatePlayableButtonsToGrid(JPanel panel, JButton[][] buttons){
        for (int row = 0; row < Main.gameRow; row++) {
            for (int column = 0; column < Main.gameColumn; column++) {
                JButton button = buttons[row][column];
                ClickListener myListener = new ClickListener(button, row, column);

                button.addActionListener(myListener);
                panel.add(button);
            }
        }
    }
}
