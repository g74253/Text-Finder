package interfaz;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import estructuras.LinkedList;

@SuppressWarnings("serial")
public class Ventanita extends JFrame{
	JLabel ex,texto;
	LinkedList lList = new LinkedList();
	JPanel newPanel = new JPanel();
	
	public Ventanita(String n) {
		
		super("Text Finder");
		
		lList.insertFirst("file1");
		lList.insertFirst("file2");
		lList.insertFirst("file3");
		
		texto = new JLabel();
		texto.setBounds(10,10,550,30);
		texto.setText("Ordenar Por:");
		
		
		newPanel.setBackground(Color.CYAN);
		newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
		int fe = lList.size();
		for (int i = 0; i < fe; i++) {
			JLabel var = new JLabel(lList.position(i).getData().toString());
			var.addMouseListener(new MouseAdapter() 
			{
			    public void mouseClicked(MouseEvent e)
			    {
			    	File file = new File("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\base_datos\\"+var.getText()+".txt");
			    	Desktop desktop = Desktop.getDesktop();
			    	if(file.exists())
						try {
							desktop.open(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			    }
			});
			newPanel.add(var);
	    } 
		JScrollPane scrollPane = new JScrollPane(newPanel);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setBounds(10, 60, 380, 480);
	    JPanel contentPane = new JPanel(null);
	    contentPane.setPreferredSize(new Dimension(400, 630));
	    contentPane.add(scrollPane);
		   
		JButton name = new JButton("Nombre");  
		name.setBounds(90,10,100,30);
	    name.addActionListener( new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			    	newPanel.removeAll();
			    	lList.insertFirst("Name");
			    	int fe = lList.size();
					for (int i = 0; i < fe; i++) {
						JLabel var = new JLabel(lList.position(i).getData().toString());
						var.addMouseListener(new MouseAdapter() 
						{
						    public void mouseClicked(MouseEvent e)
						    {
						    	File file = new File("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\base_datos\\"+var.getText()+".txt");
						    	Desktop desktop = Desktop.getDesktop();
						    	if(file.exists())
									try {
										desktop.open(file);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
						    }
						});
						newPanel.add(var);
				    } 
			    	revalidate();
			    	repaint();
			    }
			    
			});
		   
		JButton date = new JButton("Fecha");  
		date.setBounds(190,10,100,30);
		date.addActionListener( new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			    	newPanel.removeAll();
			    	lList.insertFirst("Date");
			    	int fe = lList.size();
					for (int i = 0; i < fe; i++) {
						JLabel var = new JLabel(lList.position(i).getData().toString());
						var.addMouseListener(new MouseAdapter() 
						{
						    public void mouseClicked(MouseEvent e)
						    {
						    	File file = new File("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\base_datos\\"+var.getText()+".txt");
						    	Desktop desktop = Desktop.getDesktop();
						    	if(file.exists())
									try {
										desktop.open(file);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
						    }
						});
						newPanel.add(var);
				    } 
			    	revalidate();
			    	repaint();
			    }
			    
			});
		
		JButton size = new JButton("Tamaño");  
		size.setBounds(290,10,100,30);
		size.addActionListener( new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			    	newPanel.removeAll();
			    	lList.insertFirst("Size");
			    	int fe = lList.size();
					for (int i = 0; i < fe; i++) {
						JLabel var = new JLabel(lList.position(i).getData().toString());
						var.addMouseListener(new MouseAdapter() 
						{
						    public void mouseClicked(MouseEvent e)
						    {
						    	File file = new File("C:\\Users\\grero\\eclipse-workspace\\Text Finder\\base_datos\\"+var.getText()+".txt");
						    	Desktop desktop = Desktop.getDesktop();
						    	if(file.exists())
									try {
										desktop.open(file);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
						    }
						});
						newPanel.add(var);
				    } 
			    	revalidate();
			    	repaint();
			    }
			    
			});
		
		JButton regresar = new JButton("Regresar");  
		regresar.setBounds(290,590,100,30);
		regresar.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	new Window();
		    	setVisible(false);
		    }
		});
				
		
	     
		ex = new JLabel();
		add(ex);

		setResizable(false);
		setLayout(null);
		this.setContentPane(contentPane);
		add(texto);
		add(name);
		add(date);
		add(size);
		add(regresar);
		
		
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
		
	}
}
