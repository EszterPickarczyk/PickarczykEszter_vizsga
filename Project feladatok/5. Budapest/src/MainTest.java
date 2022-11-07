import org.junit.jupiter.api.Assertions;
import java.util.List;

class MainTest {

    @org.junit.jupiter.api.Test
    void varosreszLista() {
        Main.Start();
        List<rekord> expectedList=Main.lekerdezes("where varosresz!=''");
        Main.Stop();
        Assertions.assertEquals(14,expectedList.size(),0);
    }

    @org.junit.jupiter.api.Test
    void kilencedikKeruletiTerek() {
        Main.Start();
        List<String> expectedList=Main.kilencedikKeruletiTerek();
        Main.Stop();
        Assertions.assertEquals(12,expectedList.size(),0);
    }

    @org.junit.jupiter.api.Test
    void torles() {
        Main.Start();
        rekord TesztRekord=new rekord(9999,9999,"Teszt","utca","Teszt varosrész","MDCXI.");
        Main.rekordHozzaAdas(TesztRekord);
        Assertions.assertEquals(1,Main.torles(9999),0);
        Main.Stop();
    }

    @org.junit.jupiter.api.Test
    void utcaNevCsere() {
        Main.Start();
        int kod=Main.utcaNevCsere("503.","5003.");
        List<rekord> expectedList=Main.lekerdezes("where utcanev='5003.'");
        Assertions.assertEquals(1,expectedList.size(),0);
        Main.utcaNevCsere("5003.","503.");
        Main.Stop();

    }

    @org.junit.jupiter.api.Test
    void rekordHozzaAdas() {
        Main.Start();
        rekord TesztRekord=new rekord(9999,9999,"Teszt","utca","Teszt varosrész","MDCXI.");
        Assertions.assertEquals(1,Main.rekordHozzaAdas(TesztRekord),0);
        Main.torles(9999);
        Main.Stop();
    }
}