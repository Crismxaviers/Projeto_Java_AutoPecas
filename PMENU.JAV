/*
 Ci�ncia da Computacao - 6Semestre - Matutino
 
 Grupo: Aline        n.: 01
        Cristina  n.: 04
        Daniel     n.: 05
        Juliana       n.: 10
        Sandra      n.: 12
        Silvana   n.: 13
 */

import java.awt.*;

public class PMenu extends Frame
{
  MenuBar menuBar = new MenuBar();
  Menu menuArquivo = new Menu("Arquivo", true);
  Menu menuSair = new Menu ("Sair", true);

  public PMenu(String titulo)
  {
     super(titulo);
     setMenuBar(menuBar);
     menuBar.add(menuArquivo);
     menuBar.add(menuSair);


     menuArquivo.add("Consulta");
     menuArquivo.add("Alterar");
     menuArquivo.add("Lancamento");
     
     menuSair.add("Sair");
   
  }

  public static void main(String args[])
  {
     PMenu aplicacao = new PMenu("Auto Pexas JACSSD...");
     aplicacao.resize(500,500);
     aplicacao.show();
  }

  public boolean handleEvent(Event evt)
  {
     if (evt.id == Event.WINDOW_DESTROY)      
        System.exit(0);
     return super.handleEvent(evt);         

   }

   public boolean action(Event evt, Object arg)
   {
      if (evt.target instanceof MenuItem)
      {

         if (arg.equals("Consulta"))
         {

            Consultar con = new Consultar();
         }
         else if(arg.equals("Alterar"))
         {
            EntradaDados ed = new EntradaDados();
         }
         else if(arg.equals("Lancamento"))
         {
            Lancamento lan = new Lancamento();
         }
         else if(arg.equals("Sair"))
         {
         	System.exit(0); 
         }
         
         
         
         return(true);
      }
      return(false);
   }
}