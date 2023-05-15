public class Guarana extends Roslina {
    public Guarana(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(0, 0, pozX, pozY, swiat, 'G', wiek, zyje);
    }

    public Guarana(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }

    @Override
    public void rysowanie() {
        System.out.print("G");
    }

    @Override
    public Roslina kopiuj() {
        return new Guarana(pozX, pozY, swiat, 0, true);
    }

    @Override
    public boolean czyWzmocnil(Organizm a) {
        return true;
    }
}