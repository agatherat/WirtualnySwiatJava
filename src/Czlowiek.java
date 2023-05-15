import java.util.Scanner;
public class Czlowiek extends Zwierze {
    public static final int KEY_UP = 72;
    public static final int KEY_DOWN = 80;
    public static final int KEY_LEFT = 75;
    public static final int KEY_RIGHT = 77;
    private int odlicznanieDoUmiejetnosci = 0;
    private int stanPoczatkowy;
    private boolean czyUmiejetnoscAktywna = false;

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

//    @Override
//    public void akcja() {
//        System.out.println("Wykonaj swoj ruch!");
//        Scanner scanner = new Scanner(System.in);
//        char c = scanner.next().charAt(0);
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
//
//        Umiejetnosc();
//
//    }
//
//    public void Umiejetnosc() {
//        if (!czyUmiejetnoscAktywna && odlicznanieDoUmiejetnosci < 5) {
//            odlicznanieDoUmiejetnosci++;
//            stanPoczatkowy = sila;
//        }
//
//        magicznyEliksir();
//    }
//    public void magicznyEliksir() {
//            if (odlicznanieDoUmiejetnosci == 5) {
//                swiat.dodajPowiadomienie("Superumiejetnosc aktywowana! ");
//                czyUmiejetnoscAktywna = true;
//                sila = 11;
//            } else if (czyUmiejetnoscAktywna == false) {
//                swiat.dodajPowiadomienie("Superumiejetnosc nie jest gotowa! ");
//            } else if (czyUmiejetnoscAktywna) {
//                swiat.dodajPowiadomienie("Do konca super umiejetnosci pozostalo: " + odlicznanieDoUmiejetnosci + ".");
//            }
//
//        if (czyUmiejetnoscAktywna == true) {
//            if (stanPoczatkowy <= 10) {
//                sila--;
//                odlicznanieDoUmiejetnosci--;
//                if (sila == stanPoczatkowy) {
//                    czyUmiejetnoscAktywna = false;
//                    odlicznanieDoUmiejetnosci = 0;
//                }
//            }
//         }
// }


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