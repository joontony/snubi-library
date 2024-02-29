/**************************************************************************************** 
 * File Name    : PropertiesSystem.java
 * Function     : 
 * Author       : mh.choi
 * Tester       : 
 * Page         : 
 * Target       : 
 * Description  : 프로퍼티 파일을 READ 후, 결과를 MAP 으로 리턴함.
 * Modification Log
 * =============================================================== 
 * Ver  Date        Author     Modification
 * ===============================================================
   1.0  2018.05.02  mh.choi    Create
****************************************************************************************/
package org.snubi.lib.properties;

import java.io.File;

public class PropertiesSystem {
	
	static public void print() {
		System.getProperties().list(System.out);
	}
	static public String getOSUpperCase() {		
		return System.getProperty("os.name").toUpperCase();
	}
	static public String getHomeDir() {		
		return System.getProperty("user.home");
	}
	static public String getFileSeperator() {
		return File.separator;
	}
}
