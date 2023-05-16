import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

public class Swiat {
    private Wymiary m;
    private Organizm[][] mapa;
    private ArrayList<Organizm> organizmy=null;
    private ArrayList<String> powiadomienia=null;
    private int tura = 1;
    private static final String SCIEZKA = "zapis.txt";

    public Swiat(Wymiary m) {
        this.m = m;
        this.mapa = new Organizm[m.x][m.y];
        for (int i = 0; i < m.x; i++) {
            for (int j = 0; j < m.y; j++) {
                this.mapa[i][j] = null;
            }
        }
        organizmy = new ArrayList<Organizm>();
        powiadomienia= new ArrayList<String>();

        if (m.x * m.y > 500) { //dla bardzo duzej mapy tworze wiecej organizmow
            for (int i = 0; i < 5; i++) {
                organizmy.add(new Owca(0, 0, this, 0, true));
                organizmy.add(new Owca(0, 0, this, 0, true));
                organizmy.add(new Wilk(0, 0, this, 0, true));
                organizmy.add(new Lis(0, 0, this, 0, true));
                organizmy.add(new Zolw(0, 0, this, 0, true));
                organizmy.add(new Antylopa(0, 0, this, 0, true));
                organizmy.add(new Trawa(0, 0, this, 0, true));
                organizmy.add(new Mlecz(0, 0, this, 0, true));
                organizmy.add(new WilczeJagody(0, 0, this, 0, true));
                organizmy.add(new Guarana(0, 0, this, 0, true));
                organizmy.add(new BarszczSosnowskiego(0, 0, this, 0, true));
            }
        }
            for (int i = 0; i < 3; i++) {
                organizmy.add(new Owca(0, 0, this, 0, true));
                organizmy.add(new Wilk(0, 0, this, 0, true));
                organizmy.add(new Lis(0, 0, this, 0, true));
                organizmy.add(new Zolw(0, 0, this, 0, true));
                organizmy.add(new Antylopa(0, 0, this, 0, true));
                organizmy.add(new Trawa(0, 0, this, 0, true));
                organizmy.add(new Mlecz(0, 0, this, 0, true));
                organizmy.add(new WilczeJagody(0, 0, this, 0, true));
                organizmy.add(new Guarana(0, 0, this, 0, true));
                organizmy.add(new BarszczSosnowskiego(0, 0, this, 0, true));
            }

        organizmy.add(new Czlowiek(0, 0, this, 0, true));

        Random x = new Random(0, m.x - 1);
        Random y = new Random(0, m.y - 1);

        for (Organizm organizm : organizmy) {
            int X;
            int Y;
            do {
                X = x.getRandomNumber();
                Y = y.getRandomNumber();
            } while (this.mapa[X][Y] != null);
            this.mapa[X][Y] = organizm;
            organizm.setpozX(X);
            organizm.setpozY(Y);
        }
    }

    public Swiat(Wymiary m, ArrayList<Organizm> organizmy, int tura) {
        this.m = m;
        this.organizmy = organizmy;
        this.tura = tura;
        this.mapa = new Organizm[m.x][m.y];
        powiadomienia= new ArrayList<String>();
        for (int i = 0; i < m.x; i++) {
            for (int j = 0; j < m.y; j++) {
                this.mapa[i][j] = null;
            }
        }

        for (Organizm organizm : organizmy) { //przechodzimy po kazdym organizmie w wektorze
            this.mapa[organizm.getpozX()][organizm.getpozY()] = organizm;
            organizm.setSwiat(this);
        }
    }

    public static boolean isEqual(Koordynaty k1, Koordynaty k2) {
        return k1.x == k2.x && k1.y == k2.y;
    }
    public void dodajPowiadomienie(String powiadomienie) {
        this.powiadomienia.add(powiadomienie);
    }

    public Wymiary getM() {
        return this.m;
    }
    public ArrayList<String> getPowiadomienia() {
        return powiadomienia;
    }

    public Organizm getOrganizm(int x, int y) {
            return this.mapa[x][y];
    }
    public Czlowiek getCzlowiek() {
        for (Organizm organizm : organizmy) {
            if (organizm instanceof Czlowiek) {
                return (Czlowiek) organizm;
            }
        }
        return null;
    }
    public void wykonajTure() {
        uporzadkuj();

        powiadomienia.clear();
        powiadomienia.add("TURA "+tura);
        List<Organizm> tmp = new ArrayList<>(organizmy);
        for (Organizm organizm : tmp) {
            if (organizm != null && organizm.getZyje()&&organizm.wiek>=0) {
                organizm.akcja();

            }
            organizm.setWiek(organizm.getWiek() + 1);
        }

        setTura(getTura() + 1);
    }

    public int getTura() {
        return this.tura;
    }


    public Koordynaty znajdzPustePoleObok(Organizm organizm) {
        int x = organizm.getpozX();
        int y = organizm.getpozY();
        if (czyPoleJestCzesiaMapy(x, y + 1) && czyPustePole(x, y + 1)) {
            return new Koordynaty(x, y + 1);
        }
        if (czyPoleJestCzesiaMapy(x + 1, y) && czyPustePole(x + 1, y)) {
            return new Koordynaty(x + 1, y);
        }
        if (czyPoleJestCzesiaMapy(x - 1, y) && czyPustePole(x - 1, y)) {
            return new Koordynaty(x - 1, y);
        }
        if (czyPoleJestCzesiaMapy(x, y - 1) && czyPustePole(x, y - 1)) {
            return new Koordynaty(x, y - 1);
        }
        return new Koordynaty(-1, -1);
    }

    public void setTura(int tura) {
        this.tura = tura;
    }


    public boolean czyPoleJestCzesiaMapy(int x, int y) {
        if (x < 0 || y < 0 || x >= m.x || y >= m.y)
            return false;
        else
            return true;
    }

    public boolean czyPustePole(int x, int y) {
        if (this.mapa[x][y] == null) return true;
		else return false;
    }

    public void przesun(int x, int y, int newx, int newy) {
        if (czyPustePole(newx, newy)) {
            this.mapa[newx][newy] = mapa[x][y];
            this.mapa[x][y] = null;
            this.mapa[newx][newy].setpozX(newx);
            this.mapa[newx][newy].setpozY(newy);
        }
        else {
            this.mapa[x][y].kolizja(mapa[newx][newy]);
        }
    }

    public void stworzNowyOrganizm(Organizm nowy, int newx, int newy) {
        this.mapa[newx][newy] = nowy;
        nowy.setpozX(newx);
        nowy.setpozY(newy);
        organizmy.add(nowy);
    }

    public void rozprzestrzenianie(Organizm a, int x, int y) {
        if (czyPustePole(x, y)) {
            stworzNowyOrganizm(a, x, y);
            powiadomienia.add("Organizm " + a.JakiOrganizm() + " rozprzestrzenil sie.");

        }
        else return;
    }

    public void rozmnazanie(Organizm rodzic1, Organizm rodzic2) {
        Koordynaty pustePole = znajdzPustePoleObok(rodzic1);

        if (pustePole.x == -1 && pustePole.y == -1) {
            pustePole = znajdzPustePoleObok(rodzic2);
        }
        if (pustePole.x == -1 && pustePole.y == -1) {
            return;
        }

        stworzNowyOrganizm(rodzic1.kopiuj(), pustePole.x, pustePole.y);
        powiadomienia.add("Organizm " + rodzic1.JakiOrganizm() + " rozmnozyl sie.");
    }

    public void zabijOrganizm(Organizm a) {

        this.mapa[a.getpozX()][a.getpozY()] = null;

        for (int i = 0; i < organizmy.size(); i++) {
            if (a == organizmy.get(i)) {
                powiadomienia.add("Organizm " + a.JakiOrganizm() + " umiera.");
                a.setZyje(false);
                organizmy.remove(i);
            }
        }
    }

    public void uporzadkuj() {
        //porzadkowanie wedlug inicjatywy
        for (int i = 0; i < organizmy.size(); i++) {
            for (int j = 0; j < organizmy.size() - 1; j++) {
                if (organizmy.get(i).getInicjatywa() > organizmy.get(j).getInicjatywa()) {
                    Organizm temp = organizmy.get(i);
                    organizmy.set(i, organizmy.get(j));
                    organizmy.set(j, temp);
                } else if (organizmy.get(i).getInicjatywa() == organizmy.get(j).getInicjatywa()) {
                    if (organizmy.get(i).getWiek() > organizmy.get(j).getWiek() || organizmy.get(i).getWiek() == organizmy.get(j).getWiek()) {
                        Organizm temp = organizmy.get(i);
                        organizmy.set(i, organizmy.get(j));
                        organizmy.set(j, temp);
                    }
                }
            }
        }
    }


    public boolean czyStoiZwierze(int x, int y) {
        if (czyPoleJestCzesiaMapy(x, y) && getOrganizm(x, y) != null) {
            Organizm org = getOrganizm(x, y);
            if (org instanceof Zwierze) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void zapisz() {
        try {
            PrintWriter plik = new PrintWriter(SCIEZKA);
            plik.println(tura);
            plik.println(m.x);
            plik.println(m.y);
            plik.println(organizmy.size());
            for (Organizm o : organizmy) {
                plik.println(o.serializuj());
            }
            plik.close();
        } catch (IOException e) {
            System.err.println("Błąd zapisu do pliku!");
        }
    }

    public static Organizm wczytajOrganizm(Scanner plik) {
        int sila;
        int inicjatywa;
        int pozX;
        int pozY;
        char symbol;
        int wiek;
        boolean zyje;
        sila = plik.nextInt();
        inicjatywa = plik.nextInt();
        pozX = plik.nextInt();
        pozY = plik.nextInt();
        symbol = plik.next().charAt(0);
        wiek = plik.nextInt();
        zyje = plik.nextBoolean();

        switch (symbol) {
            case 'O':
                return new Owca(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje);

            case 'C':
                int odliczanieDoUmiejetnosci;
                int stanPoczatkowy;
                boolean czyUmiejetnoscAktywna;
                odliczanieDoUmiejetnosci = plik.nextInt();
                stanPoczatkowy = plik.nextInt();
                czyUmiejetnoscAktywna = plik.nextBoolean();
                return new Czlowiek(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje, odliczanieDoUmiejetnosci, stanPoczatkowy, czyUmiejetnoscAktywna);

            case 'W':
                return new Wilk(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje);

            case 'L':
                return new Lis(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje);

            case 'A':
                return new Antylopa(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje);

            case 'Z':
                int licznik;
                licznik = plik.nextInt();
                return new Zolw(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje, licznik);

            case 'T':
                return new Trawa(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje);

            case 'M':
                return new Mlecz(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje);

            case 'B':
                return new BarszczSosnowskiego(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje);

            case 'J':
                return new WilczeJagody(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje);

            case 'G':
                return new Guarana(sila, inicjatywa, pozX, pozY, null, symbol, wiek, zyje);
        }
        return null;
    }

    public static ArrayList<Organizm> wczytajOrganizmy(Scanner plik) {
        ArrayList<Organizm> org = new ArrayList<>();
        int ileWczytac = plik.nextInt();

        for (int i = 0; i < ileWczytac; i++) {
            Organizm o = wczytajOrganizm(plik);
            org.add(o);
        }

        return org;
    }
    public static Swiat wczytaj() {
        try {
            Scanner plik = new Scanner(new File(SCIEZKA));
            String f;
            Wymiary m = new Wymiary();
            int tura ;
            tura= plik.nextInt();
            m.x = plik.nextInt();
            m.y = plik.nextInt();

            ArrayList<Organizm> organizmy = wczytajOrganizmy(plik);

            for (Organizm organizm : organizmy) {
                System.out.println(organizm.JakiOrganizm());
            }

            Swiat s = new Swiat(m, organizmy, tura);

            plik.close();

            return s;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null; // Handle the error appropriately in your code
        }
    }
}