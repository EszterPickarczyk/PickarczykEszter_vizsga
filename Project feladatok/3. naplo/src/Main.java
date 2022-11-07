import java.util.Scanner;
import java.util.*;
import java.text.DecimalFormat;

public class Main {
    public static int jegyGenerator(int random){
        int jegy=0;
     if(random<10){
         jegy=1;
     }
     else if(random>=10 && random<26){
         jegy=2;
        }
     else if(random>=26 && random<46){
         jegy=3;
     }
     else if(random>=46 && random<71){
         jegy=3;
     }
     else jegy=5;
        return jegy;
    }

    public static double diakEvVegiErtekelese(Integer kod){
        double atlag=0;
        return atlag;
    }
    public static Random rnd=new Random();

    public static void main(String[] args) {
        Map<String, Integer> Diakok=new HashMap<>();
        Diakok.put("Edina", 1);
        Diakok.put("Réka", 3);
        Diakok.put("Béla", 4);
        Diakok.put("Zita", 5);
        Diakok.put("Tamás", 6);
        Diakok.put("Géza", 2);

        int random = rnd.nextInt(1,101);
        jegyGenerator(random);

        try {


        }
        catch (NullPointerException e)
        {
            System.out.println("Nincs ilyen nevű diák!");
        }
    }
}