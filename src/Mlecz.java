
public class Mlecz extends Roslina {

    public Mlecz(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(0, 0, pozX, pozY, swiat, 'M', wiek, zyje);
    }

    public Mlecz(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }
    @Override
    public void akcja() {
    for (int i = 0; i < 3; i++) {
        Random a = new Random(0,50); //roslina ma 5% szansy na rozmnożenie się
        int szansa = a.getRandomNumber();
        if (szansa == 0) {
            boolean ruchMozliwy = false;
            do {
                Random r = new Random(1,4);
                switch (r.getRandomNumber()) {
                    case 1: //gora
                        if (pozY != 0) {
                            ruchMozliwy = true;
                            Roslina nowa = this.kopiuj();
                            swiat.rozprzestrzenianie(nowa, pozX, pozY - 1);
                        }
                        break;
                    case 2: //dol
                        if (pozY != swiat.getM().y - 1) {
                            ruchMozliwy = true;
                            swiat.rozprzestrzenianie(this.kopiuj(), pozX, pozY + 1);
                        }
                        break;
                    case 3: //prawo
                        if (pozX != swiat.getM().x - 1) {
                            ruchMozliwy = true;
                            swiat.rozprzestrzenianie(this.kopiuj(), pozX + 1, pozY);
                        }
                        break;
                    case 4: //lewo
                        if (pozX != 0) {
                            ruchMozliwy = true;
                            swiat.rozprzestrzenianie(this.kopiuj(), pozX - 1, pozY);
                        }
                        break;
                }
            } while (ruchMozliwy != true);
        }
        return;
    }
}
    @Override
    public void rysowanie() {
        System.out.print("M");
    }

    @Override
    public Roslina kopiuj() {
        return new Mlecz(pozX, pozY, swiat, 0, true);
    }
}