import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void jegyGeneratorTest1() {
        int jegy=Main.jegyGenerator(10);
        Assertions.assertEquals(1,jegy);
    }

    @org.junit.jupiter.api.Test
    void jegyGeneratorTest2() {
        int jegy=Main.jegyGenerator(11);
        Assertions.assertEquals(2,jegy);
    }

    @org.junit.jupiter.api.Test
    void jegyGeneratorTest3() {
        int jegy=Main.jegyGenerator(26);
        Assertions.assertEquals(3,jegy);
    }

    @org.junit.jupiter.api.Test
    void jegyGeneratorTest4() {
        int jegy=Main.jegyGenerator(46);
        Assertions.assertEquals(4,jegy);
    }

    @org.junit.jupiter.api.Test
    void jegyGeneratorTest5() {
        int jegy=Main.jegyGenerator(71);
        Assertions.assertEquals(5,jegy);
    }
    @org.junit.jupiter.api.Test
    void diakEvVegiErtekelese() {
        int tesztJegy=5;
        int[] tesztAdat=new int[3];
        tesztAdat[0]=1;tesztAdat[1]=9;tesztAdat[2]=tesztJegy;
        Main.Naplo.add(tesztAdat);
        double evVegiErtekelese=Main.diakEvVegiErtekelese(1);
        Assertions.assertEquals(tesztJegy,evVegiErtekelese,.001);
    }
}