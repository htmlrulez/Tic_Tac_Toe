import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ClickListener implements ActionListener {

    private final int xPlayer = 1;
    private final int oPlayer = 2;
    private final JButton button;
    private final int row;
    private final int column;


    public ClickListener(JButton button, int row, int column) {
        this.button = button;
        this.row = row;
        this.column = column;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.getText().equals(" ")) {
            button.setText("X");
            GridManager.updateXMove(row, column);

            if (GridManager.playerWins(xPlayer)) {
                GameUI.xWinFrame();
                return;
            }

            if (GridManager.gameIsTie(Game.allPlayableButtons)) {
                GameUI.gameIsTie();
                return;
            }

            GridManager.invokeDumbAI();

            if (GridManager.playerWins(oPlayer)) {
                GameUI.oWinFrame();
                return;
            }

            if (GridManager.gameIsTie(Game.allPlayableButtons)) {
                GameUI.gameIsTie();
            }
        }
    }
}
