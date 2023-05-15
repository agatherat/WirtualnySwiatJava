import javax.swing.*;

public class Wybor extends JPanel {
    private Swiat swiat;
    private JButton owcaButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    public Wybor(Swiat swiat) {
        this.swiat = swiat;
        //owcaButton.addActionListener(a -> swiat.dodajOrganizm(new Owca()));

        owcaButton.addActionListener(a -> System.out.println("owca"));
    }
}
