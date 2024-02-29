/**************************************************************************************** 
 * File Name    : HttpUtilPost.java
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
package org.snubi.lib.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.snubi.lib.json.JsonUtil;
import org.snubi.lib.misc.Misc;
import org.snubi.lib.response.SnubiResponse;
import org.snubi.lib.response.json.JsonToSnubiResponseResult;
import java.io.PrintWriter;

public class HttpUtilPost<T> extends HttpUtil {
	public SnubiResponse post(T clsParameter) throws Exception {
		JsonUtil<T> clsJsonUtil = new JsonUtil<T>(); 
		return this.post(clsJsonUtil.toString(clsParameter));
	}
	
	@Override
	public SnubiResponse post(String strBody) throws Exception {
		StringBuffer sbufferBuffer = new StringBuffer();
		String strBuffer = new String();
		OutputStream clsOutputStream = null;
	    if(Misc.isEmtyString(this.getStrUrl()) == true) {
	    	throw new Exception("접속할 URL 주소가 지정되지 않았습니다.");
	    }
	    try {
	    	clsURL = new URL(this.getStrUrl());
	 	    clsHttpURLConnection = (HttpURLConnection)clsURL.openConnection();
	 	    clsHttpURLConnection.setRequestProperty("Content-Type", this.getStrType());
	 	    clsHttpURLConnection.setRequestMethod("POST");
	 	    clsHttpURLConnection.setDoOutput(true);
	 	    if(Misc.isEmtyString(this.getStrAuth()) == false) {
	 	    	clsHttpURLConnection.setRequestProperty("Authorization", this.getStrTokenType() + " " + this.getStrAuth());
	 	    }
	 	    clsHttpURLConnection.connect();
	 	    clsOutputStream = clsHttpURLConnection.getOutputStream();
	 	    clsOutputStream.write(strBody.getBytes(this.getStrCharset()));	   
	 	    clsOutputStream.flush();
	 	    clsOutputStream.close();				
	 	    clsBufferedReader = new BufferedReader(new InputStreamReader(clsHttpURLConnection.getInputStream(),this.getStrCharset()));
	 	    while ((strBuffer = clsBufferedReader.readLine()) != null) {
	 	    	sbufferBuffer.append(strBuffer);
	 	    }
	 	    JsonToSnubiResponseResult clsJsonToSnubiResponseResult = new JsonToSnubiResponseResult();
	 	    clsJsonToSnubiResponseResult.get(sbufferBuffer.toString());
	 	    return clsJsonToSnubiResponseResult.getClsSnubiResponse();
	    } catch(Exception Ex) {
	    	throw Ex;
	    } finally {
	    	try {clsOutputStream.close();         	} catch(Exception Ex) {}
	 	    try {clsBufferedReader.close();         } catch(Exception Ex) {}
	 	    try {clsHttpURLConnection.disconnect();	} catch(Exception Ex) {}
	    }
	}
	@Override
	public String postString(String strBody) throws Exception {
		StringBuffer sbufferBuffer = new StringBuffer();
		String strBuffer = new String();
		OutputStream clsOutputStream = null;
	    if(Misc.isEmtyString(this.getStrUrl()) == true) {
	    	throw new Exception("접속할 URL 주소가 지정되지 않았습니다.");
	    }
	    try {
	    	clsURL = new URL(this.getStrUrl());
	 	    clsHttpURLConnection = (HttpURLConnection)clsURL.openConnection();
	 	    clsHttpURLConnection.setRequestProperty("Content-Type", this.getStrType());
	 	    clsHttpURLConnection.setRequestMethod("POST");
	 	    clsHttpURLConnection.setDoOutput(true);
	 	    if(Misc.isEmtyString(this.getStrAuth()) == false) {
	 	    	clsHttpURLConnection.setRequestProperty("Authorization", this.getStrTokenType() + " " + this.getStrAuth());
	 	    }
	 	    clsHttpURLConnection.connect();
	 	    clsOutputStream = clsHttpURLConnection.getOutputStream();
	 	    clsOutputStream.write(strBody.getBytes(this.getStrCharset()));	   
	 	    clsOutputStream.flush();
	 	    clsOutputStream.close();				
	 	    clsBufferedReader = new BufferedReader(new InputStreamReader(clsHttpURLConnection.getInputStream(),this.getStrCharset()));
	 	    while ((strBuffer = clsBufferedReader.readLine()) != null) {
	 	    	sbufferBuffer.append(strBuffer);
	 	    }	 	    
	 	    return sbufferBuffer.toString();
	    } catch(Exception Ex) {
	    	throw Ex;
	    } finally {
	    	try {clsOutputStream.close();         	} catch(Exception Ex) {}
	 	    try {clsBufferedReader.close();         } catch(Exception Ex) {}
	 	    try {clsHttpURLConnection.disconnect();	} catch(Exception Ex) {}
	    }
	}
	@Override
	public SnubiResponse post(String strBody,File file) throws Exception {
		
		String boundary = "^-----^";
        String LINE_FEED = "\r\n";
        String charset = "UTF-8";        
        PrintWriter writer;		
		StringBuffer sbufferBuffer = new StringBuffer();
		String strBuffer = new String();
		OutputStream clsOutputStream = null;
		
		BufferedReader clsBufferedReader = null;
		HttpURLConnection clsHttpURLConnection = null;
		if(Misc.isEmtyString(this.getStrUrl()) == true) {
	    	throw new Exception("접속할 URL 주소가 지정되지 않았습니다.");
	    }
	    try {
	       URL 	clsURL = new URL(this.getStrUrl());
	       clsHttpURLConnection = (HttpURLConnection)clsURL.openConnection();
	 	   clsHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary=" + boundary);
	 	   clsHttpURLConnection.setRequestMethod("POST");
	 	   clsHttpURLConnection.setDoInput(true);
	 	   clsHttpURLConnection.setDoOutput(true);
	 	   clsHttpURLConnection.setUseCaches(false);
	 	   clsHttpURLConnection.setConnectTimeout(15000);
	 	   
	 	   clsOutputStream = clsHttpURLConnection.getOutputStream();
	 	   writer = new PrintWriter(new OutputStreamWriter(clsOutputStream, charset), true);
	 	  /** Body에 데이터를 넣어줘야 할경우 없으면 Pass **/
           writer.append("--" + boundary).append(LINE_FEED);
           writer.append("Content-Disposition: form-data; name=\"cdmDto\"").append(LINE_FEED);
           writer.append("Content-Type: application/json; charset=" + charset).append(LINE_FEED);
           writer.append(LINE_FEED);
           writer.append(strBody).append(LINE_FEED);
           writer.flush();

           /** 파일 데이터를 넣는 부분**/
           writer.append("--" + boundary).append(LINE_FEED);
           writer.append("Content-Disposition: form-data; name=\"cdmFile\"; filename=\"" + file.getName() + "\"").append(LINE_FEED);
           writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(file.getName())).append(LINE_FEED);
           writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
           writer.append(LINE_FEED);
           writer.flush();

           FileInputStream inputStream = new FileInputStream(file);
           byte[] buffer = new byte[(int)file.length()];
           int bytesRead = -1;
           while ((bytesRead = inputStream.read(buffer)) != -1) {
        	   clsOutputStream.write(buffer, 0, bytesRead);
           }
           clsOutputStream.flush();
           inputStream.close();
           writer.append(LINE_FEED);
           writer.flush();

           writer.append("--" + boundary + "--").append(LINE_FEED);
           writer.close();
	 	    
	 	    clsOutputStream.write(strBody.getBytes("UTF-8"));	   
	 	    clsOutputStream.flush();
	 	    clsOutputStream.close();				
	 	    clsBufferedReader = new BufferedReader(new InputStreamReader(clsHttpURLConnection.getInputStream(),"UTF-8"));
	 	    while ((strBuffer = clsBufferedReader.readLine()) != null) {
	 	    	sbufferBuffer.append(strBuffer);
	 	    }
	 	    JsonToSnubiResponseResult clsJsonToSnubiResponseResult = new JsonToSnubiResponseResult();
	 	    clsJsonToSnubiResponseResult.get(sbufferBuffer.toString());
	 	    return clsJsonToSnubiResponseResult.getClsSnubiResponse();
	    } catch(Exception Ex) {
	    	throw Ex;
	    } finally {
	    	try {clsOutputStream.close();         	} catch(Exception Ex) { }
	 	    try {clsBufferedReader.close();         } catch(Exception Ex) { }
	 	    try {clsHttpURLConnection.disconnect();	} catch(Exception Ex) { }
	    }
	}
	@Override
	public SnubiResponse get() throws Exception {
		throw new Exception("지원하지 않는 method");
	}	
}
