public class Roslina extends Organizm {

    public Roslina(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }

    @Override
    public void akcja() {
        Random a = new Random(0,50);
        int szansa = a.getRandomNumber();
        if (szansa == 0) {
            boolean ruchMozliwy = false;
            do {
                Random r = new Random(1,4);
                int tmp;
                switch (r.getRandomNumber()) {
                    case 1: // gora
                        if (pozY != 0) {
                            ruchMozliwy = true;
                            Organizm nowa = this.kopiuj();
                            swiat.rozprzestrzenianie(nowa, pozX, pozY - 1);
                        }
                        break;

                    case 2: // dol
                        if (pozY != swiat.getM().y - 1) {
                            ruchMozliwy = true;
                            swiat.rozprzestrzenianie(this.kopiuj(), pozX, pozY + 1);
                        }
                        break;

                    case 3: // prawo
                        if (pozX != swiat.getM().x - 1) {
                            ruchMozliwy = true;
                            swiat.rozprzestrzenianie(this.kopiuj(), pozX + 1, pozY);

                        }
                        break;

                    case 4: // lewo
                        if (pozX != 0) {
                            ruchMozliwy = true;
                            swiat.rozprzestrzenianie(this.kopiuj(), pozX - 1, pozY);
                        }
                        break;
                }

            } while (!ruchMozliwy);
        }
        return;
    }

    @Override
    public void kolizja(Organizm a) {
        // implementation
    }

    @Override
    public void rysowanie() {
        // implementation
    }

    @Override
    public Organizm kopiuj() {
        return null;
    }
}