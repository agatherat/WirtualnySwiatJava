public class Lis extends Zwierze {
    public Lis(int pozX, int pozY, Swiat swiat, int wiek, boolean zyje) {
        super(3, 7, pozX, pozY, swiat, 'L', wiek, zyje);
    }

    public Lis(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }
    public boolean czyJestSilniejszyOd(int targetX, int targetY) {
        Organizm target = swiat.getOrganizm(targetX, targetY);
        if (target == null) {
            return true;
        } else if (sila >= target.getSila()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void akcja() {
        Random r = new Random(1,4);
        switch (r.getRandomNumber()) {
            case 1:
                //ruch w gore
                if (swiat.czyPoleJestCzesiaMapy(pozX, pozY - 1)) {
                    if (czyJestSilniejszyOd(pozX, pozY - 1)) {
                        swiat.przesun(pozX, pozY, pozX, pozY - 1);
                    }
                } else {
                    if (czyJestSilniejszyOd(pozX, pozY + 1)) {
                        swiat.przesun(pozX, pozY, pozX, pozY + 1);
                    }
                }
                break;

            case 2:
                //ruch w dol
                if (swiat.czyPoleJestCzesiaMapy(pozX, pozY + 1)) {
                    if (czyJestSilniejszyOd(pozX, pozY + 1)) {
                        swiat.przesun(pozX, pozY, pozX, pozY + 1);
                    }
                } else {
                    if (czyJestSilniejszyOd(pozX, pozY - 1)) {
                        swiat.przesun(pozX, pozY, pozX, pozY - 1);
                    }
                }
                break;

            case 3:
                //ruch w prawo
                if (swiat.czyPoleJestCzesiaMapy(pozX + 1, pozY)) {
                    if (czyJestSilniejszyOd(pozX + 1, pozY)) {
                        swiat.przesun(pozX, pozY, pozX + 1, pozY);
                    }
                } else {
                    if (czyJestSilniejszyOd(pozX - 1, pozY)) {
                        swiat.przesun(pozX, pozY, pozX - 1, pozY);
                    }
                }
                break;

            case 4:
                //ruch w lewo
                if (swiat.czyPoleJestCzesiaMapy(pozX - 1, pozY)) {
                    if (czyJestSilniejszyOd(pozX - 1, pozY)) {
                        swiat.przesun(pozX, pozY, pozX - 1, pozY);
                    }
                } else {
                    if (czyJestSilniejszyOd(pozX + 1, pozY)) {
                        swiat.przesun(pozX, pozY, pozX + 1, pozY);
                    }
                }
                break;
        }
    }

    @Override
    public void rysowanie() {
        System.out.print('L');
    }

    @Override
    public Organizm kopiuj() {
        return new Lis(pozX, pozY, swiat, 0, true);
    }
}