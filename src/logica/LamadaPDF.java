package logica;
/*
 * Lee el texto que se encuentra en los archivos PDF.
 * 
 * @author Gretchell y Marco
 */
import java.io.File;
import java.io.IOException;
import estructuras.ArbolString;

public class LamadaPDF  {

   public static void pdf (String rut, ArbolString Principal) {
       
       
       LectorPDF pdfManager = new LectorPDF();
       File file = new File(rut);
       pdfManager.setFilePath(rut);
      
       try{
           String text = pdfManager.toText();
           String[] words = text.split("\\s+");
           
           for (int i = 0; i < words.length; i++) {
                // You may want to check for a non-word character before blindly
               // performing a replacement
               // It may also be necessary to adjust the character class
                words[i] = words[i].replaceAll("[^\\w]", "");
                
           }
           
           //String temp2 = Arrays.toString(words);
           //System.out.println(temp2);
           
           int tope = words.length;
           for(int i = 0; i < tope; i++){
               
               Principal.addNode(words[i], file);
               
           
           }
          
       }
       catch(IOException ex){
          System.out.println(ex.getMessage());
       }
       
      
    }
   
}