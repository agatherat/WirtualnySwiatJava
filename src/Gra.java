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
    }

    public String WypiszPowiadomienia() {
        List<String> powiadomienia = swiat.getPowiadomienia();
        String text = "";
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

    public void Superumiejetnosc(){
        Wybor w = new Wybor(swiat);
        w.setSize(400, 400);
        PopupFactory pf = PopupFactory.getSharedInstance();
        Point l = SUPERUMIEJETNOSCButton.getLocationOnScreen();
        Popup popup = pf.getPopup(MainForm.frame, w, l.x, l.y);
        popup.show();


       // Czlowiek.umiejetnosc();
    }

}
