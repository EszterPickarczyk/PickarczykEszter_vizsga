import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.w3c.dom.ranges.RangeException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class konyvtarTest {
    List<konyv> assertKonyv;
    konyvtar Konyvtar=new konyvtar();
    void feltolt(){
        konyv tesztKonyv=new konyv("1234567890","Teszt Cím","Teszt szerző","Teszt nyelv",2022);
        Konyvtar.konyvHozzaAd(tesztKonyv);
        assertKonyv=Konyvtar.getKonyvek();
    }

    @org.junit.jupiter.api.Test
    void getKonyvek() {
        feltolt();
        Assertions.assertEquals("Teszt szerző",assertKonyv.get(0).Szerzo);
    }

    @org.junit.jupiter.api.Test
    void konyvHoazzaAd() {
        feltolt();
        Assertions.assertEquals(1,Konyvtar.getKonyvek().size());
    }

    @org.junit.jupiter.api.Test
    void ISBNperDarab() {
        feltolt();
        Assertions.assertEquals(1,Konyvtar.ISBNperDarab("1234567890"));
    }

    @Test
    void RangeExceptionTest() {
        konyv konyvTest=new konyv();
        Exception exception = assertThrows(RangeException.class, () -> {
            konyvTest.setISBN("1");
        });

        String expectedMessage = "Az ISBN értéke 10 vagy 13 hosszú számsor lehet csak!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}