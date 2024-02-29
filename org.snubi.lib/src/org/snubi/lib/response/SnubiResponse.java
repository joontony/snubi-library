/**************************************************************************************** 
 * File Name    : ModelSnubiResponse.java
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
package org.snubi.lib.response;


public class SnubiResponse {
	
	String strCode		;
	Object strData		;
	String strMessage	;
	String strToken		;
	String strBuffer	;
	
	public String getStrBuffer() {
		return strBuffer;
	}
	public void setStrBuffer(String strBuffer) {
		this.strBuffer = strBuffer;
	}
	public String getStrToken() {
		return strToken;
	}
	public void setStrToken(String strToken) {
		this.strToken = strToken;
	}
	public String getStrCode() {
		return strCode;
	}
	public Object getStrData() {
		return strData;
	}
	public String getStrMessage() {
		return strMessage;
	}
	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}
	public void setStrData(Object strData) {
		this.strData = strData;
	}
	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}
	@Override
	public String toString() {
		return "SnubiResponse [strCode=" + strCode + ", strData=" + strData + ", strMessage=" + strMessage
				+ ", strToken=" + strToken + ", strBuffer=" + strBuffer + "]";
	}
	public void print() {
		System.out.println("code    : [" + this.getStrCode() 	+ "]");
		System.out.println("token   : [" + this.getStrToken() 	+ "]");
		System.out.println("message : [" + this.getStrMessage() + "]");
		System.out.println("data    : [" + this.getStrData() 	+ "]");
	}
}