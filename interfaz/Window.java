package interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import interfaz.Ventanita;

@SuppressWarnings("serial")
public class Window extends JFrame {
	JLabel ex;
	JTextField texto;
	public Window(){
		super("Text Finder");
		
		JButton add = new JButton("Add");  
	    add.setBounds(100,200,100,30);
	    add.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	String var = texto.getText();
		    	File file = new File(var);
		    	if (file.exists()) {
		    		if(((file.getName().substring(file.getName().length() - 4)).equals(".txt")) || ((file.getName().substring(file.getName().length() - 4)).equals(".pdf")) || ((file.getName().substring(file.getName().length() - 5)).equals(".docx"))) {
		    			Path copied = Paths.get("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\base_datos\\" + file.getName());
			    	    Path originalPath = Paths.get(file.getPath());
			    	    try {
							Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			    	    
		    		}
		    	}texto.setText("");
		    		
		    }
		});
	    add(add);
	    
	    JButton delete = new JButton("Delete");  
	    delete.setBounds(300,200,100,30);
	    delete.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	String var = texto.getText();
		    	File file = new File("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\base_datos\\" + var);
		    	if (file.exists()) {
		    		file.delete();
		    	}
		    	texto.setText("");
		    }
		    
		});
	    add(delete);
	    
	    JButton search = new JButton("Search");  
	    search.setBounds(500,200,100,30);
	    search.addActionListener( new ActionListener() 
	    {  
		    public void actionPerformed(ActionEvent e)
		    { 
		    	if ((texto.getText()).equals("") == false) {
		    		new Ventanita(texto.getText());
		    		setVisible(false);
		    		}
		    	else {
		    		System.out.println("Intente de nuevo");
		    	}
		    }
	    	
	    });
	    add(search);
	    
	    JButton browser = new JButton("Browser");  
	    browser.setBounds(630,100,100,30);
	    browser.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	JFileChooser fc = new JFileChooser();
		    	int returnVal = fc.showOpenDialog(Window.this);
		    	
		    	if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            //This is where a real application would open the file.
		            texto.setText(file.getPath());
		        } else {
		        	texto.setText("No se ha elegido archivo.");
		        }
		    }
		});
	    add(browser);
	    
	    texto = new JTextField();
	    texto.setBounds(80,100,550,30);
	    texto.setText("");
	    add(texto);
	    
	    ex = new JLabel();
	    add(ex);
	    
	    setResizable(false);
		setVisible(true);
		setLayout(null);
		setBounds(10, 10, 800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
	    new Window();
	}

}
