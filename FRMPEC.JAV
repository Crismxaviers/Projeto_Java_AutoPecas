import javax.swing.JOptionPane;

public class Frmpec
{
   public static void main (String args[])
   {
    String numeropecLido = "";
      int numeropec;
      String saida = "";
      boolean volta = true;
      String novodescricao = "",novacor = "", novopeso = "", novaquant = "", novopreco = "";
      String optj;
      int opt;

      optj = JOptionPane.showInputDialog("Entre com a opcao do JACSSD\n1 - Consultar\n2 - Incluir\n3 - Alterar\n4 - Excluir\n5 - Sair");


      opt = Integer.parseInt(optj);
      switch(opt)
      {
         case 1:
            System.out.println("Carregando....");

	    numeropecLido = JOptionPane.showInputDialog("Entre com o numero da peca : ");

            if (numeropecLido.length() > 0)
             {
               numeropec = Integer.parseInt(numeropecLido);
               autopecas pec = new autopecas();
               volta = pec.leautopecas(numeropec);

               if  ( volta )
                {
                  System.out.println("volta da leitura " + volta);
                  saida = "Dados lidos no Banco de Dados\nDescricao = " + pec.descricaopec + "\nPeso = " + pec.peso + "\nCor = " + pec.cor + "\nQuantidade = " + pec.quant + "\nPreco = " + pec.preco;
                  mostrapec(saida);
                }
             else
                {
                  saida = "peca nao existe no BD";
                  mostrapec(saida);
                }
	     }

         case 2:
            System.out.println("INCLUIR DADOS");

         case 3:
            System.out.println("ALTERAR DADOS");

	    numeropecLido = JOptionPane.showInputDialog("Entre com o numero da peca : ");

            if (numeropecLido.length() > 0)
             {
               numeropec = Integer.parseInt(numeropecLido);
               autopecas pec = new autopecas();
               volta = pec.leautopecas(numeropec);
                
	       if  ( volta )
                {
                  System.out.println("volta da leitura " + volta);
                  saida = "Dados lidos no bd\ndescricao = " + pec.descricaopec + "\nPeso = " + pec.peso + "\ncor = " + pec.cor + "\nquant = " + pec.quant + "\npreco = " + pec.preco;
                  mostrapec(saida);
                }
              else
                {
                  saida = "peca n�o existe no BD";
                  mostrapec(saida);
                }
             novodescricao = JOptionPane.showInputDialog("Entre com a nova descricao da peca : " + pec.descricaopec);
             System.out.println("novodescricao " + novodescricao);
             volta = pec.atualizadescricaopec(numeropec, novodescricao);
             
             
            novacor = JOptionPane.showInputDialog("Entre com a nova cor da peca : " + pec.cor);
             System.out.println("novacor " + novacor);
             volta = pec.atualizacor(numeropec, novacor);
             
            }
          else
            {
              JOptionPane.showMessageDialog(null, "numero da peca nao existente", "  Resultado da consulta", JOptionPane.PLAIN_MESSAGE);
            }
 
 
         case 4:
            System.out.println("EXCLUIR DADOS");
         case 5:
            System.out.println("Saindo.....");
         default:
            System.out.println("Numero digitado nao valido");
      }
      System.exit(0);
   }
    private static void mostrapec(String saida )
   {
      JOptionPane.showMessageDialog(
         null, saida, "  Resultado da consulta", JOptionPane.PLAIN_MESSAGE);
   }
  
}
