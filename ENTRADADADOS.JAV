import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EntradaDados extends JFrame
{
  TextField textField0 = new TextField();
  TextField textField1 = new TextField();
  TextField textField2 = new TextField();
  TextField textField3 = new TextField();
  TextField textField4 = new TextField();
  TextField textField5 = new TextField();

  Button button1 = new Button();
  Button button2 = new Button();
  
  JLabel jLabel0 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();

  BD_Pecas conect = new BD_Pecas();

  public EntradaDados()
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
  
    this.setTitle("Atualiza??o de Pe?as");

    
    textField0.setText("");
    textField0.setBounds(new Rectangle(150, 33, 250, 22));

    textField1.setText("");
    textField1.setBounds(new Rectangle(150, 63, 250, 22));
    textField2.setText("");
    textField2.setBounds(new Rectangle(150, 95, 250, 22));
    textField3.setText("");
    textField3.setBounds(new Rectangle(150, 127, 250, 22));
    textField4.setText("");
    textField4.setBounds(new Rectangle(150, 159, 250, 22));
    textField5.setText("");
    textField5.setBounds(new Rectangle(150, 191, 250, 22));

    button1.setLabel("Gravar");
    button1.setBounds(new Rectangle(300, 400, 67, 55));
    button2.setLabel("Buscar");
    button2.setBounds(new Rectangle(400, 400, 67, 55));
    
    
    jLabel0.setText("Numero");
    jLabel0.setBounds(new Rectangle(50, 33, 68, 20));
    jLabel1.setText("Descri??o");
    jLabel1.setBounds(new Rectangle(50, 63, 68, 20));
    jLabel2.setText("Peso");
    jLabel2.setBounds(new Rectangle(50, 95, 68, 20));
    jLabel3.setText("Cor");
    jLabel3.setBounds(new Rectangle(50, 127, 68, 20));
    jLabel4.setText("Quantidade");
    jLabel4.setBounds(new Rectangle(50, 159, 68, 20));
    jLabel5.setText("Pre?o");
    jLabel5.setBounds(new Rectangle(50, 191, 68, 20));

    this.getContentPane().add(textField0, null);
    this.getContentPane().add(textField1, null);
    this.getContentPane().add(textField2, null);
    this.getContentPane().add(textField3, null);
    this.getContentPane().add(textField4, null);
    this.getContentPane().add(textField5, null);

    this.getContentPane().add(button1, null);
    this.getContentPane().add(button2, null);
  

    this.getContentPane().add(jLabel0, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(jLabel5, null);
    }


   public boolean action(Event evt, Object arg)
   {
      if (evt.target instanceof Button)
      {
         if (arg.equals("Buscar")) {
           String [] resp = conect.leBD(Integer.parseInt(textField0.getText()));
           if (resp != null) {
             textField1.setText(resp[0]);
             textField2.setText(resp[1]);
             textField3.setText(resp[2]);
             textField4.setText(resp[3]);
             textField5.setText(resp[4]);
           }
           else 
             JOptionPane.showMessageDialog(null, "Cadastro n?o encontrado");
         }
         else if (arg.equals("Gravar")) {
           boolean resp = conect.atualizaBD(Integer.parseInt(textField0.getText()),textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());
           if (resp) {
             JOptionPane.showMessageDialog(null, "Atualiza??o com sucesso");
             textField0.setText("");
             textField1.setText("");
             textField1.setText("");
             textField2.setText("");
             textField3.setText("");
             textField4.setText("");
             textField5.setText("");
           }
           else
             JOptionPane.showMessageDialog(null, "Falha na atualiza??o");
         }
         return(true);
      }
      return(false);
   }
}