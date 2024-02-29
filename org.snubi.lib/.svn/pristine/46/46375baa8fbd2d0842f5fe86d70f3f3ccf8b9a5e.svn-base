/**************************************************************************************** 
 * File Name    : JsonToModelSnubiResponse.java
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
   1.0  2018.05.25  mh.choi    Create
****************************************************************************************/
package org.snubi.lib.response.json;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.snubi.lib.response.SnubiResponse;

public abstract class JsonToSnubiResponse<T> {
	
	Map<String,T> mapSnubiResponseCode = new HashMap<String,T>();
	SnubiResponse clsSnubiResponse = new SnubiResponse();
	JSONParser clsJSONParser = new JSONParser();
	
	public SnubiResponse getClsSnubiResponse() {
		return clsSnubiResponse;
	}
	public void setClsSnubiResponse(SnubiResponse clsSnubiResponse) {
		this.clsSnubiResponse = clsSnubiResponse;
	}
	public SnubiResponse get(String strBuffer)  {
		this.clsSnubiResponse.setStrBuffer(strBuffer);
		try {
			clsJSONParser = new JSONParser();
			JSONObject clsJSONObject = (JSONObject)clsJSONParser.parse(strBuffer);
			this.clsSnubiResponse.setStrCode	((String)clsJSONObject.get("code"	));		
			this.clsSnubiResponse.setStrToken	((String)clsJSONObject.get("token"	));
			this.clsSnubiResponse.setStrMessage	((String)clsJSONObject.get("message"));
			this.clsSnubiResponse.setStrData	(clsJSONObject.get("data"));
		} catch(Exception Ex) {
			this.clsSnubiResponse.setStrCode	("500");		
			this.clsSnubiResponse.setStrToken	("");
			this.clsSnubiResponse.setStrMessage	("처리중오류발생(Ex)");
		}
		return clsSnubiResponse;
	}
	public abstract Map<String,T> getList() throws Exception;
	public abstract Map<String,T> getList(Object strBuffer) throws Exception;
	public abstract T find(String strTag) throws Exception;	
}
