package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import estructuras.ArbolString;


public class LlamadaTXT {
    
    public static void txt (String rut, ArbolString Principal) throws IOException{
        
        File Archivo;
        FileReader  Lector = null;
        BufferedReader Bufer;
        try{
            Archivo = new File(rut);
            Lector = new FileReader(Archivo);
            Bufer = new BufferedReader(Lector);
            
            String Linea = Bufer.readLine();
            String[] words = Linea.split("\\s+");
            while(Linea!= null){
                for(int i = 0; i < (Linea.length())-1; i++){
                    
                    words[i] = words[i].replaceAll("[^\\w]", "");
                    //System.out.println(words[i]);
                     Principal.addNode(words[i],Archivo.getName());
                }
            }
            
        }catch(Exception  e){
            System.out.println(e);
        }finally{
            Lector.close();
        }
    }
    
}