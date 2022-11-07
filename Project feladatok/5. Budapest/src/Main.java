import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Statement statement;
    public static Connection connection;
    public static ResultSet resultSet;

    public static int Start()
    {
        String url="jdbc:mysql://localhost:3306/";
        String user="";
        String password="";
        try {
            connection = DriverManager.getConnection(url, user,password);
            statement = connection.createStatement();
            return 1;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static void Stop()
    {
        try {
            connection.close();
        }
        catch (Exception e)
        {

        }
    }
    public static List<rekord> lekerdezes(String parameter)
    {
        List<rekord> adatok=new ArrayList<rekord>();
        String sqlCommand=" ";
        try {
            resultSet = statement.executeQuery(sqlCommand+parameter);
            while (resultSet.next()) {
                rekord egyRekord = new rekord();
                egyRekord.ID = Integer.parseInt(resultSet.getString("ID"));
                egyRekord.irszam = Integer.parseInt(resultSet.getString("irszam"));
                egyRekord.utcanev = resultSet.getString("utcanev");
                egyRekord.utotag = resultSet.getString("utotag");
                egyRekord.varosresz = resultSet.getString("varosresz");
                egyRekord.ker = resultSet.getString("ker");
                adatok.add(egyRekord);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return  adatok;
    }

    public static List<String > kilencedikKeruletiTerek()
    {
        List<String> adatok=new ArrayList<String>();
        try {
            String sqlCommand="";
            resultSet = statement.executeQuery(sqlCommand);
            while (resultSet.next()) {
                adatok.add(resultSet.getString("utcanev"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return adatok;
    }
    public static int torles(int ID)
    {
        String sqlCommand = "";
        try {
            return statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            return -1;
        }
    }

    public static int utcaNevCsere(String regiNev,String ujNev)
    {
        String command="";
        String sqlCommand =command+" budapest SET utcanev = REPLACE(utcanev, '"+regiNev+"','"+ujNev+"')";
        try {
            statement.executeUpdate(sqlCommand);
            return 0;
        } catch (SQLException e) {
            return -1;
        }
    }

    public static int rekordHozzaAdas(rekord Rekord)
    {
        try {
            String sqlCommand ="";
            PreparedStatement stmt = connection.prepareStatement(sqlCommand);
            stmt.setInt(1,Rekord.ID);
            stmt.setInt(2, Rekord.irszam);
            stmt.setString(3, Rekord.utcanev);
            stmt.setString(4, Rekord.utotag);
            stmt.setString(5, Rekord.varosresz);
            stmt.setString(6, Rekord.ker);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            return -1;
        }
    }

    public static void main(String[] args)
    {
        if (Start()==1) {
            System.out.println("6. feladat:");
            String parameter="";
            List<rekord> varosReszLista = lekerdezes(parameter);

            System.out.println("7. feladat:");
            List<String> adatok = kilencedikKeruletiTerek();
            for (String utcanev : adatok) {
                System.out.println(utcanev + " tér");
            }
            System.out.println("8. feladat:");
            Scanner input = new Scanner(System.in);
            System.out.print("Melyik azonosítót töröljem? ");
            int bekertID = input.nextInt();
            if (torles(bekertID) > 0) {
                System.out.println("Töröltem.");
            } else {
                System.out.println("Nem történt törlés");
            }
            System.out.println("9. feladat:");
            System.out.print("Utca régi neve: ");
            String regiNev = input.next();
            System.out.print("Utca új neve: ");
            String ujNev = input.next();
            if(utcaNevCsere(regiNev, ujNev)==0)
            {
                System.out.println("Sikeres csere.");
            }
            else
            {
                System.out.println(("A csere sikertelen."));
            }
            System.out.println("10. feladat:");
            rekord egyRekord = new rekord(1, 1091, "Gombaváry", "utca", "", "IX.");
            if (rekordHozzaAdas(egyRekord) == 1) {
                System.out.println("1 rekord hozzáadása sikeresen megtörtént.");
            } else {
                System.out.println("Rekord hozzáadása sikertelen.");
            }
            Stop();
        }
        else
        {
            System.out.println("Az adatbázis nem elérhető!");
        }
    }
}