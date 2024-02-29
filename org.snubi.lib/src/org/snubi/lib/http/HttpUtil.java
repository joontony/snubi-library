/****************************************************************************************
 * File Name    : HttpUtil.java
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
import java.net.HttpURLConnection;
import java.net.URL;

import org.snubi.lib.misc.Misc;
import org.snubi.lib.response.SnubiResponse;

public abstract class HttpUtil {

	private final 	String 				_DEFAULT_TOKEN_TYPE_ 	= "Bearer";
    private final 	String 				_DEFAULT_TYPE_ 			= "application/json";
    private final 	String 				_DEFAULT_CAHRSET_ 		= "UTF-8";
	protected		URL 				clsURL 					= null;
    protected		HttpURLConnection 	clsHttpURLConnection 	= null;
    protected		BufferedReader 		clsBufferedReader 		= null;
    private			String 				strUrl 					= null;
    private			String 				strType 				= null;
    private			String 				strCharset 				= null;
    private			String 				strAuth 				= null;
    private			String 				strTokenType 			= null;

    public abstract SnubiResponse get() throws Exception;
    public abstract SnubiResponse post(String strBody) throws Exception;
    public abstract String postString(String strBody) throws Exception;
    public abstract SnubiResponse post(String strBody, File file) throws Exception;

    public URL getClsURL() {
		return clsURL;
	}
	public void setClsURL(URL clsURL) {
		this.clsURL = clsURL;
	}
	public HttpURLConnection getClsHttpURLConnection() {
		return clsHttpURLConnection;
	}
	public void setClsHttpURLConnection(HttpURLConnection clsHttpURLConnection) {
		this.clsHttpURLConnection = clsHttpURLConnection;
	}
	public BufferedReader getClsBufferedReader() {
		return clsBufferedReader;
	}
	public void setClsBufferedReader(BufferedReader clsBufferedReader) {
		this.clsBufferedReader = clsBufferedReader;
	}
	public String getStrTokenType() {
		return Misc.isEmtyString(strTokenType) == true ? _DEFAULT_TOKEN_TYPE_ : strTokenType;
	}
	public void setStrTokenType(String strTokenType) {
		this.strTokenType = strTokenType;
	}
	public String getStrType() {
		return Misc.isEmtyString(strType) == true ? _DEFAULT_TYPE_ : strType;
	}
	public String getStrCharset() {
		return Misc.isEmtyString(strCharset) == true ? _DEFAULT_CAHRSET_ : strCharset;
	}
	public void setStrType(String strType) {
		this.strType = strType;
	}
	public void setStrCharset(String strCharset) {
		this.strCharset = strCharset;
	}
	public String getStrAuth() {
		return strAuth;
	}
	public void setStrAuth(String strAuth) {
		this.strAuth = strAuth;
	}
	public String getStrUrl() {
		return strUrl;
	}
	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}
}
