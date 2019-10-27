package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class SpeciP {
	
	public static void g(String path){
		RandomAccessFile reader = null;
		try {
			reader = new RandomAccessFile(path, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileChannel channel = reader.getChannel();
		ByteBuffer buff = ByteBuffer.allocate(1024);
		try {
			channel.read(buff);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String fileContent = new String(buff.array(), StandardCharsets.UTF_8);
		if (fileContent.contains("world")) {
			String match = "world";

			int index = fileContent.indexOf(match);
			int matchLength = match.length();
			while (index >= 0) {  // indexOf returns -1 if no match found
			    System.out.println(index);
			    index = fileContent.indexOf(match, index + matchLength);
			
			}}
		
		
	
	}
	public static void main(String[] args) {
		g("C:\\Users\\grero\\Desktop\\prueba\\yes.txt");

	}

}
