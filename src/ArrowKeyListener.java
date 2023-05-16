
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class ArrowKeyListener implements KeyListener {


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Czlowiek.setRuch(Ruch.UP);
            System.out.println("Up arrow key pressed");

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            System.out.println("Down arrow key pressed");

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            System.out.println("Left arrow key pressed");

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            System.out.println("Right arrow key pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Do nothing
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Do nothing
    }

}