import org.junit.Assert;

import java.util.Random;
import java.util.Scanner;
public class Main {

    public static String milyenEvVarhato(int hozam, int vetettBuza) {
       String varhatoEv="";
        if(hozam/vetettBuza>12 ){
            varhatoEv="átlag feletti";
        } else if (hozam/vetettBuza<9) {
            varhatoEv="átlag alatti";
        }
        else {varhatoEv="átlagos";}

        return varhatoEv;
    }
    public static int milyenHozamVarhato(int vetettBuza, int random) {
        int hozam=vetettBuza*random;
        return hozam;
    }

   public static void kiIras(String milyenEv){
       System.out.println("A hozam alapján "+milyenEv+ " év várható");
   }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        int vetettBuza=0;
        do {
            System.out.println("Add meg a buza mennyiségét tonnában!");
            vetettBuza=input.nextInt();


        int random = rnd.nextInt(5,16);

        int hozam=milyenHozamVarhato(vetettBuza, random);
        System.out.println("A várható hozam "+hozam+" tonna");

        String milyenEv= milyenEvVarhato(hozam, vetettBuza);
        kiIras(milyenEv);

        }while (input.nextLine().equals(""));
    }
}
