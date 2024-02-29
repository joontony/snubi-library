/**************************************************************************************** 
 * File Name    : FileWriterJSON
 * Function     : 
 * Author       : mh.choi
 * Tester       : 
 * Page         : 
 * Target       : 
 * Description  : 
 * Modification Log
 * ====================================================================================== 
 * Ver  Date        Author     Modification
 * ======================================================================================
   1.0  2018.05.08  mh.choi     Create
   1.0  2019.06.29	최명호		프로그램종료시 파일삭제 오류 수정
****************************************************************************************/
package org.snubi.lib.file;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileWriterJSON<T> extends FileWriterInterface {
	
	@SuppressWarnings("unchecked")
	public boolean write(String strFileName,String strTagName,T classParameter) throws Exception {
		JSONObject clsJSONObject = new JSONObject();
		clsJSONObject.put(strTagName,classParameter);
		final ByteArrayOutputStream clsByteArrayOutputStream = new ByteArrayOutputStream();
	    final ObjectMapper clsObjectMapper = new ObjectMapper();
	    clsObjectMapper.writeValue(clsByteArrayOutputStream, clsJSONObject);
	    final byte[] arrBytes = clsByteArrayOutputStream.toByteArray();
	    File fileOutput = new File(strFileName);
//	    FIXME >> 아래 코드는 종료시 파일이 삭제되는 현상과 관련된것으로 보암
//	    fileOutput.deleteOnExit();
//	    if(fileOutput.exists() == true) {
//	    	fileOutput.delete();
//	    }
	    this.writeFile(strFileName,new String(arrBytes));
	    clsByteArrayOutputStream.close();
		return fileOutput.exists();
	}
	public boolean writeFile(String strFileName,String strContents) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(strFileName, true));
	    writer.append(' ');
	    writer.append(strContents);
	    writer.close();
	    return true;
	}
	@Override
	public String write(Map<String, Object> mapParameter) throws Exception {
		return null;
	}
}