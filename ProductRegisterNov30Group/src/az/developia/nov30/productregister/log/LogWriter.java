package az.developia.nov30.productregister.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
	
	public static final String logFilePath = "resources/log.txt"; 
	
	private static FileOutputStream fos;
 
	public static void createLogFile() {
		File file = new File(logFilePath);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void write(String text) {
		File file = new File(logFilePath);
		if(file.exists()) {
			try {
				fos = new FileOutputStream(file);
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss");
				
				text  = text + " " + formatter.format(LocalDateTime.now());
				
				fos.write(text.getBytes());
				
				
				
				
				
				fos.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else {
			createLogFile();
		}
		
	}
}
