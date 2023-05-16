import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Czlowiek extends Zwierze  {
    private int odlicznanieDoUmiejetnosci = 0;
    private int stanPoczatkowy;
    private boolean czyUmiejetnoscAktywna = false;
    private Ruch ruch = Ruch.NONE;
//    private boolean Up=false;
//
//    private boolean Down= false;
//    private boolean Right= false;
//    private boolean Left= false;

//    @Override
//    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            // Handle up arrow key pressed
//            Up=true;
//            System.out.println("Up arrow key pressed");
//        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            Down=true;
//            // Handle down arrow key pressed
//            System.out.println("Down arrow key pressed");
//        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            Left=true;
//            // Handle left arrow key pressed
//            System.out.println("Left arrow key pressed");
//        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            Right=true;
//            // Handle right arrow key pressed
//            System.out.println("Right arrow key pressed");
//        }
//    }

    public Czlowiek(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(5, 4, pozX, pozY, swiat, 'C', wiek, zyje);
        this.odlicznanieDoUmiejetnosci = 0;
        this.stanPoczatkowy = 0;
        this.czyUmiejetnoscAktywna = false;
    }

    public Czlowiek(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje, int odliczanieDoUmiejetnosci, int stanPoczatkowy, boolean czyUmiejetnoscAktywna) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
        this.odlicznanieDoUmiejetnosci = odliczanieDoUmiejetnosci;
        this.stanPoczatkowy = stanPoczatkowy;
        this.czyUmiejetnoscAktywna = czyUmiejetnoscAktywna;
    }
public void setRuch(Ruch x){
        this.ruch=x;
}
    @Override
    public void akcja() {
        if(ruch==Ruch.UP&&swiat.czyPoleJestCzesiaMapy(pozX, pozY - 1)){
            swiat.przesun(pozX, pozY, pozX, pozY - 1);
            ruch=Ruch.NONE;
        }
        else if(ruch==Ruch.DOWN&&swiat.czyPoleJestCzesiaMapy(pozX, pozY + 1)){
            swiat.przesun(pozX, pozY, pozX, pozY + 1);
            ruch=Ruch.NONE;
        }
        else if(ruch==Ruch.LEFT&&swiat.czyPoleJestCzesiaMapy(pozX - 1, pozY)){
            swiat.przesun(pozX, pozY, pozX - 1, pozY);
            ruch=Ruch.NONE;
        }
        else if(ruch==Ruch.RIGHT&&swiat.czyPoleJestCzesiaMapy(pozX + 1, pozY)){
            swiat.przesun(pozX, pozY, pozX + 1, pozY);
            ruch=Ruch.NONE;
        };
//        switch (c) {
//            case KEY_UP:
//                if (swiat.czyPoleJestCzesiaMapy(pozX, pozY - 1)) {
//                    swiat.przesun(pozX, pozY, pozX, pozY - 1);
//                }
//                break;
//            case KEY_DOWN:
//                if (swiat.czyPoleJestCzesiaMapy(pozX, pozY + 1)) {
//                    swiat.przesun(pozX, pozY, pozX, pozY + 1);
//                }
//                break;
//            case KEY_LEFT:
//                if (swiat.czyPoleJestCzesiaMapy(pozX - 1, pozY)) {
//                    swiat.przesun(pozX, pozY, pozX - 1, pozY);
//                }
//                break;
//            case KEY_RIGHT:
//                if (swiat.czyPoleJestCzesiaMapy(pozX + 1, pozY)) {
//                    swiat.przesun(pozX, pozY, pozX + 1, pozY);
//                }
//                break;
//            default:
//                break;
//        }
       // Umiejetnosc();

    }

    public void Umiejetnosc() {
        if (!czyUmiejetnoscAktywna && odlicznanieDoUmiejetnosci < 5) {
            odlicznanieDoUmiejetnosci++;
            stanPoczatkowy = sila;
        }

        magicznyEliksir();
    }
    public void magicznyEliksir() {
            if (odlicznanieDoUmiejetnosci == 5) {
                swiat.dodajPowiadomienie("Superumiejetnosc aktywowana! ");
                czyUmiejetnoscAktywna = true;
                sila = 11;
            } else if (czyUmiejetnoscAktywna == false) {
                swiat.dodajPowiadomienie("Superumiejetnosc nie jest gotowa! ");
            } else if (czyUmiejetnoscAktywna) {
                swiat.dodajPowiadomienie("Do konca super umiejetnosci pozostalo: " + odlicznanieDoUmiejetnosci + ".");
            }

        if (czyUmiejetnoscAktywna == true) {
            if (stanPoczatkowy <= 10) {
                sila--;
                odlicznanieDoUmiejetnosci--;
                if (sila == stanPoczatkowy) {
                    czyUmiejetnoscAktywna = false;
                    odlicznanieDoUmiejetnosci = 0;
                }
            }
         }
 }


    @Override
    public void rysowanie() {
        System.out.print((char)2);
    }

    public void setodliczanie(int licznik) {
        this.odlicznanieDoUmiejetnosci = licznik;
    }

    public void setstan(boolean stan) {
        this.czyUmiejetnoscAktywna = stan;
    }

    public void setPozostalo(int p) {
        this.stanPoczatkowy = p;
    }

    @Override
    public Organizm kopiuj() {
        return new Czlowiek(pozX, pozY, swiat, 0,true);
    }

    @Override
    public String serializuj() {
        return Integer.toString(sila) + ' ' +
                Integer.toString(inicjatywa) + ' ' +
                Integer.toString(pozX) + ' ' +
                Integer.toString(pozY) + ' ' +
                Character.toString(symbol) + ' ' +
                Integer.toString(wiek) + ' ' +
                Boolean.toString(zyje) + ' ' +
                Integer.toString(odlicznanieDoUmiejetnosci) + ' ' +
                Integer.toString(stanPoczatkowy) + ' ' +
                Boolean.toString(czyUmiejetnoscAktywna);
    }
}