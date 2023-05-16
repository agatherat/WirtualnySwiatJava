import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Gra {
    private JButton SUPERUMIEJETNOSCButton;
    private JButton TURAButton;
    private JButton ZAPISZButton;
    public JPanel panel2;
    private JLabel powiadomienia;
    private JPanel MAPApole;
    private Swiat swiat;

    public Gra(Swiat swiat) {
        this.swiat=swiat;
        TURAButton.addActionListener(a -> NowaTura());
        ZAPISZButton.addActionListener(a -> ZapiszSwiat());
        SUPERUMIEJETNOSCButton.addActionListener(a -> Superumiejetnosc());

        MAPApole.setLayout(new GridLayout());
//        int multiplyer = 100;
//        MAPApole.setSize(swiat.getM().x * multiplyer, swiat.getM().y * multiplyer);
        Mapa mapaPanel = new Mapa(swiat);
        MAPApole.add(mapaPanel);

    }

public void NowaTura() {

    swiat.wykonajTure();

    MAPApole.removeAll();
    // Tworzenie nowego panelu mapaPanel na podstawie zaktualizowanego stanu świata
    Mapa mapaPanel = new Mapa(swiat);
    MAPApole.add(mapaPanel);
    MAPApole.revalidate();
    MAPApole.repaint();

    String text = WypiszPowiadomienia();
    powiadomienia.setText(text);
    MainForm.frame.requestFocusInWindow();
    }

    public String WypiszPowiadomienia() {
        List<String> powiadomienia = swiat.getPowiadomienia();
        String text = "<html>";
        if (powiadomienia.size() < 6) {
            for (int i = 0; i < powiadomienia.size(); i++) {
                text += powiadomienia.get(i) + " <br>";
            }
        }
        else {
            for (int i = 0; i < 6; i++) {
                text += powiadomienia.get(i) + " <br>";
            }
        }
        return text;
    }
    public void ZapiszSwiat() {
        swiat.zapisz();
    }

//    public  void PokazDialogWyboruOrganizmu() {
//        JDialog dialog = new JDialog();
//
//        Wybor w = new Wybor(dialog, swiat);
//
//        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        dialog.setModal(true); // to block input to other windows
//        dialog.getContentPane().add(w.mainPanel);
//        dialog.pack();
//        dialog.setLocationRelativeTo(null); // center on screen
//        dialog.setVisible(true);
//    }

    public void Superumiejetnosc() {
        //PokazDialogWyboruOrganizmu();

        //Czlowiek.Umiejetnosc();
    }

}
