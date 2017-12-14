import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
  //Field Variables for TemperatureWindow
  private Container pane;
  private JTextField textField;
  private JButton convert;
  private JCheckBox fahrenheit;
  private JCheckBox celsius;
    
  //Creates GUI
  public static void main(String[] args){
    TemperatureWindow temp = new TemperatureWindow();
    temp.setVisible(true);
  }
    
  //Constructor for GUI
  public TemperatureWindow(){
    this.setTitle("Temperature Converter");
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    
    convert = new JButton("Convert!!!");
    convert.addActionListener(this);
    
    textField = new JTextField(20);
    fahrenheit = new JCheckBox("Celsius to Fahrenheit");
    celsius = new JCheckBox("Fahrenheit to Celsius");
    
    pane.add(convert);
    pane.add(textField);
    pane.add(fahrenheit);
    pane.add(celsius);
	
  }

  //Does something when action is performed
  public void actionPerformed(ActionEvent event){
    String text = textField.getText();
    double value = 0;
    String returnedValue = "";
    try {
      value = Double.parseDouble(text);

    } catch (NumberFormatException e){
      returnedValue = "Enter a correct number!";
    }

    if (!returnedValue.equals("Enter a correct number!")){

      if (event.getActionCommand().equals("Convert!!!")){
        System.out.println(returnedValue);
        if (fahrenheit.isSelected()){
          returnedValue += "" + CtoF(value) + "F ";
        }
        if (celsius.isSelected()){
          returnedValue += "" + FtoC(value);
        }
      }
    }
    textField.setText(returnedValue);
    

    
  }

  //Static Methods for GUI
  public static double CtoF(double num){
    return num * 1.8 + 32;
  }
  public static double FtoC(double num){
    return (num - 32)/1.8;
  }
}
