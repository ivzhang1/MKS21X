import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    //Field Variables for TemperatureWindow
    private Container pane;
    private JTextField textField;
    private JButton convert;
    
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
	convert = new JButton("Convert!!!");
	convert.addActionListener();

	pane.add(convert);
	
    }

    //Does something when action is performed
    public void actionPerformed(ActionEvent event){
	
    }

    //Static Methods for GUI
    public static double CtoF(double num){
	return num * 1.8 + 32;
    }
    public static double FtoC(double num){
	return (num - 32)/1.8;
    }
}
