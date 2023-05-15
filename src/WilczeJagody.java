public class WilczeJagody extends Roslina {
    public WilczeJagody(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(99, 0, pozX, pozY, swiat, 'J', wiek, zyje);
    }

    public WilczeJagody(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek,zyje);
    }

    @Override
    public void rysowanie() {
        System.out.print("J");
    }

    @Override
    public Roslina kopiuj() {
        return new WilczeJagody(pozX, pozY, swiat, 0, true);
    }

    @Override
    public boolean czyOtrul(Organizm a) {
        return true;
    }
}
