/****************************************************************************************
 * File Name    : JsonUtil.java
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
   1.0  2018.05.28  mh.choi    Create
****************************************************************************************/
package org.snubi.lib.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil<T> {

	public String toString(T clsParameter) throws Exception {
		ObjectMapper clsObjectMapper = new ObjectMapper();
		String strJson = clsObjectMapper.writeValueAsString(clsParameter);
		return strJson;
	}
	public T toObject(String strJson, Class<T> clsClassType) throws Exception {
		ObjectMapper clsObjectMapper = new ObjectMapper();
		T clsParameter = (T) clsObjectMapper.readValue(strJson,clsClassType);
		return clsParameter;
	}
	public T httpParameterMapToObject(Map<String,String[]> httpParamterMap,Class<T> clsClassType) throws Exception {
		Map<String,String> mapToParing = new HashMap<String,String>();
//		DESC >> String[] 을 String 으로 변경한다.
		for(String key : httpParamterMap.keySet()){
			mapToParing.put(key, httpParamterMap.get(key)[0]);
        }
		ObjectMapper clsObjectMapper = new ObjectMapper();
		T clsParameter = clsObjectMapper.convertValue(mapToParing, clsClassType);
//		String jsonString = clsObjectMapper.writeValueAsString(mapToParing);
//		T clsParameter = (T) clsObjectMapper.readValue(jsonString,clsClassType);
		return clsParameter;

	}

}