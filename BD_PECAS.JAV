import java.sql.*;
import java.util.*;

public class BD_Pecas extends BD_Conecta
{
   public BD_Pecas()
   {

   }

   public String[] leBD(int num)
   {
      Statement stmt;
      ResultSet rs;
      try
      {
         String autopecas[] = new String[5];
         String query = "SELECT * FROM autopecas WHERE num_peca = " + num;
         boolean maisRegistros = true;
         stmt = connection.createStatement();
         rs = stmt.executeQuery( query );


         maisRegistros = rs.next();

         if ( ! maisRegistros)
         {

            stmt.close();

            return null;
         }
         else
         {
            autopecas[0] = rs.getString("descricao_peca");
            autopecas[1] = rs.getString("peso_peca");
     	    autopecas[2] = rs.getString("cor_peca");
            autopecas[3] = rs.getString("quant_peca");
            autopecas[4] = rs.getString("preco_peca");
                        
            stmt.close();
     
            return autopecas;
         }
      }

      catch (SQLException sqlex)
      {
         System.out.println("erro sql "+ sqlex);
         sqlex.printStackTrace();
         return null;
      }
   }

   public String leQuant(int num)
   {
      Statement stmt;
      ResultSet rs;
      try
      {
         String autopecas;
         String query = "SELECT quant_peca FROM autopecas WHERE num_peca = " + num;
         boolean maisRegistros = true;
         stmt = connection.createStatement();
         rs = stmt.executeQuery( query );

         maisRegistros = rs.next();

         if ( ! maisRegistros)
         {
            stmt.close();
            return null;
         }
         else
         {
            autopecas = rs.getString("quant_peca");
                        
            stmt.close();
     
            return autopecas;
         }
      }

      catch (SQLException sqlex)
      {
         System.out.println("erro sql "+ sqlex);
         sqlex.printStackTrace();
         return null;
      }
   }

   public boolean atualizaBD(int num, String descricao_peca, String peso_peca, String cor_peca, String quant_peca, String preco_peca)
   {
      try
      {
         Statement stmt = connection.createStatement();
         String query = "UPDATE autopecas SET descricao_peca = " + "\'" + descricao_peca + "\', peso_peca = " + peso_peca + ", cor_peca = " + "\'" + cor_peca + "\', quant_peca = " + quant_peca + ", preco_peca = " + preco_peca + " WHERE num_peca = " + num;
     
         stmt.executeUpdate( query );

         stmt.close();

         return true;

      }

      catch (SQLException sqlex)
      {
         System.out.println("erro sql "+ sqlex);
         sqlex.printStackTrace();
         return false;
      }
   }
}


