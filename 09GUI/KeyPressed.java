import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyPressed extends JFrame implements KeyListener{

  private JTextField textField;
  private Container pane;

  public KeyPressed(){
    this.setTitle("This is A Key Stroke Test");
    this.setSize(500,100);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    addKeyListener(this);
  }


  public static void main(String[] args){
    KeyPressed KeyPressGUI = new KeyPressed();
    KeyPressGUI.setVisible(true);
  }

  public void keyPressed(KeyEvent e){
  }

  public void keyReleased(KeyEvent e){
    System.out.println(e.getKeyChar());
  }

  public void keyTyped(KeyEvent e){

  }





}
