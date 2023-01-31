import java.sql.*;

public class JDBC01_Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /* 1 - Ilgili Driver i yüklemek gerekiyor. MySQL kullandigimizi bildiriyoruz
           2 - Driver i Bulamama ihtimaline karsi bizden forName methodu icin ClassNotFoundException
                method signature miza exception olarak firlatmamizi istiyor.

         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 3 - Baglantiyi olusturmak icin username ve passwort girmeliyiz
        // Burada da bu username ile passwortun yanlis olma ihtimaline karsi
        // SQLException firlatmamizi istiyor


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

       // 4 - SQL query leri icin bir statement objesi olusturup, javada SQL sorgularimiz iicn bir alan acacagiz

        Statement st = con.createStatement();

        // 5 - SQL query lerimizi yazip, calistirabiliriz


        ResultSet veri=st.executeQuery("select * from personel");
        // 6 - Sonuclari görmek icin Iteration ile Set icerisindeki elemanlari bir While Döngüsüyle yazdiralim

        while (veri.next()){
            System.out.println(veri.getString(1)+
                                                       " " + veri.getString(2)
                                                           + " "
                                                           + veri.getString(3) + " "
                                                           + veri.getInt(4)
                                                           + " "
                                                           + veri.getString(5));
        }

        con.close();
        st.close();
        veri.close();


    }
}
