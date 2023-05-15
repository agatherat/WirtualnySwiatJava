public class Zolw extends Zwierze {
    private int licznik = 0;

    public Zolw(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(2, 1, pozX, pozY, swiat, 'Z', wiek, zyje);
    }

    public Zolw(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje, int licznik) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }

    @Override
    public void akcja() {
        Random r = new Random(1, 4);
        int randomNumber = r.getRandomNumber();
        licznik++;
        if (licznik == 3) {
            switch (randomNumber) {
                case 1:
                    // ruch w gore
                    if (swiat.czyPoleJestCzesiaMapy(pozX, pozY - 1)) {
                        swiat.przesun(pozX, pozY, pozX, pozY - 1);
                    } else {
                        swiat.przesun(pozX, pozY, pozX, pozY + 1);
                    }
                    break;

                case 2:
                    // ruch w dol
                    if (swiat.czyPoleJestCzesiaMapy(pozX, pozY + 1)) {
                        swiat.przesun(pozX, pozY, pozX, pozY + 1);
                    } else {
                        swiat.przesun(pozX, pozY, pozX, pozY - 1);
                    }
                    break;

                case 3:
                    // ruch w prawo
                    if (swiat.czyPoleJestCzesiaMapy(pozX + 1, pozY)) {
                        swiat.przesun(pozX, pozY, pozX + 1, pozY);
                    } else {
                        swiat.przesun(pozX, pozY, pozX - 1, pozY);
                    }
                    break;

                case 4:
                    // ruch w lewo
                    if (swiat.czyPoleJestCzesiaMapy(pozX - 1, pozY)) {
                        swiat.przesun(pozX, pozY, pozX - 1, pozY);
                    } else {
                        swiat.przesun(pozX, pozY, pozX + 1, pozY);
                    }
                    break;
            }
        }
    }

    @Override
    public boolean czyOdbilAtak(Organizm agresor) {
        if (agresor.getSila() < 5) {
            return true;
        } else return false;
    }

    @Override
    public void rysowanie() {
        System.out.print('Z');
    }

    @Override
    public Organizm kopiuj() {
        return new Zolw(pozX, pozY, swiat, 0, true);
    }

    @Override
    public String serializuj() {
        return this.sila + " " +
                this.inicjatywa + " " +
                this.pozX + " " +
                this.pozY + " " +
                this.symbol + " " +
                this.wiek + " " +
                this.zyje+ " " +
                this.licznik;
    }
}
