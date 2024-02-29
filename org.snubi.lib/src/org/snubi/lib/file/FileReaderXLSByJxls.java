/****************************************************************************************
 * File Name    : FileReaderXLSByJxls
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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;

public class FileReaderXLSByJxls<T> implements FileReaderInterface<T> {

	@SuppressWarnings("unchecked")
	public List<T> read(File xlsFile, File xmlFile,T param) throws Exception {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		try {
			XLSReader xlsReader = ReaderBuilder.buildFromXML(xmlFile);
			List<T> result = new ArrayList<T>();
			mapResult.put("datas", result);
		    InputStream inputStream = new BufferedInputStream(new FileInputStream(xlsFile));
		    xlsReader.read(inputStream, mapResult);
		    List<T> listModelEmrPatient = (List<T>) mapResult.get("datas");
		    return (List<T>) listModelEmrPatient;
		} catch(Exception Ex) {
			Ex.printStackTrace();
		}
		return null;
	}
	@Override
	public List<T> read(File file,T param,boolean flag) throws Exception {
		throw new Exception("not supported");
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
