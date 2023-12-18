package MakeMeAlone;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if (DynamicBeat.game == null) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            DynamicBeat.game.pressS();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            DynamicBeat.game.pressD();
        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            DynamicBeat.game.pressF();
        } else if (e.getKeyCode() == KeyEvent.VK_G) {
            DynamicBeat.game.pressG();
        } else if (e.getKeyCode() == KeyEvent.VK_H) {
            DynamicBeat.game.pressH();
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            DynamicBeat.game.pressJ();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (DynamicBeat.game == null) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            DynamicBeat.game.releaseS();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            DynamicBeat.game.releaseD();
        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            DynamicBeat.game.releaseF();
        } else if (e.getKeyCode() == KeyEvent.VK_G) {
            DynamicBeat.game.releaseG();
        } else if (e.getKeyCode() == KeyEvent.VK_H) {
            DynamicBeat.game.releaseH();
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            DynamicBeat.game.releaseJ();
        }
    }
}
