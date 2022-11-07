import java.util.ArrayList;
import java.util.List;

public class konyvtar implements IKonyvekSzama{

   private List<konyv> konyvek=new ArrayList<>();

   public void konyvHozzaAd(konyv konyv){
       konyvek.add(konyv);
   }

    public List<konyv> getKonyvek() {
        return konyvek;
    }

    @Override
    public int ISBNperDarab(String ISBNSzam) {
       int konyvekszama=0;
        for (konyv konyv:konyvek) {
            if(konyv.getISBN()==ISBNSzam){
                konyvekszama+=1;
            }
        }
        return konyvekszama;
    }
}
