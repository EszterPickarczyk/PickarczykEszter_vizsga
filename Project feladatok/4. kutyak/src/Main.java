import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Main {

    public static List<Kutya> kutyak=new ArrayList<>();
    public static int gazdatlanKutyakSzama(){
        int gazdatlanKutyakSzama=0;
        for (Kutya kutya:kutyak) {
            if(kutya.tulajdonos.equals("")){
                gazdatlanKutyakSzama+=1;
            }
        }
        return gazdatlanKutyakSzama;
    }

    public static void main(String[] args) {

        String path="C:\\Users\\Mice\\IdeaProjects\\junior_java_backend_fejleszto-main\\Forrásfájlok\\4_kutyak.csv";
        List<Kutya> kutyak=new ArrayList<>();
       try{
            FileReader fileReader=new FileReader(path);
            BufferedReader bufferedReader=new BufferedReader(fileReader);

            String line=bufferedReader.readLine();

            while ((line=bufferedReader.readLine())!=null){
                String [] elements=line.split(";");
                if (elements.length==4) {
                    Kutya kutya=new Kutya(Integer.parseInt(elements[0]),elements[1],elements[2], elements[3],"");
                    kutyak.add(kutya);
                }
                else {
                    Kutya kutya = new Kutya(Integer.parseInt(elements[0]), elements[1], elements[2], elements[3], elements[4]);
                    kutyak.add(kutya);
                }
            }

        }catch (IOException ioException){
           System.out.println(ioException);
       }
        System.out.println("Gazdátlan/örökbefogadható kutyák száma: "+gazdatlanKutyakSzama());

       String outputPath="C:\\Users\\Mice\\IdeaProjects\\junior_java_backend_fejleszto-main\\Forrásfájlok\\hianyzoIDk.txt";
       Set<Integer> hianyzoIDk=new HashSet<>();
        for (int i = 0; i < kutyak.size()-1; i++) {
            if(kutyak.get(i)!=kutyak.get(i+1)){
                hianyzoIDk.add(kutyak.get(i+1).id);
            }
        }
        try{
            FileWriter fileWriter=new FileWriter(outputPath);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (Integer integer:hianyzoIDk) {
                bufferedWriter.write(integer);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        }catch (IOException ioException){
            System.out.println(ioException);
        }
    }
}