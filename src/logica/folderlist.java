package logica;

import java.io.File;
import estructuras.LinkedList;

public class folderlist {
    public static LinkedList listf(String directoryName) {
        File directory = new File(directoryName);

        LinkedList f = new LinkedList();
        File[] fList = directory.listFiles();
        for (File file : fList) {
        	if (file.getName().contains(".") == true) {
        		if ((file.isFile()) && ((file.getName().substring(file.getName().length() - 4)).equals(".txt")) || ((file.getName().substring(file.getName().length() - 4)).equals(".pdf")) || ((file.getName().substring(file.getName().length() - 5)).equals(".docx"))) {
        			f.insertFirst(file);
        		}
        	}else if (file.isDirectory()) {
        		f.insertFirst(listf(file.getAbsolutePath()));}
            
        }
        return f;
    } 

}