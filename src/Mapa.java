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
    public int column;
    public static int row;
    private Integer TILE_SIZE = 30;

    public Mapa(Swiat swiat) {
        this.swiat = swiat;


        this.setPreferredSize(new Dimension(swiat.getM().x * TILE_SIZE, swiat.getM().y * TILE_SIZE));
        //this.setBackground(Color.WHITE);
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
                g.setColor(Color.WHITE);
                Font font = new Font(g.getFont().getFontName(), Font.BOLD, 14);
                // 14 to rozmiar czcionki, możesz dostosować go do swoich potrzeb
                // Ustawianie pogrubionej czcionki
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