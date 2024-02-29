/**************************************************************************************** 
 * File Name    : CodeUtil.java
 * Function     : 
 * Author       : mh.choi
 * Tester       : 
 * Page         : 
 * Target       : 
 * Description  : 실코드 연동전에 고정코드로 조회 루틴을 구현함
 * Modification Log
 * =============================================================== 
 * Ver  Date        Author     Modification
 * ===============================================================
   1.0  2018.04.04  mh.choi    Create
****************************************************************************************/
package org.snubi.lib.code;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.snubi.lib.http.HttpUtil;
import org.snubi.lib.http.HttpUtilGet;
import org.snubi.lib.response.SnubiResponse;
import org.snubi.lib.response.SnubiResponseCode;
import org.snubi.lib.response.json.JsonToSnubiResponse;
import org.snubi.lib.response.json.JsonToSnubiResponseCode;
// jjang
public class CodeUtil {
		
	static JsonToSnubiResponse<SnubiResponseCode> clsJsonToModelSnubiResponse = new JsonToSnubiResponseCode();
	
	public static Map<String,SnubiResponseCode> get(String strAuth,Map<String,String> mapParam) throws Exception {
		HttpUtil clsHttpUtil = new HttpUtilGet();
		String strUrl = mapParam.get("URL");
		clsHttpUtil.setStrUrl(strUrl);
		clsHttpUtil.setStrAuth(strAuth);
		SnubiResponse clsSnubiResponse = clsHttpUtil.get();
		return clsJsonToModelSnubiResponse.getList(clsSnubiResponse.getStrData());
	}
	// DESC >> 미리 메모리에 저장된 코드정보를 Tag 이름을 통해 검색하여 리턴한다.
	public static SnubiResponseCode get(String strTag) throws Exception {
		return clsJsonToModelSnubiResponse.find(strTag);
	}
	public static String toString(Map<String,SnubiResponseCode> mapSnubiResponseCode) {
		StringBuilder stringBuilder = new StringBuilder();
		Iterator<Entry<String, SnubiResponseCode>> clsIterator = mapSnubiResponseCode.entrySet().iterator();
		while(clsIterator.hasNext()) {
		    Entry<String, SnubiResponseCode> clsEntryKV = clsIterator.next();
		   stringBuilder
					.append("tag [" + clsEntryKV.getKey() + "],")
					.append("code [" + clsEntryKV.getValue().getStrCode() + "],")
					.append("name [" + clsEntryKV.getValue().getStrName() + "],")
					.append("description [" + clsEntryKV.getValue().getStrDescription() + "]\r\n");
		}		
		return stringBuilder.toString();
	}
}
