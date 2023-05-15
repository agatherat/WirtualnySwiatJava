public class Antylopa extends Zwierze {
    public Antylopa(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(4, 4, pozX, pozY, swiat, 'A', wiek, zyje);
    }

    public Antylopa(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }

   @Override
    public void akcja() {
        Random r = new Random(1,4);
        int randomNumber = r.getRandomNumber();
        switch (randomNumber) {
            case 1:
                // ruch w gore
                if (swiat.czyPoleJestCzesiaMapy(pozX, pozY - 2)) {
                    swiat.przesun(pozX, pozY, pozX, pozY - 2);
                } else {
                    swiat.przesun(pozX, pozY, pozX, pozY + 2);
                }
                break;

            case 2:
                // ruch w dol
                if (swiat.czyPoleJestCzesiaMapy(pozX, pozY + 2)) {
                    swiat.przesun(pozX, pozY, pozX, pozY + 2);
                } else {
                    swiat.przesun(pozX, pozY, pozX, pozY - 2);
                }
                break;

            case 3:
                // ruch w prawo
                if (swiat.czyPoleJestCzesiaMapy(pozX + 2, pozY)) {
                    swiat.przesun(pozX, pozY, pozX + 2, pozY);
                } else {
                    swiat.przesun(pozX, pozY, pozX - 2, pozY);
                }
                break;

            case 4:
                // ruch w lewo
                if (swiat.czyPoleJestCzesiaMapy(pozX - 2, pozY)) {
                    swiat.przesun(pozX, pozY, pozX - 2, pozY);
                } else {
                    swiat.przesun(pozX, pozY, pozX + 2, pozY);
                }
                break;

        }
    }
    @Override
   public boolean czyUciekl(Organizm agresor) {
        Random r = new Random(1,2);
        int ucieczka = r.getRandomNumber();
        if (ucieczka == 1) {
            Random p= new Random(1,4);
            int ruch = p.getRandomNumber();
            // ruch w gore
            if (swiat.czyPustePole(pozX, pozY - 1)) {
                swiat.przesun(pozX, pozY, pozX, pozY - 1);
                return true;
            } //dol
            else if (swiat.czyPustePole(pozX, pozY + 1)) {
                swiat.przesun(pozX, pozY, pozX, pozY + 1);
                return true;
            }//lewo
            else if (swiat.czyPustePole(pozX - 1, pozY)) {
                swiat.przesun(pozX, pozY, pozX - 1, pozY);
                return true;
            }//prawo
            else if (swiat.czyPustePole(pozX + 1, pozY)) {
                swiat.przesun(pozX, pozY, pozX + 1, pozY);
                return true;
            }
            else return false;
        }
        else return false;
    }
    @Override
    public void rysowanie() {
        System.out.print('A');
    }

    @Override
    public Organizm kopiuj() {
        return new Owca(pozX, pozY, swiat, 0, true);
    }
}