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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.snubi.lib.response.SnubiResponseCode;
import org.snubi.lib.response.SnubiResponseCode.ModelSnubiResponseCodeExtended;

public class JsonToSnubiResponseCode extends JsonToSnubiResponse<SnubiResponseCode> {
	
	@Override
	public Map<String,SnubiResponseCode> getList() throws Exception {
		return getList(this.clsSnubiResponse.getStrData());
	}
	@Override
	public Map<String,SnubiResponseCode> getList(Object strBuffer) throws Exception {
		
		//JSONArray clsJSONArray = (JSONArray)clsJSONParser.parse(strBuffer);		
		JSONArray clsJSONArray = (JSONArray)strBuffer;		
		for(int i = 0; i < clsJSONArray.size(); i ++ ) {
			
			SnubiResponseCode clsModelSnubiResponseCode = new SnubiResponseCode();
			JSONObject clsJSONObject = (JSONObject) clsJSONArray.get(i);
			clsModelSnubiResponseCode.setStrTag((String)clsJSONObject.get("tag"));
			clsJSONObject = (JSONObject)clsJSONObject.get("clsCodeSet");			
			
			if(clsJSONObject != null) {
				clsModelSnubiResponseCode.setStrCode((String)clsJSONObject.get("code"));				
				clsModelSnubiResponseCode.setStrName((String)clsJSONObject.get("name"));
				clsModelSnubiResponseCode.setStrDescription((String)clsJSONObject.get("description"));
			}			
			JSONObject clsJSONObjectForCatetory = (JSONObject)clsJSONObject.get("clsCodeCategory"); 
			if(clsJSONObjectForCatetory != null) {
				clsModelSnubiResponseCode.setStrSystem((String)clsJSONObjectForCatetory.get("system"));
				clsModelSnubiResponseCode.setStrSystemSub((String)clsJSONObjectForCatetory.get("systemSub"));
			}
			ModelSnubiResponseCodeExtended clsModelSnubiResponseCodeExtended = clsModelSnubiResponseCode.getClsModelSnubiResponseCodeExtended();
			JSONObject clsJSONObjectForExtended = (JSONObject)clsJSONObject.get("clsCodeExtended"); 
				if(clsJSONObjectForExtended != null) {
				clsModelSnubiResponseCodeExtended.setStrTelephone((String)clsJSONObjectForExtended.get("telephone"));
				clsModelSnubiResponseCodeExtended.setStrPost((String)clsJSONObjectForExtended.get("post"));
				clsModelSnubiResponseCodeExtended.setStrAddress((String)clsJSONObjectForExtended.get("address"));
				clsModelSnubiResponseCodeExtended.setStrHomePage((String)clsJSONObjectForExtended.get("homepage"));
				clsModelSnubiResponseCode.setClsModelSnubiResponseCodeExtended(clsModelSnubiResponseCodeExtended);
			}
			mapSnubiResponseCode.put(clsModelSnubiResponseCode.getStrTag(),clsModelSnubiResponseCode);
		}		
		return mapSnubiResponseCode; 
	}
	@Override
	public SnubiResponseCode find(String strTag) throws Exception {
		return mapSnubiResponseCode.get(strTag);
	}	
}
