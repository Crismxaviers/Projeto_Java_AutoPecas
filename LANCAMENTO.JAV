import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lancamento extends JFrame
{
  String descricao_peca;
  String peso_peca;
  String cor_peca;
  String quant_peca;
  String preco_peca;

  TextField textField0 = new TextField();
  TextField textField1 = new TextField();
  TextField textField2 = new TextField();
  TextField textField3 = new TextField();
  TextField textField4 = new TextField();
  TextField textField5 = new TextField();

  Button button1 = new Button();
  Button button2 = new Button();
  Button button3 = new Button();

  JLabel jLabel0 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();

  BD_Pecas conect = new BD_Pecas();

  public Lancamento()
  {
    try 
    {
      jbInit();
      setSize(500,500);  
      show();
    }
    catch(Exception e) 
    {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    this.getContentPane().setLayout(null);
    this.setTitle("Lancamento");

    textField0.setText("");
    textField0.setBounds(new Rectangle(150, 33, 250, 22));
    textField1.setText("");
    textField1.setBounds(new Rectangle(150, 63, 250, 22));
    textField2.setText("");
    textField2.setBounds(new Rectangle(150, 127, 250, 22));

    button1.setLabel("Adicionar");
    button1.setBounds(new Rectangle(300, 400, 67, 55));
    button2.setLabel("Remover");
    button2.setBounds(new Rectangle(400, 400, 67, 55));
    button3.setLabel("Buscar");
    button3.setBounds(new Rectangle(400, 30, 67, 55));

    jLabel0.setText("Numero");
    jLabel0.setBounds(new Rectangle(50, 33, 68, 20));
    jLabel1.setText("Qtd. Atual");
    jLabel1.setBounds(new Rectangle(50, 63, 68, 20));
    jLabel2.setText("Add ou Rem.");
    jLabel2.setBounds(new Rectangle(50, 127, 68, 20));

    this.getContentPane().add(textField0, null);
    this.getContentPane().add(textField1, null);
    this.getContentPane().add(textField2, null);
    this.getContentPane().add(textField3, null);
    this.getContentPane().add(textField4, null);
    this.getContentPane().add(textField5, null);

    this.getContentPane().add(button1, null);
    this.getContentPane().add(button2, null);
    this.getContentPane().add(button3, null);

    this.getContentPane().add(jLabel0, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jLabel2, null);
    }

   public boolean action(Event evt, Object arg)
   {
      if (evt.target instanceof Button)
      {
         if (arg.equals("Buscar")) {
           String [] resp = conect.leBD(Integer.parseInt(textField0.getText()));
           if (resp != null) {
             descricao_peca = resp[0];
             peso_peca = resp[1];
             cor_peca = resp[2];
             quant_peca = resp[3];
             preco_peca = resp[4];
             textField1.setText(quant_peca);
           }
           else 
             JOptionPane.showMessageDialog(null, "nao achou no bd");
         }

         else if (arg.equals("Adicionar")) {
           String totquant = String.valueOf(Integer.parseInt(quant_peca) + Integer.parseInt(textField2.getText()));
           boolean resp = conect.atualizaBD(Integer.parseInt(textField0.getText()),descricao_peca,peso_peca,cor_peca,totquant,preco_peca);
           if (resp) {
             JOptionPane.showMessageDialog(null, "OK");
             textField0.setText("");
             textField1.setText("");
             textField2.setText("");
           }
           else
             JOptionPane.showMessageDialog(null, "nao achou no bd");
         }
         else if (arg.equals("Remover")) {
           String totquant = String.valueOf(Integer.parseInt(quant_peca) - Integer.parseInt(textField2.getText()));
           boolean resp = conect.atualizaBD(Integer.parseInt(textField0.getText()),descricao_peca,peso_peca,cor_peca,totquant,preco_peca);
           if (resp) {
             JOptionPane.showMessageDialog(null, "OK");
             textField0.setText("");
             textField1.setText("");
             textField2.setText("");
           }
           else
             JOptionPane.showMessageDialog(null, "nao achou no bd");
         }
         return(true);
      }
      return(false);
   }
}