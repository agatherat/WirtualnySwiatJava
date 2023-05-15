import java.util.*;
public class Zwierze extends Organizm {
    public Zwierze(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        super(sila, inicjatywa, pozX, pozY, swiat, symbol, wiek, zyje);
    }

    @Override
    public void akcja() {
        Random r = new Random(1,4);
        int randomNumber = r.getRandomNumber();
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

    @Override
    public void kolizja(Organizm a) {
        Organizm agresor = this;
        Organizm broniacy = a;

        int x = broniacy.getpozX();
        int y = broniacy.getpozY();

        if (broniacy.czyOtrul(agresor)) {
            swiat.zabijOrganizm(agresor);
        }

        else if (broniacy.czyOdbilAtak(agresor)) {
            return;
        }

        else if (broniacy.czyUciekl(agresor)) {
            swiat.przesun(agresor.getpozX(), agresor.getpozY(), x, y);
        }

        else if (czyWzmocnil(agresor)) {
            agresor.setSila(agresor.getSila() + 3);
        }

        else if (agresor.getSymbol() == broniacy.getSymbol()) {
            if (czyWiekWystarczajacy(agresor, broniacy)) {
                swiat.rozmnazanie(agresor, broniacy);
            }
            else return;
        }

        else if (agresor.getSila() >= broniacy.getSila()) {
            swiat.zabijOrganizm(broniacy);
            swiat.przesun(agresor.getpozX(), agresor.getpozY(), x, y);
            swiat.dodajPowiadomienie("Organizm " + agresor.JakiOrganizm() + " zabil " +broniacy.JakiOrganizm()+".");
        }

        else{ //agresor ma wieksza sile od broniacego
            swiat.zabijOrganizm(agresor);
        }
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