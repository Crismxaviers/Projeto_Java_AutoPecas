import java.sql.*;
import java.util.*;

public class BD_Conecta
{
   String nome = "valor do bd geral";
   String sal = "0";
   Connection connection;

   public BD_Conecta()
   {
      conectaBD();
   }

   public void conectaBD()
   {

      String url = "jdbc:odbc:BD_Pecas";


      try
      {
         
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      connection = DriverManager.getConnection("jdbc:odbc:" + "DRIVER={Microsoft Access Driver (*.mdb)};"
          + "DBQ=" + "C:/Trabalho de Java/BD_Pecas.mdb", "", "");
      }

      catch (ClassNotFoundException cnfex)
      {
         System.err.println("Falha na carga do driver JDBC/ODBC");
         cnfex.printStackTrace();
         System.exit(1);
      }

      catch (SQLException sqlex )
      {
         System.err.println("BD indisponivel para conexão");
         System.out.println("url = " + url);

         sqlex.printStackTrace();
      }
   } 

   public boolean leBD()
   {
      return true;
   }

   public boolean atualizaBD()
   {
      return true;
   }
}