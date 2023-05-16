import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int x, y;
//        Swiat wczytanySwiat = null;
//        System.out.println("WITAJ W MOIM SWIECIE!");
//        System.out.println("ZACZNIJ GRE!!!");
//        System.out.println("n - nowy swiat");
//        System.out.println("w- wczytaj zapisany swiat");
//        char gra = scanner.next().charAt(0);
//
//        if (gra == 'w') {
//            wczytanySwiat = Swiat.wczytaj();
//            while (true) {
//                char wykonaj;
//                System.out.print("\033[H\033[2J"); // clear console
//                System.out.flush();
//                wczytanySwiat.rysujSwiat();
//
//                while (true) {
//                    wykonaj = scanner.next().charAt(0);
//                    if (wykonaj == 't') {
//                        wczytanySwiat.wykonajTure();
//                        continue;
//                    }
//                    if (wykonaj == 'z') {
//                        wczytanySwiat.zapisz();
//                        System.out.println("Zapisano swiat!");
//                    }
//                    return;
//                }
//            }
//        } else if (gra == 'n') {
//            System.out.print("ABY STWORZYC SWIAT PODAJ WYMIARY SWIATA: ");
//            x = scanner.nextInt();
//            y = scanner.nextInt();
//            System.out.println();
//
//            while (x * y < 40) {
//                System.out.print(" UPS! SWIAT JEST ZBYT MALY. PODAJ INNE WYMIARY SWIATA: ");
//                x = scanner.nextInt();
//                y = scanner.nextInt();
//                System.out.println();
//            }
//            System.out.print("\033[H\033[2J"); // clear console
//            System.out.flush()
//       Wymiary m= new Wymiary();
//            m.x=x;
//            m.y=y;
//            Swiat mojSwiat = new Swiat(m);
//            mojSwiat.rysujSwiat();
//
//            while (true) {
//                char wykonaj = scanner.next().charAt(0);
//                if (wykonaj == 't') {
//                    mojSwiat.wykonajTure();
//                    continue;
//                }
//                if (wykonaj == 'z') {
//                    mojSwiat.zapisz();
//                    System.out.println("Zapisano swiat!");
//                }
//            }
//        }
   }
}