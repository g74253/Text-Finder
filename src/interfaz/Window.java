package interfaz;

import javax.swing.*;
import estructuras.LinkedList;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import interfaz.Ventanita;
import logica.folderlist;
import estructuras.ArbolString;
import logica.LlamadaTXT;
import logica.LamadaPDF;
import logica.LlamadaDocx;

@SuppressWarnings("serial")
public class Window extends JFrame{
	JLabel ex;
	ArbolString tree = new ArbolString();
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
		    		if(((file.getName().substring(file.getName().length() - 4)).equals(".txt"))) {
		    			Path copied = Paths.get("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\src\\base_de_datos\\" + file.getName());
			    	    Path originalPath = Paths.get(file.getPath());
			    	    try {
			    	    	LlamadaTXT.txt(file.getPath(), tree);
							Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			    	    
		    		}else if ((file.getName().substring(file.getName().length() - 4)).equals(".pdf")) {
			    		Path copied = Paths.get("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\src\\base_de_datos\\" + file.getName());
			    	    Path originalPath = Paths.get(file.getPath());
			    	    try {
			    	    	LamadaPDF.pdf(file.getPath(), tree);
							Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			    	    
			    		
			    	}else if ((file.getName().substring(file.getName().length() - 5)).equals(".docx")) {
			    		Path copied = Paths.get("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\src\\base_de_datos\\" + file.getName());
			    	    Path originalPath = Paths.get(file.getPath());
			    	    try {
			    	    	LlamadaDocx.docx(file.getPath(), tree);
							Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			    	    
			    		
			    	}
			    	
			    	else if (file.getName().contains(".") == false) {
			    		LinkedList result = folderlist.listf(file.getPath());
			        	result.insertl();
			        	result.displayList();
			        	for (int i = 0; i < result.size(); i++) {
			        		if(((((File) result.position(i).getData()).getName().substring(((File) result.position(i).getData()).getName().length() - 4)).equals(".txt"))) {
				    			Path copied = Paths.get("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\src\\base_de_datos\\" + ((File) result.position(i).getData()).getName());
					    	    Path originalPath = Paths.get(((File) result.position(i).getData()).getPath());
					    	    try {
					    	    	LlamadaTXT.txt(((File) result.position(i).getData()).getPath(), tree);
									Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
					    	    
				    		}else if ((((File) result.position(i).getData()).getName().substring(((File) result.position(i).getData()).getName().length() - 4)).equals(".pdf")) {
					    		Path copied = Paths.get("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\src\\base_de_datos\\" + ((File) result.position(i).getData()).getName());
					    	    Path originalPath = Paths.get(((File) result.position(i).getData()).getPath());
					    	    try {
					    	    	LamadaPDF.pdf(((File) result.position(i).getData()).getPath(), tree);
									Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
					    	    
					    		
					    	}else if ((((File) result.position(i).getData()).getName().substring(((File) result.position(i).getData()).getName().length() - 5)).equals(".docx")) {
					    		Path copied = Paths.get("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\src\\base_de_datos\\" + ((File) result.position(i).getData()).getName());
					    	    Path originalPath = Paths.get(((File) result.position(i).getData()).getPath());
					    	    try {
					    	    	LlamadaDocx.docx(((File) result.position(i).getData()).getPath(), tree);
									Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
					    	    
					    		
					    	}
			        	}
			    	}
		    	}
		    	texto.setText("");
		    	tree.traversePreOrder();
		    		
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
		    	File file = new File("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\src\\base_de_datos\\" + var);
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
		    		new Ventanita(tree.buscar(texto.getText()), texto.getText());
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
		    	fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    	int returnVal = fc.showOpenDialog(Window.this);
		    	
		    	if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
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
