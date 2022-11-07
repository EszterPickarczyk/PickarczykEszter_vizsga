import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    void feltolt()
    {
        Kutya tesztKutya=new Kutya(1,"Teszt Kutya1","nöstény","123456789012345","");
        Main.kutyak.add(tesztKutya);
        tesztKutya=new Kutya(2,"Teszt Kutya2","hím","123456789012346","Teszt Tulajdonos1");
        Main.kutyak.add(tesztKutya);
        tesztKutya=new Kutya(3,"Teszt Kutya3","hím","123456789012348","Teszt Tulajdonos1");
        Main.kutyak.add(tesztKutya);
    }

    @Test
    void gazdatlanKutyakSzama() {
        feltolt();
        int gksz=Main.gazdatlanKutyakSzama();
        Assertions.assertEquals(1,gksz,0);
    }

}