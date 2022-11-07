import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class joslasTest extends TestCase {

    @Test
    public void milyenEvVarhato() {
        int hozam=Main.milyenHozamVarhato(8,12);
        Assert.assertEquals(96,hozam,0);
    }

    @Test
    public void milyenHozamVarhato1() {
        String milyenEv=Main.milyenEvVarhato(96,8);
        Assert.assertEquals("átlagos",milyenEv);
    }

    @Test
    public void milyenHozamVarhato2() {
        String milyenEv=Main.milyenEvVarhato(96,12);
        Assert.assertEquals("átlag alatti",milyenEv);
    }

    @Test
    public void milyenHozamVarhato3() {
        String milyenEv=Main.milyenEvVarhato(96,6);
        Assert.assertEquals("átlag feletti",milyenEv);
    }
}
