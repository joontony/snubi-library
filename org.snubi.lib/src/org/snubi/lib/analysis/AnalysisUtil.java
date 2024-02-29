package org.snubi.lib.analysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AnalysisUtil {
	
	public static void createFile(String newFile, String str) throws Exception {
		Path path = Paths.get(newFile);			
		Files.write(path, str.getBytes());	
	}	
	
	public static String readFile(String file) throws Exception {
		BufferedReader bufferedReader = new BufferedReader( new FileReader(file) );
        String str;
        StringBuilder builder = new StringBuilder();
        while ((str = bufferedReader.readLine()) != null) {
            builder.append(str).append("\n");
        }	
        bufferedReader.close();        
        return builder.toString();
	}	
	public static List<String> readFileArray(String file) throws Exception {
		List<String> list = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader( new FileReader(file) );
        String str;
        while ((str = bufferedReader.readLine()) != null) {            
            list.add(str);
        }	   
        bufferedReader.close();  
        return list;
	}

}
