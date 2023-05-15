public class Owca extends Zwierze {
    public Owca(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(4, 4, pozX, pozY, swiat, 'O', wiek, zyje);
    }

    public Owca(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }

    @Override
    public void rysowanie() {
        System.out.print('O');
    }

    @Override
    public Organizm kopiuj() {
        return new Owca(pozX, pozY, swiat, 0, true);
    }
}