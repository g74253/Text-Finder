package logica;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import estructuras.ArbolString;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import java.io.*;

/**
 *
 * @author Gordo_0195
 */
public class LlamadaDocx {

    public static void docx(String rut, ArbolString Principal){
    	
        File Archivo;
        XWPFWordExtractor extractor;
        XWPFDocument document = null;
        String texto_extraido;
        try{
        	  Archivo = new File(rut);
              FileInputStream file = new FileInputStream(Archivo.getPath());
              try {
				document = new XWPFDocument(OPCPackage.open(file));
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
              extractor = new XWPFWordExtractor(document);
              texto_extraido = extractor.getText();
              String text = texto_extraido.toLowerCase();
              String[] words = text.split("\\s+");

              for (int i = 0; i < words.length; i++) {

                   words[i] = words[i].replaceAll("[^\\w]", "");

              }
              for(int i = 0; i < (words.length)-1; i++){

                      words[i] = words[i].replaceAll("[^\\w]", "");
                      //System.out.println(words[i]);
                       Principal.addNode(words[i], Archivo);
              }
          }catch(IOException e){
              System.out.println(e);
          }
    }
}
    