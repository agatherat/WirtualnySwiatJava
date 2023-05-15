
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class ArrowKeyListener implements KeyListener {
    private JFrame frame;

    public ArrowKeyListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            // Handle up arrow key pressed
            System.out.println("Up arrow key pressed");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            // Handle down arrow key pressed
            System.out.println("Down arrow key pressed");
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // Handle left arrow key pressed
            System.out.println("Left arrow key pressed");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // Handle right arrow key pressed
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