package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class DataKommunikation {

    public static  void main(String [] arg) throws  Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driveren bliver indlæst");



        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Haj?serverTimezone=UTC","root","Haj1234!");
        System.out.println("Nu er der forbindelse");

        Statement stmt = c.createStatement();

        try {
            stmt.executeUpdate(" drop table PATIENTER");}
        catch (Exception e) {}

        stmt.executeUpdate("create table PATIENTER (CPR INT, FORNAVN VARCHAR(30), EFTERNAVN VARCHAR(45))");//opretter tablen
        System.out.println("Tablen er nu oprettet");

        stmt.executeUpdate("insert into PATIENTER values(1234567890,'Bob','Bobsen')");//tilføjer data til vores tabel


        stmt.executeUpdate("insert into PATIENTER values('0987654321','Ib','Ibsen')");//tilføjer data til vores tabel

        // indsætter data fra variabler
        int cpr = 567890321;
        String fornavn = "Jens";
        String efternavn = "Jensen";

        stmt.executeUpdate(
                "insert into PATIENTER(CPR,FORNAVN,EFTERNAVN) values('"+cpr+"', '"+fornavn+"','"+efternavn+"')");

        // forespørgsler ved søgning
        ResultSet rs = stmt.executeQuery("select CPR, FORNAVN, EFTERNAVN from PATIENTER");
        while (rs.next())
        {
            cpr = rs.getInt("CPR");
            fornavn = rs.getString("FORNAVN");
            efternavn = rs.getString("EFTERNAVN");

            System.out.println(cpr+" "+fornavn+" "+efternavn);
        }
    }

}

