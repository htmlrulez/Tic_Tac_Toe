import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class gameEndButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GameUI.gameFrame.dispose();
            Game.start();
        }
}

