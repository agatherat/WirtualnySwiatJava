public abstract class Organizm {
    protected int sila;
    protected int inicjatywa;
    protected int pozX;
    protected int pozY;
    protected Swiat swiat;
    protected char symbol;
    protected int wiek;
    protected boolean zyje = true;


    public Organizm(int sila, int inicjatywa, int pozX, int pozY, Swiat swiat, char symbol, int wiek, boolean zyje) {
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.pozX = pozX;
        this.pozY = pozY;
        this.swiat = swiat;
        this.symbol = symbol;
        this.wiek = wiek;
        this.zyje = zyje;
    }

    public abstract void akcja();
    public abstract void kolizja(Organizm a);
    public abstract void rysowanie();
    public  abstract Organizm kopiuj();
//    public abstract boolean czyOdbilAtak(Organizm agresor);
//    public abstract boolean czyUciekl(Organizm agresor);
//    public abstract boolean czyOtrul(Organizm a);
//    public abstract boolean czyWzmocnil(Organizm a);
//    public abstract String serializuj();

    public void setpozX(int X) {
        this.pozX = X;
    }

    public int getpozX() {
        return this.pozX;
    }

    public void setpozY(int Y) {
        this.pozY = Y;
    }

    public int getpozY() {
        return this.pozY;
    }

    public int getInicjatywa() {
        return this.inicjatywa;
    }

    public int getWiek() {
        return this.wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getSila() {
        return this.sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
    }

    public boolean czyWiekWystarczajacy(Organizm a, Organizm b) {
        if (a.getWiek() > 3 && b.getWiek() > 3) {
            return true;
        }
        else return false;
    }

    public String JakiOrganizm() {
        String nazwa;
        switch (symbol) {
            case 'C':
                nazwa = "CZLOWIEK";
                break;
            case 'O':
                nazwa = "OWCA";
                break;
            case 'W':
                nazwa = "WILK";
                break;
            case 'L':
                nazwa = "LIS";
                break;
            case 'A':
                nazwa = "ANTYLOPA";
                break;
            case 'Z':
                nazwa = "ZOLW";
                break;
            case 'T':
                nazwa = "TRAWA";
                break;
            case 'M':
                nazwa = "MLECZ";
                break;
            case 'B':
                nazwa = "BARSZCZ SOSNOWSKIEGO";
                break;
            case 'J':
                nazwa = "WILCZE JAGODY";
                break;
            case 'G':
                nazwa = "GUARANA";
                break;
            default:
                nazwa = "UNKNOWN";
        }

        return nazwa;
    }

    public boolean getZyje() {
        return this.zyje;
    }

    public void setZyje(boolean zyje) {
        this.zyje = zyje;
    }
    public boolean czyOdbilAtak(Organizm agresor) {
        return false;
    }

    public boolean czyUciekl(Organizm agresor) {
        return false;
    }

    public boolean czyOtrul(Organizm a) {
        return false;
    }

    public boolean czyWzmocnil(Organizm a) {
        return false;
    }

    public String serializuj() {
        return this.sila + " " +
                this.inicjatywa + " " +
                this.pozX + " " +
                this.pozY + " " +
                this.symbol + " " +
                this.wiek + " " +
                this.zyje;
    }

}