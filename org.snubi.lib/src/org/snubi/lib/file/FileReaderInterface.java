/****************************************************************************************
 * File Name    : FileReaderInterface
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
import java.util.List;

public interface FileReaderInterface<T> {
	public List<T> read(File file,T param,boolean flagCRLF) throws Exception;
	public List<T> read(File file,T param) throws Exception;
	public String getEncodingChar()  throws Exception;
	public String getBuffer(String strCharset) throws Exception;
	public int getLength() throws Exception;
	public List<T> read(File file, T param, boolean flagCRLF, String delemeter) throws Exception;
}
