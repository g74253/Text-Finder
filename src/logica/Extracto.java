package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Extracto {
	public static String extraer(String path, String word) {

    	File file = new File(path);
    	Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		if(((file.getName().substring(file.getName().length() - 5)).equals(".docx"))) {
			scanner = new Scanner(LlamadaDocx.docx_aux(file.getPath()));
		}
		else if(((file.getName().substring(file.getName().length() - 4)).equals(".pdf"))) {
			LectorPDF pdfManager = new LectorPDF();
			pdfManager.setFilePath(file.getPath());
			try {
				scanner = new Scanner(pdfManager.toText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    	String line = scanner.next();
    	String aux = "";
    	while(line.equals(word) == false) {
    		aux = line;
    		line = scanner.next();
    	}
    	String newLine = aux +" <font color=red>"+ line.substring(0) +"</font> "+ scanner.next();
    	return newLine;
   
	}

	public static void main(String[] args) {
		System.out.println(extraer("C:\\Users\\grero\\Desktop\\prueba\\fffffff\\Hello-1.txt","hola"));
	}

}
