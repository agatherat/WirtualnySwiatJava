public class Wilk extends Zwierze {
    public Wilk(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(9, 5, pozX, pozY, swiat, 'W', wiek, zyje);
    }

    public Wilk(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }

    @Override
    public void rysowanie() {
        System.out.print('W');
    }

    @Override
    public Organizm kopiuj() {
        return new Wilk(pozX, pozY, swiat, 0, true);
    }
}