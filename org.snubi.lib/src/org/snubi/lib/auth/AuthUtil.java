/****************************************************************************************
 * File Name    : AuthUtil
 * Function     :
 * Author       : 최명호
 * Tester       :
 * Page         :
 * Target       :
 * Description  :
 * Modification Log
 * ======================================================================================
 * Ver  Date        	Author     	Modification
 * ======================================================================================
   1.0 	2019.06.17		최명호	 	파일생성
   1.1 	2020.09.22		최명호	 	디바이스정보 조회시 SystemTypeCode 를 추가함.
   1.2	2021.07.13		최명호 		systemTypeVersion 추가
   1.2	2021.09.06		최명호 		조회시 mobile/email추가
****************************************************************************************/
package org.snubi.lib.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.snubi.lib.http.HttpUtilGet;
import org.snubi.lib.http.HttpUtilPost;
import org.snubi.lib.response.SnubiResponse;

public class AuthUtil {

	private final static String _UTF_8_ = "UTF-8";
	private final static String _JSON_ 	= "application/json";

	public static Map<String,List<String>> getDeviceID(String strUrl,String strToken) throws Exception {
		System.out.println("------------------------------------ strUrl " + strUrl);
		System.out.println("------------------------------------ strToken " + strToken);
		HttpUtilGet clsHttpUtilGet = new HttpUtilGet();
		clsHttpUtilGet.setStrUrl			(strUrl		);
		clsHttpUtilGet.setStrAuth			(strToken	);
		clsHttpUtilGet.setStrCharset		(_UTF_8_	);
		clsHttpUtilGet.setStrType			(_JSON_		);
		List<String> listDeviceID 			= new ArrayList<String>();
		List<String> listOsCode 			= new ArrayList<String>();
		List<String> listSystemTypeCode 	= new ArrayList<String>();
		List<String> listSystemTypeVersion 	= new ArrayList<String>();
		List<String> listMobile			 	= new ArrayList<String>();
		List<String> listEmail			 	= new ArrayList<String>();
		SnubiResponse clsSnubiResponse 		= clsHttpUtilGet.get();

		if(clsSnubiResponse.getStrData() != null) {
			JSONParser 		clsJSONParser 	= new JSONParser();
			System.out.println("------------------------------------" + clsSnubiResponse.getStrData().toString());
			Object 			clsObject 		= clsJSONParser.parse(clsSnubiResponse.getStrData().toString());
			JSONObject 		clsJSONObject 	= (JSONObject) clsObject;
			JSONArray 		clsJSONArray	= (JSONArray) clsJSONObject.get("listAuthMemberDevice");
//			DESC : 이메일
			listEmail.add(clsJSONObject.get("email") == null ? "" : (String) clsJSONObject.get("email"));

			for(int i = 0; i < clsJSONArray.size(); i ++) {
				JSONObject clsJSONObjectElement = (JSONObject) clsJSONArray.get(i);
				listDeviceID.add((String) clsJSONObjectElement.get("deviceId"));
				listOsCode.add(clsJSONObjectElement.get("osCode") == null ? "ios" : (String) clsJSONObjectElement.get("osCode"));
				listSystemTypeCode.add(clsJSONObjectElement.get("systemTypeCode") == null ? "beans" : (String) clsJSONObjectElement.get("systemTypeCode"));
				listSystemTypeVersion.add(clsJSONObjectElement.get("systemTypeVersion") == null ? "1.0" : (String) clsJSONObjectElement.get("systemTypeVersion"));
				listMobile.add(clsJSONObjectElement.get("mobile") == null ? "" : (String) clsJSONObjectElement.get("mobile"));
			}
		}
		Map<String,List<String>> mapDeviceInfo = new HashMap<String,List<String>>();
		mapDeviceInfo.put("deviceId"			, listDeviceID			);
		mapDeviceInfo.put("osCode"				, listOsCode			);
		mapDeviceInfo.put("systemTypeCode"		, listSystemTypeCode	);
		mapDeviceInfo.put("systemTypeVersion"	, listSystemTypeVersion	);
		mapDeviceInfo.put("mobile"				, listMobile			);
		mapDeviceInfo.put("email"				, listEmail				);
		return mapDeviceInfo;
	}
	public static SnubiResponse login(String strUrl,String strEmail,String strPassword) throws Exception {
		HttpUtilPost<LoginPacket> clsHttpUtilPost = new HttpUtilPost<LoginPacket>();
		clsHttpUtilPost.setStrUrl(strUrl);
		clsHttpUtilPost.setStrCharset(_UTF_8_);
		clsHttpUtilPost.setStrType(_JSON_);
		return clsHttpUtilPost.post(new LoginPacket(strEmail,strPassword));
	}
}
