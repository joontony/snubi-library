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

public interface FileListInterface {
	public File makeSubDirectory(File baseDirectory,String prefix) throws Exception;
	public File[] get(File directory) throws Exception;	
	public boolean move(File file, File directory) throws Exception;
}
