/**************************************************************************************** 
 * File Name    : PropertiesReader.java
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
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {
	
	Properties properties = null;
	/**
	 * load
	 * parameter 가 String 파일이름일 경우 properties 멤버변수를 설정하지만,
	 * 호출하는 곳에서 properties 를 받아 직접 처리해도 상관없음 
	 * @param properetiesFile
	 * @return
	 * @throws Exception
	 */
	public Properties load(String strProperetiesFile) throws Exception {
        File fileTarget = new File(strProperetiesFile);  
		boolean isExists = fileTarget.exists(); 
		if(isExists) { 
			return this.load(fileTarget);
		} else { 
			throw new Exception("설정파일이 없습니다."); 
		}		
    }
    public Properties load(File strProperetiesFile) throws Exception {
    	this.properties = new Properties();
        FileInputStream fis = new FileInputStream(strProperetiesFile);
        this.properties.load(fis);    
        fis.close();
        return this.properties;
    }	
    /**
     * properties중 key 에 해당하는 값을 String으로 리턴한다.
     * @param key
     * @return String 으로 리턴됨에 유의하라. 형변환은 호출자가 처리해야 함.
     * @throws Exception
     */
	public String get(String strKey) throws Exception {
		return this.properties.getProperty(strKey);
	}
	/**
	 * properties 전체값을 Map으로 리턴한다.
	 * 2017.05.05 :  Map으로 변환하지 않고, Properties 를 리턴하도록 한다.
	 * @auth mh.choi
	 * @return
	 * @throws Exception
	 * 
	 */
	public Properties get() throws Exception {
		return this.properties;
		/*
		Map<String,String> propertiesMap = new HashMap<String,String>();
        for(Object key : this.getAllKeys()) {
            propertiesMap.put((String) key,this.properties.getProperty((String)key));
        }		
		return propertiesMap;
		*/
	}
	/**
	 * properties 내 전체 key를 리턴한다.
	 * @return
	 * @throws Exception
	 */
	public Set<Object> getAllKeys() throws Exception {
        Set<Object> keys = this.properties.keySet();
        return keys;
    }	
}

