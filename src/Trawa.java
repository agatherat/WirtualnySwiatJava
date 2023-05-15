
public class Trawa extends Roslina {

    public Trawa(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(0, 0, pozX, pozY, swiat, 'T', wiek, zyje);
    }

    public Trawa(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }

    @Override
    public void rysowanie() {
        System.out.print("T");
    }

    @Override
    public Roslina kopiuj() {
        return new Trawa(pozX, pozY, swiat, 0, true);
    }
}