/****************************************************************************************
 * File Name    : FileListInterface
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
   1.0  2018.04.04  mh.choi     Create
****************************************************************************************/
package org.snubi.lib.file;

import java.io.File;
import java.util.List;

public interface FileUtilInterface {

	public File makeSubDirectory(File baseDirectory,String prefix) throws Exception;
	public File[] get(File directory) throws Exception;
	public List<File> get(String strBaseDiectory) throws Exception;
	public List<File> get(String strBaseDiectory,boolean isChecked) throws Exception;
	public boolean moveToDirectory(File file, File directory) throws Exception;
	public boolean moveFile(File fileSource, File fileTarget) throws Exception;
}
