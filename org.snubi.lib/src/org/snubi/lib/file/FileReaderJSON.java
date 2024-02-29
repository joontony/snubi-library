/****************************************************************************************
 * File Name    : FileReaderJSON
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
   1.0  2018.05.08  mh.choi     Create
****************************************************************************************/
package org.snubi.lib.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileReaderJSON<T> implements FileReaderInterface<T> {

	@SuppressWarnings("unchecked")
	@Override
	public List<T> read(File file,T param,boolean flag) throws Exception {
		List<T> listT = new ArrayList<T>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			T parsedObject = (T) mapper.readValue(file,(Class<T>) param);
			listT.add(parsedObject);
		} catch(Exception Ex) {
			Ex.printStackTrace();
		}
		return listT;
	}
	@Override
	public String getEncodingChar() throws Exception {
		throw new Exception("not supported");
	}
	@Override
	public String getBuffer(String strCharset) throws Exception {
		throw new Exception("not supported");
	}
	@Override
	public int getLength() throws Exception {
		return 0;
	}
	@Override
	public List<T> read(File file, T param) throws Exception {
		return read(file,param, false);
	}
	@Override
	public List<T> read(File file, T param, boolean flagCRLF, String delemeter) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
