/****************************************************************************************
 * File Name    : HttpUtilGet.java
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
package org.snubi.lib.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.snubi.lib.misc.Misc;
import org.snubi.lib.response.SnubiResponse;
import org.snubi.lib.response.json.JsonToSnubiResponseResult;

public class HttpUtilGet extends HttpUtil {

	@Override
	public SnubiResponse get() throws Exception {
		StringBuffer sbufferBuffer = new StringBuffer();
		String strBuffer = new String();
	    if(Misc.isEmtyString(this.getStrUrl()) == true) {
	    	throw new Exception("접속할 URL 주소가 지정되지 않았습니다.");
	    }
	    try {
	    	clsURL = new URL(this.getStrUrl());
		    clsHttpURLConnection = (HttpURLConnection)clsURL.openConnection();
		    clsHttpURLConnection.setRequestProperty("Accept", this.getStrType());
		    clsHttpURLConnection.setRequestMethod("GET");
		    if(Misc.isEmtyString(this.getStrAuth()) == false) {
		    	clsHttpURLConnection.setRequestProperty("Authorization", this.getStrTokenType() + " " + this.getStrAuth());
		    }
		    clsHttpURLConnection.connect();

		    clsBufferedReader = new BufferedReader(new InputStreamReader(clsHttpURLConnection.getInputStream(),this.getStrCharset()));
		    while ((strBuffer = clsBufferedReader.readLine()) != null) {
		    	sbufferBuffer.append(strBuffer);
		    }
		    JsonToSnubiResponseResult clsJsonToSnubiResponseResult = new JsonToSnubiResponseResult();
		    clsJsonToSnubiResponseResult.get(sbufferBuffer.toString());
		    return clsJsonToSnubiResponseResult.getClsSnubiResponse();
	    } catch(Exception Ex) {
	    	Ex.printStackTrace();
	    	throw Ex;
	    } finally {
	 	    try {clsBufferedReader.close();         } catch(Exception Ex) {Ex.printStackTrace();}
	 	    try {clsHttpURLConnection.disconnect();	} catch(Exception Ex) {Ex.printStackTrace();}
	    }
	}
	@Override
	public SnubiResponse post(String strBody) throws Exception {
		throw new Exception("지원하지 않는 method");
	}
	public String downloadWithString() throws Exception {
		StringBuffer sbufferBuffer = new StringBuffer();
		String strBuffer = new String();
	    if(Misc.isEmtyString(this.getStrUrl()) == true) {
	    	throw new Exception("접속할 URL 주소가 지정되지 않았습니다.");
	    }
		try {
			clsURL = new URL(this.getStrUrl());
		    clsHttpURLConnection = (HttpURLConnection)clsURL.openConnection();
		    clsHttpURLConnection.setRequestProperty("Accept", this.getStrType());
		    clsHttpURLConnection.setRequestMethod("GET");
		    if(Misc.isEmtyString(this.getStrAuth()) == false) {
		    	clsHttpURLConnection.setRequestProperty("Authorization", this.getStrTokenType() + " " + this.getStrAuth());
		    }
		    clsHttpURLConnection.connect();
		    clsBufferedReader = new BufferedReader(new InputStreamReader(clsHttpURLConnection.getInputStream(),this.getStrCharset()));
		    while ((strBuffer = clsBufferedReader.readLine()) != null) {
		    	sbufferBuffer.append(strBuffer);
		    }
		} catch(Exception Ex) {
			Ex.printStackTrace();
		} finally {
	 	    try {clsBufferedReader.close();         } catch(Exception Ex) {}
	 	    try {clsHttpURLConnection.disconnect();	} catch(Exception Ex) {}
	    }
		return sbufferBuffer.toString();
	}
	@Override
	public SnubiResponse post(String strBody, File file) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String postString(String strBody) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
