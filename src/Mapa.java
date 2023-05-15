import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
public class Mapa extends JPanel {
    private Swiat swiat;
    private JPanel map;

    private Integer TILE_SIZE = 20;

    public Mapa(Swiat swiat) {
        this.swiat = swiat;
        this.setPreferredSize(new Dimension(swiat.getM().x * TILE_SIZE, swiat.getM().y * TILE_SIZE));
        //this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / swiat.getM().x;
        int height = getHeight() / swiat.getM().y;
        for (int i = 0; i < swiat.getM().x; i++) {
            for (int j = 0; j < swiat.getM().y; j++) {
                if (swiat.getOrganizm(i,j) != null) {
                    if (swiat.getOrganizm(i,j) instanceof Owca) {
                        g.setColor(Color.PINK);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Wilk) {
                        Color customColor = new Color(157, 149, 158);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Lis) {
                        Color customColor = new Color(237, 147, 12);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Antylopa) {
                        Color customColor = new Color(207, 159, 97);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Zolw) {
                        Color customColor = new Color(41, 84, 34);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Trawa) {
                        Color customColor = new Color(41, 235, 9);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Mlecz) {
                        Color customColor = new Color(235, 209, 9);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Guarana) {
                        Color customColor = new Color(204, 69, 85);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof BarszczSosnowskiego) {
                        Color customColor = new Color(31, 24, 17);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof WilczeJagody) {
                        Color customColor = new Color(128, 34, 168);
                        g.setColor(customColor);
                    }

                    if (swiat.getOrganizm(i,j) instanceof Czlowiek) {
                        g.setColor(Color.RED);
                    }

                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * width, j * height, width, height);
                g.setColor(Color.PINK);
                g.drawRect(i * width, j * height, width-1, height-1);
            }
        }
    }

    @Override
    protected void processMouseEvent(java.awt.event.MouseEvent e) {
        super.processMouseEvent(e);

        System.out.println("processing");
        // If the user clicked inside the panel
        if (e.getID() == java.awt.event.MouseEvent.MOUSE_CLICKED) {
            int col = e.getX() / TILE_SIZE;
            int row = e.getY() / TILE_SIZE;

            System.out.println(new Point(col, row));
            // If the user clicked on a valid tile, select it
            if (col >= 0 && col < swiat.getM().y && row >= 0 && row < swiat.getM().x) {
                System.out.println(new Point(col, row));
//                selectedTile = ;
//                repaint();
            }
        }
    }

}