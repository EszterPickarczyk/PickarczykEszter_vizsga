public class konyv extends Rekord{
    public String Cim;
    public String Szerzo;
    public String Nyelv;
    public int MegjelenesiDatum;

    public konyv(String ISBN, String cim, String szerzo, String nyelv, int megjelenesiDatum) {
        super(ISBN);
        Cim = cim;
        Szerzo = szerzo;
        Nyelv = nyelv;
        MegjelenesiDatum = megjelenesiDatum;
    }

    public konyv() {
    }

}
