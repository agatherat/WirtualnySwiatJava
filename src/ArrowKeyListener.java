
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class ArrowKeyListener implements KeyListener {
private Swiat swiat;

    public ArrowKeyListener(Swiat swiat) {
        this.swiat=swiat;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Czlowiek czlowiek = swiat.getCzlowiek();
        if (czlowiek != null) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                czlowiek.setRuch(Ruch.UP);
                System.out.println("Up arrow key pressed");

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                czlowiek.setRuch(Ruch.DOWN);
                System.out.println("Down arrow key pressed");

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                czlowiek.setRuch(Ruch.LEFT);
                System.out.println("Left arrow key pressed");

            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                czlowiek.setRuch(Ruch.RIGHT);
                System.out.println("Right arrow key pressed");
            }
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