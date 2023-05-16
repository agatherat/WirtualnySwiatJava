import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Wybor extends JPanel {
    public JPanel mainPanel;
    private JButton BARSZCZSOSNOWSKIEGOButton;
    private JButton GUARANAButton;
    private JButton WILCZAJAGODAButton;
    private JButton MLECZButton;
    private JButton TRAWAButton;
    private JButton ANTYLOPAButton;
    private JButton ZOLWButton;
    private JButton LISButton;
    private JButton WILKButton;
    private JButton OWCAButton;
    private int x;
    private int y;
    private Swiat swiat;
    private JDialog parentDialog;

    public Wybor(JDialog parentDialog, Swiat swiat, int x, int y) {
        this.swiat = swiat;

        this.parentDialog = parentDialog;
        setPreferredSize(new Dimension(400, 400));

        if(swiat.getOrganizm(x,y)==null){
            OWCAButton.addActionListener(a -> {
                Owca owca = new Owca(x, y, swiat, -1, true);
                swiat.stworzNowyOrganizm(owca, x, y);
                parentDialog.dispose();
            });

             WILKButton.addActionListener(a->{
                 Wilk wilk= new Wilk(x,y,swiat,-1,true);
                 swiat.stworzNowyOrganizm(wilk,x,y);
                 parentDialog.dispose();
             });

             LISButton.addActionListener(a->{
                 Lis lis= new Lis(x,y,swiat,-1,true);
                 swiat.stworzNowyOrganizm(lis,x,y);
                 parentDialog.dispose();
             });

            ZOLWButton.addActionListener(a->{
                Zolw zolw= new Zolw(x,y,swiat,-1,true);
                swiat.stworzNowyOrganizm(zolw,x,y);
                parentDialog.dispose();
            });

            ANTYLOPAButton.addActionListener(a->{
                Antylopa antylopa=new Antylopa(x,y,swiat,-1,true);
                swiat.stworzNowyOrganizm(antylopa,x,y);
                parentDialog.dispose();
            });

            TRAWAButton.addActionListener(a->{
                Trawa trawa= new Trawa(x,y,swiat,-1,true);
                swiat.stworzNowyOrganizm(trawa,x,y);
                parentDialog.dispose();
            });

            MLECZButton.addActionListener(a->{
                Mlecz mlecz=new Mlecz(x,y,swiat,-1,true);
                swiat.stworzNowyOrganizm(mlecz,x,y);
                parentDialog.dispose();
            });

            GUARANAButton.addActionListener(a->{
               Guarana guarana=new Guarana(x,y,swiat,-1,true);
                swiat.stworzNowyOrganizm(guarana,x,y);
                parentDialog.dispose();
            });

            WILCZAJAGODAButton.addActionListener(a->{
                WilczeJagody jagody= new WilczeJagody(x,y,swiat,-1,true);
                swiat.stworzNowyOrganizm(jagody,x,y);
                parentDialog.dispose();
            });

            BARSZCZSOSNOWSKIEGOButton.addActionListener(a->{
                BarszczSosnowskiego barszcz= new BarszczSosnowskiego(x,y,swiat,-1,true);
                swiat.stworzNowyOrganizm(barszcz,x,y);
                parentDialog.dispose();
            });
    }
    }
}
