/**************************************************************************************** 
 * File Name    : FileUtilCHMRXml
 * Function     : 
 * Author       : mh.choi
 * Tester       : 
 * Page         : 
 * Target       : 
 * Description  : 
 * Modification Log
 * =============================================================== 
 * Ver  Date        Author     Modification
 * ===============================================================
   1.0  2018.06.15  mh.choi     Create
   1.1  2018.06.14  mh.choi     implements FileListInterface -> extends FileUtil
****************************************************************************************/
package org.snubi.lib.file;

import java.io.File;
import java.util.Map;

import org.snubi.lib.date.DateUtil;

public class FileUtilCHMRXml extends FileUtil {
	
	@Override
	public File makeSubDirectory(File dirBase, String strPrefix) throws Exception {
		
		File fileReturn = dirBase;
		@SuppressWarnings("unused")
		boolean isOK = true;
		Map<String,String> mapDate = DateUtil.getThisDateString();
		String[] strArrayDirNames = new String[2];
		strArrayDirNames[0] = mapDate.get("year");
		strArrayDirNames[1] = mapDate.get("month");
		
		if(dirBase.exists() == false) {
			isOK = fileReturn.mkdir();
		}
		for(String strDirName : strArrayDirNames) {
			fileReturn = new File(fileReturn.getAbsolutePath() + File.separator + strDirName);
			if(fileReturn.exists() == false) {
				isOK = fileReturn.mkdir();
			}
		}
		return fileReturn;
	}
	public boolean disableFormSubmit(String strFileName) throws Exception {
	    try {  
	    	String strBuffer = readFileContents(strFileName);
	    	strBuffer = strBuffer.replaceAll("form.submit","saveData");
	    	return writeFileContents(strFileName,strBuffer);
	    }  
	    catch (Exception ex) {  
	       return false;
	    }  
	}	
}
