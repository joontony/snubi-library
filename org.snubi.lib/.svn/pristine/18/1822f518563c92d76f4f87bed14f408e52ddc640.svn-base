/**************************************************************************************** 
 * File Name    : JsonToModelSnubiResponseCode.java
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

import java.util.Map;
import org.snubi.lib.response.SnubiResponseJwt;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;

public class JsonToSnubiResponseJwt extends JsonToSnubiResponse<SnubiResponseJwt> {
	
	@Override
	public Map<String,SnubiResponseJwt> getList() throws Exception {
       return this.getList(this.clsSnubiResponse.getStrToken());
	}
	@Override
	//public Map<String,SnubiResponseJwt> getList(String strBuffer) throws Exception {
	public Map<String,SnubiResponseJwt> getList(Object strBuffer) throws Exception {
		String[] arrayString = ((String) strBuffer).split("\\.");
	    String strBody = arrayString[1];
	    Base64 clsBase64 = new Base64(true);
	    String strBodyBuffer = new String(clsBase64.decode(strBody));
	    SnubiResponseJwt clsSnubiResponseJwt = new SnubiResponseJwt();
	    JSONObject clsJSONObject = (JSONObject)clsJSONParser.parse(strBodyBuffer);
	    clsSnubiResponseJwt.setStrSub((String)clsJSONObject.get("sub"));
	    clsSnubiResponseJwt.setStrName((String)clsJSONObject.get("name"));
	 	clsSnubiResponseJwt.setStrId((String)clsJSONObject.get("id"));
	    clsSnubiResponseJwt.setLongExp((Long)clsJSONObject.get("exp"));
	    clsSnubiResponseJwt.setStrTitle((String)clsJSONObject.get("title"));
	    clsSnubiResponseJwt.setStrDepartment((String)clsJSONObject.get("department"));
	    clsSnubiResponseJwt.setStrOrganization((String)clsJSONObject.get("organization"));
	    mapSnubiResponseCode.put("data",clsSnubiResponseJwt);
	    return mapSnubiResponseCode;
	}
	@Override
	public SnubiResponseJwt find(String strTag) throws Exception {
		return mapSnubiResponseCode.get(strTag);
	}	
}
