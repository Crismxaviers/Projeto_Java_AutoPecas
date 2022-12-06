public class autopecas
{
   String descricaopec;
   String peso;
   String cor;
   String quant;
   String preco;
 	

   public autopecas()
   {

      this.descricaopec = "";
      this.peso = "0";
      this.cor = "";
      this.quant =  "0";
      this.preco = "0";
   }

   public boolean leautopecas(int num)
   {

      String dadospec[] = {"","0","","0","0"};
      boolean volta = true;

      BD_Pecas pec = new BD_Pecas(); 

      volta = pec.leBD(num, dadospec);
      System.out.println("volta leBD = " + volta);
      if ( volta )
      {

         this.descricaopec = dadospec[0];
         this.peso = dadospec[1];
         this.cor = dadospec[2];
         this.quant = dadospec[3];
         this.preco = dadospec[4];
        
         return true;
      }
      else
      {
         return false;
      }
   }

   public boolean atualizadescricaopec(int num, String descricao)
   {
      boolean volta = true;

      BD_Pecas pec = new BD_Pecas(); 

      volta = pec.atualizaBD(num, descricao);

      if ( volta )
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
    public boolean atualizacor(int num, String cor)
   {
      boolean volta = true;

      BD_Pecas pec = new BD_Pecas(); 

      volta = pec.atualizaBD(num, cor);

      if ( volta )
      {
         return true;
      }
      else
      {
         return false;
      }
   }   
}