import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
public class Mapa extends JPanel {
    private Swiat swiat;
    private JPanel map;
    private Integer TILE_SIZE = 30;

    public Mapa(Swiat swiat) {
        this.swiat = swiat;
        this.setPreferredSize(new Dimension(swiat.getM().x * TILE_SIZE, swiat.getM().y * TILE_SIZE));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int width = getWidth() / swiat.getM().x;
                int height = getHeight() / swiat.getM().y;
                super.mouseClicked(e);
                int col = e.getX() / width;
                int row = e.getY() / height;

                System.out.println(new Point(col, row));
                PokazDialogWyboruOrganizmu(col,row);
            }
        });
    }
    public  void PokazDialogWyboruOrganizmu(int x, int y) {
        JDialog dialog = new JDialog();
        Wybor w = new Wybor(dialog, swiat, x, y);

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true); // to block input to other windows
        dialog.getContentPane().add(w.mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null); // center on screen
        dialog.setVisible(true);
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
                        Color customColor = new Color(237, 164, 185);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Wilk) {
                        Color customColor = new Color(157, 149, 158);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Lis) {
                        Color customColor = new Color(235, 166, 106);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Antylopa) {
                        Color customColor = new Color(99, 81, 66);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Zolw) {
                        Color customColor = new Color(90, 115, 94);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Trawa) {
                        Color customColor = new Color(84, 153, 95);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Mlecz) {
                        Color customColor = new Color(237, 231, 140);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof Guarana) {
                        Color customColor = new Color(219, 88, 143);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof BarszczSosnowskiego) {
                        Color customColor = new Color(43, 29, 33);
                        g.setColor(customColor);
                    }
                    if (swiat.getOrganizm(i,j) instanceof WilczeJagody) {
                        Color customColor = new Color(175, 119, 201);
                        g.setColor(customColor);
                    }

                    if (swiat.getOrganizm(i,j) instanceof Czlowiek) {
                        Color customColor = new Color(219, 22, 79);
                        g.setColor(customColor);
                    }

                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * width, j * height, width, height);
                g.setColor(Color.WHITE);
                Font font = new Font(g.getFont().getFontName(), Font.BOLD, 14);
                g.setFont(font);

                Organizm o= swiat.getOrganizm(i,j);
                if(o!=null) {
                    g.drawString(String.valueOf(o.getSymbol()), i * width + width / 2, j * height + height / 2);
                }
                g.setColor(Color.PINK);
                g.drawRect(i * width, j * height, width-1, height-1);
            }
        }
    }
}