import javax.swing.*;
import java.io.FileNotFoundException;

public class MainForm {
    private JPanel panel1;
    private JButton nowySwiatButton;
    private JButton wczytajSwiatButton;
    private JTextField xField;
    private JTextField yField;
    private JLabel Witaj;
    private JLabel Wybor;

    public static JFrame frame;
    private void stworzNowySwiat() {
        System.out.println(xField.getText());
        System.out.println(yField.getText());

        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        Wymiary wymiary= new Wymiary();
        wymiary.x=x;
        wymiary.y=y;
        Swiat swiat=new Swiat(wymiary);

        Gra gra = new Gra(swiat);
        frame.setContentPane(gra.panel2);
//        frame.addKeyListener(gra);
//        gra.panel2.setFocusable(true);
        frame.pack();

    }
    private void wczytajNowySwiat() {
        Swiat wczytanySwiat = Swiat.wczytaj();
        Gra gra = new Gra(wczytanySwiat);
        frame.setContentPane(gra.panel2);
//        frame.addKeyListener(gra);
//        gra.panel2.setFocusable(true);
        frame.pack();
        //MainForm.frame.requestFocusInWindow();
    }

    private MainForm() {
        nowySwiatButton.addActionListener(a -> stworzNowySwiat());
        wczytajSwiatButton.addActionListener(a-> wczytajNowySwiat());

    }
    public static void main(String[] args) {
        frame = new JFrame("Agnieszka Kulesz 193461");

        frame.setContentPane(new MainForm().panel1);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new ArrowKeyListener());
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.setVisible(true);


    }
}
